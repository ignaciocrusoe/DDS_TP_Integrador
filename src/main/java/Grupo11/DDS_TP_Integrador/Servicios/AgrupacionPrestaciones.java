package Grupo11.DDS_TP_Integrador.Servicios;

import Grupo11.DDS_TP_Integrador.Establecimientos.Establecimiento;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity(name = "prestaciones_agrupadas")
public class AgrupacionPrestaciones extends Prestacion {

    @OneToMany(mappedBy = "prestaciones")
    private List<Prestacion> lista_prestaciones;

    public AgrupacionPrestaciones() {
    }

    public AgrupacionPrestaciones(List<Prestacion> lista_prestaciones) {
        this.lista_prestaciones = lista_prestaciones;
    }

    public AgrupacionPrestaciones(Establecimiento establecimiento, AgrupacionPrestaciones prestaciones, List<Prestacion> lista_prestaciones) {
        super(establecimiento, prestaciones);
        this.lista_prestaciones = lista_prestaciones;
    }

    public List<Prestacion> getLista_prestaciones() {
        return lista_prestaciones;
    }

    public void setLista_prestaciones(List<Prestacion> lista_prestaciones) {
        this.lista_prestaciones = lista_prestaciones;
    }
}
