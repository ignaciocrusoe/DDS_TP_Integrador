package Grupo11.DDS_TP_Integrador.Servicios;
import Grupo11.DDS_TP_Integrador.Establecimientos.*;
import Grupo11.DDS_TP_Integrador.Intereses.*;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import jakarta.persistence.*;

@Entity(name = "prestaciones")
@PrimaryKeyJoinColumn(name = "id_prestacion")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Prestacion extends Interes{
    @ManyToOne
    @JoinColumn(name = "establecimiento")
    protected Establecimiento establecimiento;

    @ManyToOne
    @JoinColumn(name = "agrupacion_prestaciones")
    private AgrupacionPrestaciones prestaciones;

    public Prestacion() {
    }

    public Prestacion(Establecimiento establecimiento, AgrupacionPrestaciones prestaciones) {
        this.establecimiento = establecimiento;
        this.prestaciones = prestaciones;
    }

    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

    public AgrupacionPrestaciones getPrestaciones() {
        return prestaciones;
    }

    public void setPrestaciones(AgrupacionPrestaciones prestaciones) {
        this.prestaciones = prestaciones;
    }
}

