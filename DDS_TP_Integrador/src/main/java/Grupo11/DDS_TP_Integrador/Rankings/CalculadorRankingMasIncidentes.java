package Grupo11.DDS_TP_Integrador.Rankings;

import Grupo11.DDS_TP_Integrador.Entidades.Entidad;
import Grupo11.DDS_TP_Integrador.Repositories.RankingMasIncidentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalculadorRankingMasIncidentes extends CalculadorRanking{
    /*
    @Override
    public List<Entidad> calcularRanking(List<Entidad> entidades) {
        Comparator<Entidad> comparadorPorPromedioIncidente = Comparator.comparingLong((Entidad e) -> incidenteProvider.cantidadIncidentes(e.getIncidentes_reportados()));
        return entidades.stream().sorted(comparadorPorPromedioIncidente).toList();
    }
    */
   @Autowired
   RankingMasIncidentesRepository rankingMasIncidentesRepository;

    @Override
    public List<Entidad> calcularRanking(List<Entidad> entidades) {

        LocalDateTime fechaActual = LocalDateTime.now();

        // Obtener la fecha y hora hace 7 días
        LocalDateTime fechaHace7Dias = fechaActual.minusDays(7);

        Comparator<Entidad> comparadorPorCantidadDeIncidentes = Comparator.comparingLong((Entidad e) -> incidenteProvider.cantidadIncidentes(e.getIncidentes_reportados_abierto_en_semana(fechaHace7Dias, fechaActual)));


        return entidades.stream()
                .sorted(comparadorPorCantidadDeIncidentes)
                .collect(Collectors.toList());
    }

    List<RankingMasIncidentes> generarRankingMasIncidente(List<Entidad> entidades, Ranking nuevoRanking)
    {
        LocalDateTime fechaActual = LocalDateTime.now();

        return entidades.stream()
                .map(entidad -> {
                    int posicion = entidades.indexOf(entidad) + 1; // le sumo uno para que arranque desde 1
                    return new RankingMasIncidentes(entidad, posicion, fechaActual, nuevoRanking.getId_ranking());
                })
                .collect(Collectors.toList());

    }

    public void guardarRankingMasIncidentes(List<Entidad> entidades, Ranking nuevoRanking){

        List<RankingMasIncidentes> ranking_mas_incidentes = this.generarRankingMasIncidente(entidades, nuevoRanking);

        for (RankingMasIncidentes ranking : ranking_mas_incidentes) {
            rankingMasIncidentesRepository.save(ranking);
        }

    }
}
