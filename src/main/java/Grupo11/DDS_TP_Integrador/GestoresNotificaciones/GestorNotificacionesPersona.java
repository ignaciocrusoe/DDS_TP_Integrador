package Grupo11.DDS_TP_Integrador.GestoresNotificaciones;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Notificadores.*;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Embeddable
public class GestorNotificacionesPersona {

    @Transient //todo ver cómo persiste
    private List<LocalDate> horarios;
    @Transient //todo ver cómo persiste
    private MedioComunicacion medioComunicacion;

    //private RepoNotificaciones repoNotificacionesPendientes;
    @OneToMany(mappedBy = "persona")
    private List<Notificacion> notificacionesPendientes;

    public GestorNotificacionesPersona(List<LocalDate> horarios, MedioComunicacion medioComunicacion, List<Notificacion> notificacionesPendientes) {
        this.horarios = horarios;
        this.medioComunicacion = medioComunicacion;
        this.notificacionesPendientes = notificacionesPendientes;
    }

    public GestorNotificacionesPersona() {
        notificacionesPendientes = new ArrayList<Notificacion>();
    }

    public List<LocalDate> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<LocalDate> horarios) {
        this.horarios = horarios;
    }

    public MedioComunicacion getMedioComunicacion() {
        return medioComunicacion;
    }

    public void setMedioComunicacion(MedioComunicacion medioComunicacion) {
        this.medioComunicacion = medioComunicacion;
    }

    public List<Notificacion> getNotificacionesPendientes() {
        return notificacionesPendientes;
    }

    public void setNotificacionesPendientes(List<Notificacion> notificacionesPendientes) {
        this.notificacionesPendientes = notificacionesPendientes;
    }

    public void addNotificacionPendiente(Notificacion notificacion) {
        notificacionesPendientes.add(notificacion);
    }

}



