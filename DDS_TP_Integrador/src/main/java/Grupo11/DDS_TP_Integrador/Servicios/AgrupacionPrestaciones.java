package Grupo11.DDS_TP_Integrador.Servicios;

import Grupo11.DDS_TP_Integrador.Establecimientos.Establecimiento;
import Grupo11.DDS_TP_Integrador.Rankings.RankingPK;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "prestaciones_agrupadas")
@IdClass(PrestacionPK.class)
public class AgrupacionPrestaciones extends Prestacion {

    @Id
    @OneToMany
    @JoinColumn(name = "prestacion")
    private List<Prestacion> lista_prestaciones;

    @Id
    @OneToMany
    @JoinColumn(name = "componente")
    private List<Prestacion> lista_componentes;

    public AgrupacionPrestaciones() {
    }

    public AgrupacionPrestaciones(List<Prestacion> lista_prestaciones, List<Prestacion> lista_componentes) {
        this.lista_prestaciones = lista_prestaciones;
        this.lista_componentes = lista_componentes;
    }

    public List<Prestacion> getLista_prestaciones() {
        return lista_prestaciones;
    }

    public void setLista_prestaciones(List<Prestacion> lista_prestaciones) {
        this.lista_prestaciones = lista_prestaciones;
    }

    public List<Prestacion> getLista_componentes() {
        return lista_componentes;
    }

    public void setLista_componentes(List<Prestacion> lista_componentes) {
        this.lista_componentes = lista_componentes;
    }
}
