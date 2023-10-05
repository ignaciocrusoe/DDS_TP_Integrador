package Grupo11.DDS_TP_Integrador.Incidentes;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Collections;
import Grupo11.DDS_TP_Integrador.Entidades.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Servicios.*;
import Grupo11.DDS_TP_Integrador.Establecimientos.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;
import jakarta.persistence.*;

import java.time.temporal.ChronoUnit;

@Entity(name = "incidentes")
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_incidente")
    private Long id_incidente;
    @Column(name="observaciones")
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "entidad")
    private Entidad entidad;

    @OneToOne
    @JoinColumn(name = "persona_reportadora")
    private Persona personaQueReporto;
    @Transient
    private Prestacion prestacionIncidentada;
    @OneToOne
    @JoinColumn(name = "establecimiento")
    private Establecimiento establecimiento;

    @ManyToMany(mappedBy = "incidentesReportados")
    private List<Comunidad> comunidadesAfectadas;

    @Column(name="horario_apertura")
    private LocalDateTime apertura;
    @Column(name="horario_cierre")
    private LocalDateTime cierre;
    @Column(name="estado")
    private Boolean estado; //todo estado podria ser un enum

    //1. Se debe permitir la apertura de incidentes
    public Incidente(Long identificador, String observaciones, Entidad entidad, Persona persona, Prestacion prestacion, Establecimiento establecimiento, List<Comunidad> comunidades){
        super();
        this.id_incidente = identificador;
        this.observaciones = observaciones;
        this.entidad = entidad;
        this.personaQueReporto = persona;
        this.prestacionIncidentada = prestacion;
        this.establecimiento = establecimiento;
        this.comunidadesAfectadas = comunidades;
        this.apertura = LocalDateTime.now(); //tiene que incluir fecha y hora
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

    public Long getId_incidente() {
        return id_incidente;
    }

    public void setId_incidente(Long id_incidente) {
        this.id_incidente = id_incidente;
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

