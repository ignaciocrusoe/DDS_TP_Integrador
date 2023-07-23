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

        List<Incidente> lista = this.getIncidentesSegun(estado);

        for (Incidente incidente:lista
        ) {
            incidente.printIncidente(); //funcion que muestre los datos del incidente

        }
    }

    public List<Incidente> getIncidentesSegun(@NotNull Boolean estado){
        //        todo : test getIncidentesSegun(estado)
        if(estado){
            return incidentesActivos;
        }else{
            return incidentesFinalizados;
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

    public void sugerirActualizarIncidente(List<Miembro> miembrosCerca,Incidente incidente){
        // es el notify() del observer al GestorCercania

        // genera una lista de sus gestores de notificaciones para mandarsela al gestor de la comunidad
        List<GestorNotificacionesPersona> gestoresNotisMiembros = (List<GestorNotificacionesPersona>) miembrosCerca.stream().map(miembro -> miembro.getPersona().getGestorNotificaciones());

        newsletter.notificarCercaniaIncidente(gestoresNotisMiembros, incidente);

    }

    public List<Miembro> getMiembros() {
        return this.miembros;
    }
}
