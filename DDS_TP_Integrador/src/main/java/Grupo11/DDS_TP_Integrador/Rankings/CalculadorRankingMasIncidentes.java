package Grupo11.DDS_TP_Integrador.Rankings;

import Grupo11.DDS_TP_Integrador.Entidades.Entidad;

import java.util.Comparator;
import java.util.List;

public class CalculadorRankingMasIncidentes extends CalculadorRanking{
    @Override
    public List<Entidad> calcularRanking(List<Entidad> entidades) {
        Comparator<Entidad> comparadorPorPromedioIncidente = Comparator.comparingLong((Entidad e) -> incidenteProvider.cantidadIncidentes(e.getIncidentes_reportados()));
        return entidades.stream().sorted(comparadorPorPromedioIncidente).toList();
    }
}
