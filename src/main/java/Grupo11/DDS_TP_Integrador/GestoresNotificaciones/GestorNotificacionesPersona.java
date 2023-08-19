package Grupo11.DDS_TP_Integrador.GestoresNotificaciones;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Notificadores.*;

import java.util.LinkedList;
import java.util.List;

public class GestorNotificacionesPersona {

    MedioComunicacion medioComunicacion;
    List<Incidente> incidentesANotificar;

    public GestorNotificacionesPersona(MedioComunicacion medio){
        this.incidentesANotificar = new LinkedList<Incidente>();
        this.medioComunicacion = medio;

    }
    public void agregarNotificacionPendiente(Incidente nuevoIncidente) {
        incidentesANotificar.add(nuevoIncidente);
    }

    public void notificarCercania(Incidente incidente) {

        //todo notificarCercania(incidente)
        //acá deberíamos armar la estructura del mensaje y ejecutar medio.notify(mensaje)

    }
    public void setMedioComunicacion(MedioComunicacion medioComunicacion) {
        this.medioComunicacion = medioComunicacion;
    }
}
