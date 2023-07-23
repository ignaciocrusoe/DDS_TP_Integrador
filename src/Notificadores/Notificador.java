package Notificadores;
import GestoresNotificaciones.GestorNotificacionesPersona;
import Entidades.Entidad;
import Comunidades.Comunidad;
import Incidentes.Incidente;

import java.util.LinkedList;
import java.util.List;

public class Notificador{

    private List<GestorNotificacionesPersona> gestoresMiembros;

    public Notificador(){

        this.gestoresMiembros = new LinkedList<GestorNotificacionesPersona>();

    }
    public void notificarGestores(Incidente nuevoIncidente){

        for (GestorNotificacionesPersona gestor:gestoresMiembros
        ) {

            gestor.agregarNotificacionPendiente(nuevoIncidente);
        }

    }
    public void suscribirGestor(GestorNotificacionesPersona gestor){
        gestoresMiembros.add(gestor);
    }

}
