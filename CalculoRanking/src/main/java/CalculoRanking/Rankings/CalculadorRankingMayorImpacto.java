package CalculoRanking.Rankings;
import CalculoRanking.Entidades.Entidad;
import CalculoRanking.Incidentes.Incidente;
import CalculoRanking.Rankings.CalculadorRanking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalculadorRankingMayorImpacto extends CalculadorRanking {

    Integer cnf = 2; //Debería ser parametrizable
    @Override
    public List<Entidad> calcularRanking(List<Entidad> entidades) {
        Comparator<Entidad> comparadorPorImpacto = Comparator.comparingLong((Entidad e) -> calcularImpacto(cnf, e));
        return entidades.stream().sorted(comparadorPorImpacto).collect(Collectors.toList());
    }

    private Long calcularImpacto(Integer cnf, Entidad entidad){
        Long impacto = 0L;
        Long sumatoriaTiempoResolucion = 0L;
        Integer incidentesNoResueltos = entidad.getIncidentes_reportados().stream().filter(obj -> !obj.getEstado()).collect(Collectors.toList()).size();
        for(Incidente incidente : entidad.getIncidentes_reportados()){
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
                    return new RankingMayorImpacto(entidad, nuevoRanking, fechaActual);
                })
                .collect(Collectors.toList());

    }
}
