package Grupo11.DDS_TP_Integrador.Incidentes;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import Grupo11.DDS_TP_Integrador.Entidades.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Servicios.*;
import Grupo11.DDS_TP_Integrador.Establecimientos.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.temporal.ChronoUnit;

@Entity(name = "incidentes")
@Data
@AllArgsConstructor
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_incidente")
    private Long idIncidente;
    @Column(name="observaciones")
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "entidad")
    @JsonBackReference
    private Entidad entidad;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "persona_reportadora")
    private Persona personaQueReporto;

    @ManyToOne
    @JoinColumn(name = "prestacion_incidentada")
    private Prestacion prestacionIncidentada;
    @ManyToOne
    @JoinColumn(name = "establecimiento")
    private Establecimiento establecimiento;

    @ManyToMany(mappedBy = "incidentesReportados")
    @JsonIgnore
    private List<Comunidad> comunidadesAfectadas;

    @Column(name="horario_apertura")
    private LocalDateTime apertura;
    @Column(name="horario_cierre")
    private LocalDateTime cierre;
    @Column(name="estado")
    private Boolean estado; //true abierto, false cerrado

    //1. Se debe permitir la apertura de incidentes

    //2. Se debe permitir el cierre de incidentes

    public Incidente() {
        this.comunidadesAfectadas = new ArrayList<>();
        this.apertura = LocalDateTime.now();
        this.cierre = null;
        this.estado = true; //true el incidente esta abierto
    }
    public void cerrarIncidente(){
        this.cierre = LocalDateTime.now();
        this.estado = false; //false el incidente esta cerrado
    }
    public long duracion(){
        return apertura.until(cierre, ChronoUnit.HOURS);
    }


}

