package main.Rankings;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Collections;
import package.Entidades.Entidad;
import package.Comunidades.Comunidad;

public class GestorDeRankings {
    RepoIncidentes repoIncidentes;
    RepoEntidades repoEntidades;
    public int rankingSize;

    public ranking1(){
        return Collections.sort(repoEntidades, Comparator.comparing(Entidad::promedioIncidentes));
    }
    public ranking2(){
        return Collections.sort(repoEntidades, Comparator.comparing(Entidad::cantidadDeIncidentes));
    }

    //Considerado en la siguiente entrega
    /*
    public ranking3(){
        return Collections.sort(repoEntidades, Comparator.comparing(Entidad::impacto));
    }
    */
    public crearRanking(){

    }
}

public class InformeSemanal {
}