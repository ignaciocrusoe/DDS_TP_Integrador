package CalculoRanking.Rankings;
import CalculoRanking.Entidades.Entidad;
import CalculoRanking.Incidentes.Incidente;
import CalculoRanking.Rankings.CalculadorRanking;
import CalculoRanking.Repositories.EntidadRepository;
import CalculoRanking.Repositories.RankingMayorImpactoRepository;
import CalculoRanking.Repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CalculadorRankingMayorImpacto extends CalculadorRanking {

    @Autowired
    RankingRepository rankingRepository;

    @Autowired
    EntidadRepository entidadRepository;

    @Autowired
    RankingMayorImpactoRepository rankingMayorImpactoRepository;

    Integer cnf = 2; //Debería ser parametrizable
    @Override
    public List<Entidad> calcularRanking(List<Entidad> entidades) {
        Comparator<Entidad> comparadorPorImpacto = Comparator.comparingLong((Entidad e) -> calcularImpacto(cnf, e));
        List<Entidad> entidadesOrdenadas = entidades.stream().sorted(comparadorPorImpacto).collect(Collectors.toList());
        Collections.reverse(entidadesOrdenadas);
        return entidadesOrdenadas;
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
                    return new RankingMayorImpacto(entidad, nuevoRanking, posicion, fechaActual);
                })
                .collect(Collectors.toList());

    }

    @Scheduled(cron = "0 0 0 ? * SUN")
    public void calcularRankingsSemanalmente() {
        int cnf = 1; //Acá habría que fijar el cnf que queremos usar en el cálculo semanal
        LocalDateTime fechaActual = LocalDateTime.now();
        List<Entidad> entidades = entidadRepository.findAll();
        List<Entidad> entidadesOrdenadas = calcularRanking(entidades);
        Ranking nuevoRanking = new Ranking();
        nuevoRanking.setTime(fechaActual);
        nuevoRanking.setTipoRanking(3);
        rankingRepository.save(nuevoRanking);
        List<RankingMayorImpacto> rankingsMayorImpacto = generarRanking(entidadesOrdenadas, nuevoRanking, cnf);
        rankingMayorImpactoRepository.saveAll(rankingsMayorImpacto);
    }

}
