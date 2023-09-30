package CalculoRanking.Incidentes;

import CalculoRanking.Entidades.Entidad;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

//todo faltaría poder actualizar los incidentes, tienen que ser distintos metodos dependiendo que se quiere actualizar

@Entity(name = "incidentes")
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_incidente")
    private Long id_incidente;
    @ManyToOne
    @JoinColumn(name = "entidad")
    private Entidad entidad;
    //private Entidad entidad;

    @Column(name="horario_apertura")
    private LocalDateTime apertura;
    @Column(name="horario_cierre")
    private LocalDateTime cierre;
    @Column(name="estado")
    private Boolean estado; //todo estado podria ser un enum

    public Incidente() {
    }

    //1. Se debe permitir la apertura de incidentes
    public Incidente(Long identificador, Entidad entidad){
        super();
        this.id_incidente = identificador;
        this.entidad = entidad;
        this.apertura = LocalDateTime.now(); //tiene que incluir fecha y hora
        this.cierre = null;
        this.estado = true; //true el incidente esta abierto
    }

    public Incidente( LocalDateTime data){
        super();
        this.apertura = data; //tiene que incluir fecha y hora
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

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
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

