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
    RepoIncidentes repoIncidentes;
    RepoEntidades repoEntidades;

    InformeSemanal informeSemanal;
    public int rankingSize;
//todo: arreglar

//    public List<Entidad> ranking1(){
//        Comparator<Entidad> comparadorPorPromedioIncidente = Comparator.comparing(Entidad::promedioIncidentes);
//        return Collections.sort(repoEntidades.getListaEntidades(), comparadorPorPromedioIncidente);
//    }
//    public List<Entidad> ranking2(){
//        Comparator<Entidad> comparadorPorCantidadDeIncidentes =  Comparator.comparing(Entidad::cantidadDeIncidentes);
//        return Collections.sort(repoEntidades.getListaEntidades(), comparadorPorCantidadDeIncidentes);
//    }
//    public void GestorRankings(RepoIncidentes repoIncidentes, RepoEntidades repoEntidades){
//        super();
//        this.repoIncidentes = repoIncidentes;
//        this.repoEntidades = repoEntidades;
//    }

    //Considerado en la siguiente entrega
    /*
    public ranking3(){
        return Collections.sort(repoEntidades, Comparator.comparing(Entidad::impacto));
    }
    */
    /*public crearRanking(){

    }*/

    //no se no anda

//    private void generarInforme(){
//    informeSemanal.agregarListaPromedio(this.ranking1());
//    informeSemanal.agregarListaCantidad(this.ranking2());
//    }

    public void enviarInforme(){
        for (Entidad entidad: this.repoEntidades.getListaEntidades()
             ) {
            entidad.recibirInforme();
        }
    }

    public InformeSemanal obtenerInforme(){
        return this.informeSemanal;
    }
}

