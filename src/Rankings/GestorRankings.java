package Rankings;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Collections;
import Entidades.Entidad;
import Comunidades.Comunidad;
import Entidades.Entidad;
import Entidades.RepoEntidades;
import Incidentes.RepoIncidentes;

public class GestorRankings {
    RepoIncidentes repoIncidentes;
    RepoEntidades repoEntidades;
    public int rankingSize;

    public Collections ranking1(){
        return Collections.sort(repoEntidades, Comparator.comparing(Entidad::promedioIncidentes));
    }
    public Collections ranking2(){
        return Collections.sort(repoEntidades, Comparator.comparing(Entidad::cantidadDeIncidentes));
    }
    public GestorRankings(RepoIncidentes repoIncidentes, RepoEntidades repoEntidades){
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
}

