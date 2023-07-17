package Incidente;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

//Después deberíamos importarlo de Person.java, Prestacion.java y de Comunidad.java
public class Persona{

}

public class Prestacion{

}

public class Comunidad{

}

public class Incidente {
    private static String id;
    Persona personaQueReporto;
    Prestacion prestacionIncidentada;
    public String descripcion;
    List<Comunidad> comunidadesAfectadas;
    LocalDate apertura;
    LocalDate cierre;
    boolean estado;
    List<Persona> suscriptores;

    public static void crearIncidente(){

    }

    public void cerrarIncidente(){
        this.cierre = LocalDate.now();
        this.estado = false;        
    }

    public void main(){
        //Incidente unIncidente = new Incidente("id1", new Persona(), new Prestacion(), "Descripción.", [new Comunidad()], LocalDate.now().minusDays(1), null, true, [new Persona()]);
    }
}
