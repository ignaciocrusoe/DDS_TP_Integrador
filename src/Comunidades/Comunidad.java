package Comunidades;
import GestoresNotificaciones.GestorNotificacionesPersona;
import Intereses.Interes;
import Incidentes.Incidente;
import Notificadores.NotificadorComunidad;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


//todo : estos métodos me parece que deben ir en Incidente directamente:
// +actualizarIncidenteReportado(Incidente)
// +cerrarIncidenteReportado(Incidente)

public class Comunidad{

    private List<Miembro> miembros;
    private List<Interes> interesesComunes;
    private List<Incidente> incidentesActivos;
    private List<Incidente> incidentesFinalizados;
    private NotificadorComunidad newsletter;
    private GestorCercania gestorCercania;

    public Comunidad(Double radioCercaniaIncidentes){
        this.miembros = new LinkedList<Miembro>();
        //todo: se pueden agregar intereses o se intancia la comunidad con una lista fija?
        this.interesesComunes = new LinkedList<Interes>();
        this.incidentesActivos = new LinkedList<Incidente>();
        this.incidentesFinalizados = new LinkedList<Incidente>();

        this.newsletter = new NotificadorComunidad();
        this.gestorCercania = new GestorCercania(this, radioCercaniaIncidentes);
    }
    public void verIncidentesSegun(@NotNull Boolean estado){

//        todo : chequear si esta implementacion anda
        List<Incidente> lista;

        if(estado){
             lista = incidentesActivos;
        }else{
            lista = incidentesFinalizados;
        }

        for (Incidente incidente:lista
        ) {
            incidente.printIncidente(); //funcion que muestre los datos del incidente

        }
    }

    public void agregarIncidente(@NotNull Incidente nuevoIncidente){

        if (nuevoIncidente.getEstado()){
            incidentesActivos.add(nuevoIncidente);
        }else{
            incidentesFinalizados.add(nuevoIncidente); //caso borde
        }

        this.notificarNuevoIncidenteAMiembros(nuevoIncidente);
    }
    private void notificarNuevoIncidenteAMiembros(Incidente nuevoIncidente){
        newsletter.notificarGestores(nuevoIncidente);
    }

    public void sugerirActualizarIncidente(GestorNotificacionesPersona notificadorPesona,Incidente incidente){
        // es el notify() del observer al GestorCercania
        newsletter.notificarCercaniaIncidente(notificadorPesona,incidente);
    }
}
