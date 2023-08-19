package Grupo11.DDS_TP_Integrador.Notificadores;
import Grupo11.DDS_TP_Integrador.GestoresNotificaciones.*;
import Grupo11.DDS_TP_Integrador.Entidades.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Incidentes.*;

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
