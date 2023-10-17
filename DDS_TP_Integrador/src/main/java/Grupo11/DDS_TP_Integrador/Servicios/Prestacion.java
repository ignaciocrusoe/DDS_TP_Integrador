package Grupo11.DDS_TP_Integrador.Servicios;
import Grupo11.DDS_TP_Integrador.Establecimientos.*;
import Grupo11.DDS_TP_Integrador.Intereses.*;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import jakarta.persistence.*;

@Entity(name = "prestaciones")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@PrimaryKeyJoinColumn(name = "id_prestacion")
public class Prestacion extends Interes{
    @ManyToOne
    @JoinColumn(name = "establecimiento")
    private Establecimiento establecimiento;

    @OneToOne
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;

    public Prestacion() {
    }

    public Prestacion(Establecimiento establecimiento, Servicio servicio) {
        this.establecimiento = establecimiento;
        this.servicio = servicio;
    }

    public Prestacion(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}

