package Incidentes;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Collections;
import Entidades.Entidad;
import Comunidades.Persona;
import Comunidades.Comunidad;
import Servicios.Prestacion;
import Servicios.AgrupacionPrestaciones;
import Establecimientos.Establecimiento;
import java.time.temporal.ChronoUnit;


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
    public Incidente(String id, Persona persona, Prestacion prestacion, String descripcion, List<Comunidad> comunidadesAfectadas, List<Persona> suscriptores, RepoIncidentes repoIncidentes){
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

    public long duracion(){
        return apertura.until(cierre, ChronoUnit.HOURS);
    }
}

