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
import Grupo11.calculoDeRanking.Entidades.Entidad;
import jakarta.persistence.*;

import java.time.temporal.ChronoUnit;

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
    private LocalDate apertura;
    @Column(name="horario_cierre")
    private LocalDate cierre;
    @Column(name="estado")
    private Boolean estado; //todo estado podria ser un enum

    //1. Se debe permitir la apertura de incidentes
    public Incidente(Long identificador, String observaciones, Entidad entidad, String persona, String prestacion, String establecimiento, List<String> comunidades){
        super();
        this.id_incidente = identificador;
        this.entidad = entidad;
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

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
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

