package Grupo11.DDS_TP_Integrador.Rankings;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Collections;
import Grupo11.DDS_TP_Integrador.Entidades.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;

import Grupo11.DDS_TP_Integrador.Entidades.*;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import org.springframework.beans.factory.annotation.Autowired;

public class GestorRankings {

    private List<RankingPromedioCierreIncidente> ranking1;
    private List<RankingMasIncidentes> ranking2;
    private List<RankingMayorImpacto> ranking3;

    private List<Entidad> entidades;
    private List<Comunidad> comunidades;

    @Autowired
    private RepoIncidentes repoIncidentes;

    public List<Entidad> calcularTiempoPromedioDeCierreIncidentes(){

        Comparator<Entidad> comparadorPorPromedioIncidente = Comparator.comparingLong((Entidad e) -> repoIncidentes.promedioIncidentes(e.getIncidentes_reportados()) );
        return entidades.stream().sorted(comparadorPorPromedioIncidente).toList();
    }

    public List<Entidad> calcularEntidadesConMasIncidentesReportados(){
        Comparator<Entidad> comparadorPorPromedioIncidente = Comparator.comparingLong((Entidad e) -> repoIncidentes.cantidadIncidentes(e.getIncidentes_reportados()));
        return entidades.stream().sorted(comparadorPorPromedioIncidente).toList();
    }

}

