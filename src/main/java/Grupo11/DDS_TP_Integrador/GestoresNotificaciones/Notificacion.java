package Grupo11.DDS_TP_Integrador.GestoresNotificaciones;

import Grupo11.DDS_TP_Integrador.Comunidades.Persona;
import Grupo11.DDS_TP_Integrador.Incidentes.Incidente;
import jakarta.persistence.*;


@Entity
@Table(name = "notificaciones_pendientes")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_notificacion")
    private Long idNotificacion;

    @ManyToOne
    @JoinColumn(name = "repo_notificaciones")
    private RepoNotificaciones repo_notificaciones;

    @Transient //todo ver persistencia
    private Incidente incidente;

    @Enumerated(EnumType.STRING)
    private TipoNotificacion tipo;

    public Notificacion(Incidente incidente, TipoNotificacion tipo){
        super();
        this.incidente = incidente;
        this.tipo = tipo;
    }

    public Notificacion() {

    }

    public Long getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Long idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public RepoNotificaciones getRepo_notificaciones() {
        return repo_notificaciones;
    }

    public void setRepo_notificaciones(RepoNotificaciones repo_notificaciones) {
        this.repo_notificaciones = repo_notificaciones;
    }

    public Incidente getIncidente() {
        return incidente;
    }

    public void setIncidente(Incidente incidente) {
        this.incidente = incidente;
    }

    public TipoNotificacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoNotificacion tipo) {
        this.tipo = tipo;
    }
}
