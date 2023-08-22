package Grupo11.DDS_TP_Integrador.GestoresNotificaciones;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Notificadores.*;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class GestorNotificacionesPersona {
    private List<LocalDate> horarios;
    private MedioComunicacion medioComunicacion;
    private RepoNotificaciones repoNotificacionesPendientes;

    public GestorNotificacionesPersona(MedioComunicacion medio){
        this.repoNotificacionesPendientes = new RepoNotificaciones();
        this.medioComunicacion = medio;
    }
    public void actualizarNotificacionesPendientes(Notificacion notificacion) {
        repoNotificacionesPendientes.addNotificacion(notificacion);
    }

    public void setMedioComunicacion(MedioComunicacion medioComunicacion) {
        medioComunicacion = medioComunicacion;
    }
}



