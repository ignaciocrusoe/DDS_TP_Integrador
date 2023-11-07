package Grupo11.DDS_TP_Integrador.Establecimientos;
import Grupo11.DDS_TP_Integrador.Entidades.*;
import Grupo11.DDS_TP_Integrador.Localizaciones.Localizacion;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
//import Grupo11.DDS_TP_Integrador.Localizaciones.*;
import Grupo11.DDS_TP_Integrador.Servicios.*;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "establecimientos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "categoria", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Establecimiento")
public class Establecimiento{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_establecimiento")
    protected Long id_establecimiento;

    @Column(name="nombre_establecimiento")
    protected String nombre_establecimiento;

    @ManyToOne
    @JoinColumn(name = "localizacion")
    protected Localizacion localizacion;

    @OneToMany(mappedBy = "establecimiento")
    protected List<Prestacion> prestaciones;

    @ManyToOne
    @JoinColumn(name = "id_entidad")
    protected Entidad entidad;

    public Establecimiento() {
    }

    public Establecimiento(Long id_establecimiento, String nombre_establecimiento, Localizacion localizacion, List<Prestacion> prestaciones, Entidad entidad) {
        this.id_establecimiento = id_establecimiento;
        this.nombre_establecimiento = nombre_establecimiento;
        this.localizacion = localizacion;
        this.prestaciones = prestaciones;
        this.entidad = entidad;
    }

    public Long getId_establecimiento() {
        return id_establecimiento;
    }

    public void setId_establecimiento(Long id_establecimiento) {
        this.id_establecimiento = id_establecimiento;
    }

    public String getNombre_establecimiento() {
        return nombre_establecimiento;
    }

    public void setNombre_establecimiento(String nombre_establecimiento) {
        this.nombre_establecimiento = nombre_establecimiento;
    }

    public List<Prestacion> getPrestaciones() {
        return prestaciones;
    }

    public void setPrestaciones(List<Prestacion> prestaciones) {
        this.prestaciones = prestaciones;
    }

    public Localizacion getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Localizacion localizacion) {
        this.localizacion = localizacion;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }
}