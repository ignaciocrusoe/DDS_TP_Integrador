package Grupo11.DDS_TP_Integrador.Rankings;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Collections;
import Grupo11.DDS_TP_Integrador.Entidades.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;

import Grupo11.DDS_TP_Integrador.Entidades.*;
import Grupo11.DDS_TP_Integrador.Incidentes.*;

public class GestorRankings {

    private RepoEntidades repoEntidades;
    private RepoComunidades repoComunidades;
    private InformeSemanal informeSemanal;

    public List<Entidad> calcularTiempoPromedioDeCierreIncidentes(){

        Comparator<Entidad> comparadorPorPromedioIncidente = Comparator.comparingLong((Entidad e) -> e.getRepoIncidentes().promedioIncidentes());
        return repoEntidades.getListaEntidades().stream().sorted(comparadorPorPromedioIncidente).toList();
    }


    //todo falta revisar el ranking 2, ni idea como hacerlo
//    public List<Entidad> calcularEntidadesConMasIncidentesReportados(){
//        Comparator<Entidad> comparadorPorCantidadDeIncidentes =  Comparator.comparing(Entidad::cantidadDeIncidentes);
//        return Collections.sort(repoEntidades.getListaEntidades(), comparadorPorCantidadDeIncidentes);
//    }
//    public void GestorRankings(RepoIncidentes repoIncidentes, RepoEntidades repoEntidades){
//        super();
//        this.repoIncidentes = repoIncidentes;
//        this.repoEntidades = repoEntidades;
//    }

    //todo: no se no anda, que cosa no anda?
    public void generarInforme(){
        informeSemanal.agregarListaPromedio(this.calcularTiempoPromedioDeCierreIncidentes());
        informeSemanal.agregarListaCantidad(this.calcularEntidadesConMasIncidentesReportados());
    }

    public void enviarInforme(){
        for (Entidad entidad: repoEntidades.getListaEntidades()) {
            entidad.recibirInforme();
        }
    }

    public InformeSemanal getInformeSemanal(){
        return informeSemanal;
    }
}

