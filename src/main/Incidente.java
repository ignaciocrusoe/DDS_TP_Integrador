package Incidente;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

//Después deberíamos importarlo de Person.java, Prestacion.java y de Comunidad.java
public class Persona {

}

public class Prestacion {

}

public class Comunidad {

}

public class RepoIncidentes {
    List<Incidente> listaIncidentes;

    //public Incidente buscarIncidente(){}
}

public class Incidente {
    private String id;
    Persona personaQueReporto;
    Prestacion prestacionIncidentada;
    public String descripcion;
    List<Comunidad> comunidadesAfectadas;
    LocalDate apertura;
    LocalDate cierre;
    boolean estado;
    List<Persona> suscriptores;

    RepoIncidentes repoIncidentes;

    //1. Se debe permitir la apertura de incidentes
    public Incidente(String id, Persona persona, Prestacion prestacion, String descripcion, List<Comunidad> comunidadesAfectadas, List<Persona> suscriptores, RepoIncidentes repoIncidentes;){
        this.id = id;
        this.personaQueReporto = persona;
        this.descripcion = descripcion;
        this.comunidadesAfectadas = comunidadesAfectadas;
        this.apertura = LocalDate.now();
        this.cierre = null;
        this.estado = true;
        this.suscriptores = suscriptores;

        this.repoIncidentes = repoIncidentes;
    }
    //2. Se debe permitir el cierre de incidentes
    public void cerrarIncidente(){
        this.cierre = LocalDate.now();
        this.estado = false;        
    }

    public void main(){
        Incidente unIncidente = new Incidente("id1", new Persona(), new Prestacion(), "Descripción.", [new Comunidad()], [new Persona()]);
    }
}

public class GestorDeRankings {
    RepoIncidentes repoIncidentes;
    public crearRanking(){

    }
}