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

    @Transient //todo ver persistencia
    private Incidente incidente;

    @Enumerated(EnumType.STRING)
    private TipoNotificacion tipo;

    @ManyToOne
    @JoinColumn(name="id_persona")
    private Persona persona;

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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
