package Entidades;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Collections;
import Rankings.InformeSemanal;
import Rankings.GestorRankings;
import Establecimientos.Establecimiento;
import Incidentes.Incidente;
import GestoresIncidentes.GestorIncidentes;
import Intereses.Interes;
import Notificadores.Notificador;


public class Entidad extends Interes {
    List<Incidente> incidentes;
    InformeSemanal informeSemanal;

    GestorRankings gestorRankings;

    public int promedioIncidentes(){
        return incidentes.map(x -> x.duracion()).average().orElse(0.0);
    }
    public int cantidadDeIncidentes(){
        return incidentes.size();
    }

    public void recibirInforme(){
        this.informeSemanal = gestorRankings.obtenerInforme();
    }
}

