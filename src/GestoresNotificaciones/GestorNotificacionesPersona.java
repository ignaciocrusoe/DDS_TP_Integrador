package GestoresNotificaciones;
import Incidentes.Incidente;
import Comunidades.Persona;
import Notificadores.Notificador;
import Notificadores.NotificadorComunidad;

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
