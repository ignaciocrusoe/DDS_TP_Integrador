package Grupo11.DDS_TP_Integrador.Notificadores;

import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.GestoresNotificaciones.*;
import Grupo11.DDS_TP_Integrador.Incidentes.*;

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
