package Notificadores;

import GestoresNotificaciones.GestorNotificacionesPersona;
import Incidentes.Incidente;

import java.util.LinkedList;
import java.util.List;

public class NotificadorComunidad extends Notificador {

    private List<GestorNotificacionesPersona> gestoresMiembros;
    public NotificadorComunidad(){

        this.gestoresMiembros = new LinkedList<GestorNotificacionesPersona>();

    }
    public void notificarCercaniaIncidente(GestorNotificacionesPersona notificadorPesona, Incidente incidente) {

        notificadorPesona.notificarCercania(incidente);
    }



}
