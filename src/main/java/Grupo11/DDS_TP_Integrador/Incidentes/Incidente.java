package Grupo11.DDS_TP_Integrador.Incidentes;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Collections;
import Grupo11.DDS_TP_Integrador.Entidades.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Servicios.*;
import Grupo11.DDS_TP_Integrador.Establecimientos.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;
import java.time.temporal.ChronoUnit;

//todo faltaría poder actualizar los incidentes, tienen que ser distintos metodos dependiendo que se quiere actualizar

public class Incidente {
    private Integer identificador;
    private String observaciones;
    private Entidad entidad;
    private Persona personaQueReporto;
    private Prestacion prestacionIncidentada;
    private Establecimiento establecimiento;
    private List<Comunidad> comunidadesAfectadas;
    private LocalDate apertura;
    private LocalDate cierre;
    private Boolean estado; //todo estado podria ser un enum

    //1. Se debe permitir la apertura de incidentes
    public Incidente(Integer identificador, String observaciones, Entidad entidad, Persona persona, Prestacion prestacion, Establecimiento establecimiento, List<Comunidad> comunidades){
        super();
        this.identificador = identificador;
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
    public Boolean getEstado() {
        return estado;
    }
    public long duracion(){
        return apertura.until(cierre, ChronoUnit.HOURS);
    }

    public Entidad getEntidad() {
        return entidad;
    }
}

