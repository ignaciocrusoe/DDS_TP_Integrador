package Grupo11.DDS_TP_Integrador.Establecimientos;
import Grupo11.DDS_TP_Integrador.Entidades.*;
import Grupo11.DDS_TP_Integrador.Localizaciones.Localizacion;
//import Grupo11.DDS_TP_Integrador.Localizaciones.*;
import jakarta.persistence.*;

@Entity(name = "establecimientos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "categoria", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Establecimiento")
public class Establecimiento{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_establecimiento")
    protected Long idEstablecimiento;

    @Column(name="nombre_establecimiento")
    protected String nombreEstablecimiento;

    @ManyToOne
    @JoinColumn(name = "localizacion")
    protected Localizacion localizacion;

    @ManyToOne
    @JoinColumn(name = "id_entidad")
    protected Entidad entidad;

    public Establecimiento() {
    }

    public Establecimiento(Long idEstablecimiento, String nombreEstablecimiento, Localizacion localizacion, Entidad entidad) {
        this.idEstablecimiento = idEstablecimiento;
        this.nombreEstablecimiento = nombreEstablecimiento;
        this.localizacion = localizacion;
        this.entidad = entidad;
    }

    public Long getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public void setIdEstablecimiento(Long idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    public String getNombreEstablecimiento() {
        return nombreEstablecimiento;
    }

    public void setNombreEstablecimiento(String nombreEstablecimiento) {
        this.nombreEstablecimiento = nombreEstablecimiento;
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