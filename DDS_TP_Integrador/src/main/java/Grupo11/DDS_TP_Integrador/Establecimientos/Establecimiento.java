package Grupo11.DDS_TP_Integrador.Establecimientos;
import Grupo11.DDS_TP_Integrador.Entidades.*;
import Grupo11.DDS_TP_Integrador.Georef.Localizaciones.Localizacion;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
//import Grupo11.DDS_TP_Integrador.Localizaciones.*;
import Grupo11.DDS_TP_Integrador.Servicios.*;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "establecimientos")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Establecimiento{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_establecimiento")
    protected Long id_establecimiento;

    @Column(name="nombre_establecimiento")
    protected String nombre_establecimiento;

    @OneToOne
    @JoinColumn(name = "localizacion")
    protected Localizacion localizacion;

    @OneToMany(mappedBy = "establecimiento")
    protected List<Prestacion> prestaciones;

    public Establecimiento() {
    }

    public Establecimiento(Long id_establecimiento, String nombre_establecimiento, Localizacion localizacion, List<Prestacion> prestaciones) {
        this.id_establecimiento = id_establecimiento;
        this.nombre_establecimiento = nombre_establecimiento;
        this.localizacion = localizacion;
        this.prestaciones = prestaciones;
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
}