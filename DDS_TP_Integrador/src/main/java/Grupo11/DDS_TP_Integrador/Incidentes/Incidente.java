package Grupo11.DDS_TP_Integrador.Incidentes;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import Grupo11.DDS_TP_Integrador.Entidades.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Servicios.*;
import Grupo11.DDS_TP_Integrador.Establecimientos.*;
import jakarta.persistence.*;

import java.time.temporal.ChronoUnit;

@Entity(name = "incidentes")
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_incidente")
    private Long idIncidente;
    @Column(name="observaciones")
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "entidad")
    private Entidad entidad;

    @ManyToOne
    @JoinColumn(name = "persona_reportadora")
    private Persona personaQueReporto;

    @ManyToOne
    @JoinColumn(name = "prestacion_incidentada")
    private Prestacion prestacionIncidentada;
    @ManyToOne
    @JoinColumn(name = "establecimiento")
    private Establecimiento establecimiento;

    @ManyToMany(mappedBy = "incidentesReportados")
    private List<Comunidad> comunidadesAfectadas;

    @Column(name="horario_apertura")
    private LocalDateTime apertura;
    @Column(name="horario_cierre")
    private LocalDateTime cierre;
    @Column(name="estado")
    private Boolean estado; //true abierto, false cerrado

    //1. Se debe permitir la apertura de incidentes
    public Incidente(Long identificador, String observaciones, Entidad entidad, Persona persona, Prestacion prestacion, Establecimiento establecimiento){
        super();
        this.idIncidente = identificador;
        this.observaciones = observaciones;
        this.entidad = entidad;
        this.personaQueReporto = persona;
        this.prestacionIncidentada = prestacion;
        this.establecimiento = establecimiento;
        this.comunidadesAfectadas = new ArrayList<>();
        this.apertura = LocalDateTime.now();
        this.cierre = null;
        this.estado = true; //true el incidente esta abierto
    }

    public Incidente() {
        this.comunidadesAfectadas = new ArrayList<>();
        this.apertura = LocalDateTime.now();
        this.cierre = null;
        this.estado = true; //true el incidente esta abierto
    }

    //2. Se debe permitir el cierre de incidentes
    public void cerrarIncidente(){
        this.cierre = LocalDateTime.now();
        this.estado = false; //false el incidente esta cerrado
    }
    public long duracion(){
        return apertura.until(cierre, ChronoUnit.HOURS);
    }

    public Long getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(Long idIncidente) {
        this.idIncidente = idIncidente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public Persona getPersonaQueReporto() {
        return personaQueReporto;
    }

    public void setPersonaQueReporto(Persona personaQueReporto) {
        this.personaQueReporto = personaQueReporto;
    }

    public Prestacion getPrestacionIncidentada() {
        return prestacionIncidentada;
    }

    public void setPrestacionIncidentada(Prestacion prestacionIncidentada) {
        this.prestacionIncidentada = prestacionIncidentada;
    }

    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

    public List<Comunidad> getComunidadesAfectadas() {
        return comunidadesAfectadas;
    }

    public void setComunidadesAfectadas(List<Comunidad> comunidadesAfectadas) {
        this.comunidadesAfectadas = comunidadesAfectadas;
    }

    public LocalDateTime getApertura() {
        return apertura;
    }

    public void setApertura(LocalDateTime apertura) {
        this.apertura = apertura;
    }

    public LocalDateTime getCierre() {
        return cierre;
    }

    public void setCierre(LocalDateTime cierre) {
        this.cierre = cierre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}

