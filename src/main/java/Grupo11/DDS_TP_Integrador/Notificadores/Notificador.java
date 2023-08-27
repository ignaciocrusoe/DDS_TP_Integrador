package Grupo11.DDS_TP_Integrador.Notificadores;
import Grupo11.DDS_TP_Integrador.GestoresNotificaciones.*;
import Grupo11.DDS_TP_Integrador.Entidades.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Incidentes.*;

import java.util.LinkedList;
import java.util.List;

public class Notificador{
    private List<GestorNotificacionesPersona> listaGestoresNotificaciones;
    protected Notificacion notificacion; //es la notificacion que va a venir a buscar el gestorNotificaciones

    public Notificador(){
        super();
        this.listaGestoresNotificaciones = new LinkedList<GestorNotificacionesPersona>();
    }
    public void notificarGestores(){
        for (GestorNotificacionesPersona gestorNotificaciones:listaGestoresNotificaciones
        ) {
            gestorNotificaciones.addNotificacionPendiente(notificacion);
        }
    }
    public void suscribirGestor(GestorNotificacionesPersona gestor){
        listaGestoresNotificaciones.add(gestor);
    }

    public void setNotificacion(Notificacion notificacion) {
        notificacion = notificacion;
    }
}

