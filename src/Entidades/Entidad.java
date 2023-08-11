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
import Incidentes.RepoIncidentes;
import GestoresIncidentes.GestorIncidentes;
import Intereses.Interes;
import Notificadores.Notificador;
import Servicios.Prestacion;


public class Entidad extends Interes {
    List<Incidente> incidentes;
    InformeSemanal informeSemanal;

    GestorRankings gestorRankings;

    public int promedioIncidentes(){

        long sumatoria=0;
        for (Incidente incidente:incidentes
             ) {
            sumatoria+=incidente.duracion();

        }
        return (int)(sumatoria/incidentes.size());
    }
    public int cantidadDeIncidentes(){
        return incidentes.size();
    }

    public void recibirInforme(){
        this.informeSemanal = gestorRankings.obtenerInforme();
    }
}
