package Rankings;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Collections;
import Entidades.Entidad;
import Comunidades.Comunidad;

import Entidades.RepoEntidades;
import Incidentes.RepoIncidentes;

public class GestorRankings {
    RepoIncidentes repoIncidentes;
    RepoEntidades repoEntidades;

    InformeSemanal informeSemanal;
    public int rankingSize;

    public List<Entidad> ranking1(){
        return Collections.sort(repoEntidades, Comparator.comparing(Entidad::promedioIncidentes));
    }
    public List<Entidad> ranking2(){
        return Collections.sort(repoEntidades, Comparator.comparing(Entidad::cantidadDeIncidentes));
    }
    public void GestorRankings(RepoIncidentes repoIncidentes, RepoEntidades repoEntidades){
        super();
        this.repoIncidentes = repoIncidentes;
        this.repoEntidades = repoEntidades;
    }

    //Considerado en la siguiente entrega
    /*
    public ranking3(){
        return Collections.sort(repoEntidades, Comparator.comparing(Entidad::impacto));
    }
    */
    /*public crearRanking(){

    }*/

    private void generarInforme(){
    informeSemanal.agregarListaPromedio(this.ranking1());
    informeSemanal.agregarListaCantidad(this.ranking2());
    }

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

