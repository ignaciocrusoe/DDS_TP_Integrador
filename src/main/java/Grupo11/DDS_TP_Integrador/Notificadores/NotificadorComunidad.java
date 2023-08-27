package Grupo11.DDS_TP_Integrador.Notificadores;

import Grupo11.DDS_TP_Integrador.GestoresNotificaciones.GestorNotificacionesPersona;

import java.util.List;

public class NotificadorComunidad extends Notificador {
    public void notificarSugerencia(List<GestorNotificacionesPersona> gestoresNotificaciones) {
        // Le envia la notificacion a cada notificador de la lista
        for (GestorNotificacionesPersona gestorNotificaciones : gestoresNotificaciones) {
            gestorNotificaciones.addNotificacionPendiente(notificacion);
        }
    }
}
