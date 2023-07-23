package Notificadores;

import Comunidades.Miembro;
import GestoresNotificaciones.GestorNotificacionesPersona;
import Incidentes.Incidente;

import java.util.LinkedList;
import java.util.List;

public class NotificadorComunidad extends Notificador {

    private List<GestorNotificacionesPersona> gestoresMiembros;
    public NotificadorComunidad(){

        this.gestoresMiembros = new LinkedList<GestorNotificacionesPersona>();

    }
    public void notificarCercaniaIncidente(List<GestorNotificacionesPersona> notificadoresPersonas, Incidente incidente) {

        // Le envia la notificacion a cada notificador de la lista
        for (GestorNotificacionesPersona notificadorPersona:notificadoresPersonas
        ) {
            notificadorPersona.notificarCercania(incidente);

        }
    }



}
