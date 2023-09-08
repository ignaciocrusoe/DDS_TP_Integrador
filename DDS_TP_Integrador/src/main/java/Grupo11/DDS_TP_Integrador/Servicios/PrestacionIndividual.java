package Grupo11.DDS_TP_Integrador.Servicios;

import Grupo11.DDS_TP_Integrador.Establecimientos.Establecimiento;
import jakarta.persistence.*;

@Entity(name = "prestaciones_individuales")
public class PrestacionIndividual extends Prestacion {

    @OneToOne
    @JoinColumn(name = "servicio")
    private Servicio servicio;

    public PrestacionIndividual() {
    }

    public PrestacionIndividual(Servicio servicio) {
        this.servicio = servicio;
    }

    public PrestacionIndividual(Establecimiento establecimiento, AgrupacionPrestaciones prestaciones, Servicio servicio) {
        super(establecimiento, prestaciones);
        this.servicio = servicio;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
