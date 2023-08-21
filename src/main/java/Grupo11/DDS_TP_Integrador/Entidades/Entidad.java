package Grupo11.DDS_TP_Integrador.Entidades;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Collections;

import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Rankings.*;
import Grupo11.DDS_TP_Integrador.Rankings.*;
import Grupo11.DDS_TP_Integrador.Establecimientos.*;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import Grupo11.DDS_TP_Integrador.GestoresIncidentes.*;
import Grupo11.DDS_TP_Integrador.Intereses.*;
import Grupo11.DDS_TP_Integrador.Notificadores.*;
import Grupo11.DDS_TP_Integrador.Servicios.*;


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
class Linea extends Entidad {

}
class Organizacion extends Entidad {

}
