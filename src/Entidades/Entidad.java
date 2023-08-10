package Entidades;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Collections;

import Comunidades.Comunidad;
import Comunidades.Persona;
import Rankings.InformeSemanal;
import Rankings.GestorRankings;
import Establecimientos.Establecimiento;
import Incidentes.Incidente;
import GestoresIncidentes.GestorIncidentes;
import Intereses.Interes;
import Notificadores.Notificador;
import Servicios.Prestacion;


public class Entidad extends Interes {
    List<Incidente> incidentes;
    InformeSemanal informeSemanal;

    GestorRankings gestorRankings;

    public int promedioIncidentes(){
        return incidentes.map( x -> x.duracion()).average().orElse(0.0);
    }
    public int cantidadDeIncidentes(){
        return incidentes.size();
    }

    public void recibirInforme(){
        this.informeSemanal = gestorRankings.obtenerInforme();
    }
}

public class RepoEntidades {
    List<Incidente> listaEntidades;
}

    public void main(){
        Incidente unIncidente = new Incidente("id1", new Persona(), new Prestacion(), "Descripción.", [new Comunidad()], [new Persona()]);
    }

    public int duracion(){
        return apertura.until(cierre, ChronoUnit.HOURS);
    }
}
