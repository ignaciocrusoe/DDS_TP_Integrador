package Grupo11.DDS_TP_Integrador.Notificadores;

import Grupo11.DDS_TP_Integrador.Comunidades.Persona;
import Grupo11.DDS_TP_Integrador.Incidentes.Incidente;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;


@Entity
@Table(name = "notificaciones")
@Builder
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_notificacion")
    private Long idNotificacion;

    @ManyToOne
    @JoinColumn(name = "persona")
    @JsonBackReference
    private Persona persona;

    @ManyToOne
    private Incidente incidente;

    @Enumerated(EnumType.STRING)
    private TipoNotificacion tipo;

    public Notificacion(Long idNotificacion, Persona persona, Incidente incidente, TipoNotificacion tipo) {
        this.idNotificacion = idNotificacion;
        this.persona = persona;
        this.incidente = incidente;
        this.tipo = tipo;
    }

    public Notificacion(Persona persona, Incidente incidente, TipoNotificacion tipo) {
        this.persona = persona;
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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
