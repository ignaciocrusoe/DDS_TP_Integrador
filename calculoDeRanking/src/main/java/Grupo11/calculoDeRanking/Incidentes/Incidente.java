package Grupo11.calculoDeRanking.Incidentes;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Collections;
//import Grupo11.calculoDeRanking.Entidades.*;
//import Grupo11.calculoDeRanking.Comunidades.*;
//import Grupo11.calculoDeRanking.Servicios.*;
//import Grupo11.calculoDeRanking.Establecimientos.*;
//import Grupo11.calculoDeRanking.Comunidades.*;
import jakarta.persistence.*;

import java.time.temporal.ChronoUnit;

//todo faltaría poder actualizar los incidentes, tienen que ser distintos metodos dependiendo que se quiere actualizar

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
    private String entidad;
    //private Entidad entidad;

    @OneToOne
    @JoinColumn(name = "persona_reportadora")
    private String personaQueReporto;
    //private Persona personaQueReporto;
    @Transient
    private String prestacionIncidentada;
    //private Prestacion prestacionIncidentada;
    @OneToOne
    @JoinColumn(name = "establecimiento")
    private String establecimiento;
    //private Establecimiento establecimiento;

    @ManyToMany(mappedBy = "incidentesReportados")
    private List<String> comunidadesAfectadas;
    //private List<Comunidad> comunidadesAfectadas;

    @Column(name="horario_apertura")
    private LocalDate apertura;
    @Column(name="horario_cierre")
    private LocalDate cierre;
    @Column(name="estado")
    private Boolean estado; //todo estado podria ser un enum

    //1. Se debe permitir la apertura de incidentes
    public Incidente(Long identificador, String observaciones, String entidad, String persona, String prestacion, String establecimiento, List<String> comunidades){
        super();
        this.id_incidente = identificador;
        this.observaciones = observaciones;
        this.entidad = entidad;
        this.personaQueReporto = persona;
        this.prestacionIncidentada = prestacion;
        this.establecimiento = establecimiento;
        this.comunidadesAfectadas = comunidades;
        this.apertura = LocalDate.now(); //tiene que incluir fecha y hora
        this.cierre = null;
        this.estado = true; //true el incidente esta abierto
    }

    //2. Se debe permitir el cierre de incidentes
    public void cerrarIncidente(){
        this.cierre = LocalDate.now();
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

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getPersonaQueReporto() {
        return personaQueReporto;
    }

    public void setPersonaQueReporto(String personaQueReporto) {
        this.personaQueReporto = personaQueReporto;
    }

    public String getPrestacionIncidentada() {
        return prestacionIncidentada;
    }

    public void setPrestacionIncidentada(String prestacionIncidentada) {
        this.prestacionIncidentada = prestacionIncidentada;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public List<String> getComunidadesAfectadas() {
        return comunidadesAfectadas;
    }

    public void setComunidadesAfectadas(List<String> comunidadesAfectadas) {
        this.comunidadesAfectadas = comunidadesAfectadas;
    }

    public LocalDate getApertura() {
        return apertura;
    }

    public void setApertura(LocalDate apertura) {
        this.apertura = apertura;
    }

    public LocalDate getCierre() {
        return cierre;
    }

    public void setCierre(LocalDate cierre) {
        this.cierre = cierre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}

