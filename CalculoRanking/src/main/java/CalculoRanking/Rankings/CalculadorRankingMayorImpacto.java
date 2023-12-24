package CalculoRanking.Rankings;
import CalculoRanking.Entidades.Entidad;
import CalculoRanking.Incidentes.Incidente;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalculadorRankingMayorImpacto {

    Integer cnf = 2; //Debería ser parametrizable

    public List<Entidad> calcularRanking(List<Entidad> entidades, LocalDateTime inicioSemana, LocalDateTime finSemana) {
        Comparator<Entidad> comparadorPorImpacto = Comparator.comparingLong((Entidad e) -> calcularImpacto(cnf, e, inicioSemana, finSemana));
        List<Entidad> entidadesOrdenadas = entidades.stream().sorted(comparadorPorImpacto).collect(Collectors.toList());
        return entidadesOrdenadas;
    }

    private Long calcularImpacto(Integer cnf, Entidad entidad, LocalDateTime inicioSemana, LocalDateTime finSemana){

        Long impacto = 0L;
        Long sumatoriaTiempoResolucion = 0L;
        Integer incidentesNoResueltos = entidad.getIncidentes_reportados_en_semana(inicioSemana, finSemana).stream().filter(obj -> !obj.getEstado()).collect(Collectors.toList()).size();
        for(Incidente incidente : entidad.getIncidentes_reportados_en_semana(inicioSemana, finSemana)){
            sumatoriaTiempoResolucion += incidente.duracion();
        }
        impacto = sumatoriaTiempoResolucion + incidentesNoResueltos * cnf;
        return impacto;
    }

    public List<RankingMayorImpacto> generarRanking(List<Entidad> entidades, Ranking nuevoRanking, Integer cnf)
    {
        LocalDateTime fechaActual = LocalDateTime.now();
        List<RankingMayorImpacto> rankingsMayorImpacto;

        return entidades.stream()
                .map(entidad -> {
                    int posicion = entidades.indexOf(entidad) + 1; // le sumo uno para que arranque desde 1
                    return new RankingMayorImpacto(entidad, nuevoRanking, posicion, fechaActual);
                })
                .collect(Collectors.toList());

    }
}
