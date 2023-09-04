package Grupo11.DDS_TP_Integrador.Rankings;

import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Entidades.*;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "informesSemanales")
public class InformeSemanal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_informe")
    protected Long id_informe;


    @ManyToMany
    @JoinTable(name = "entidad_promedio x informe",
            joinColumns = @JoinColumn(name = "id_entidad"),
            inverseJoinColumns = @JoinColumn(name = "id_informe"))
    private List<Entidad> entidadesPromedioCierreIncidentes;

    @ManyToMany
    @JoinTable(name = "entidad_mayor x informe",
            joinColumns = @JoinColumn(name = "id_entidad"),
            inverseJoinColumns = @JoinColumn(name = "id_informe"))
    private List<Entidad> entidadesMayorCantidadIncidentes;

    @ManyToMany
    @JoinTable(name = "comunidad x informe",
            joinColumns = @JoinColumn(name = "id_comunidad"),
            inverseJoinColumns = @JoinColumn(name = "id_informe"))
    private List<Comunidad> comunidadesMayorImpacto;

    public void agregarListaPromedio(List<Entidad> listaEntidad){
        this.entidadesPromedioCierreIncidentes = listaEntidad;
    }
    public void agregarListaCantidad(List<Entidad> listaEntidad){
        this.entidadesMayorCantidadIncidentes = listaEntidad;
    }

    public InformeSemanal() {
    }

    public InformeSemanal(Long id_informe, List<Entidad> entidadesPromedioCierreIncidentes, List<Entidad> entidadesMayorCantidadIncidentes, List<Comunidad> comunidadesMayorImpacto) {
        this.id_informe = id_informe;
        this.entidadesPromedioCierreIncidentes = entidadesPromedioCierreIncidentes;
        this.entidadesMayorCantidadIncidentes = entidadesMayorCantidadIncidentes;
        this.comunidadesMayorImpacto = comunidadesMayorImpacto;
    }

    public Long getId_informe() {
        return id_informe;
    }

    public void setId_informe(Long id_informe) {
        this.id_informe = id_informe;
    }

    public List<Entidad> getEntidadesPromedioCierreIncidentes() {
        return entidadesPromedioCierreIncidentes;
    }

    public void setEntidadesPromedioCierreIncidentes(List<Entidad> entidadesPromedioCierreIncidentes) {
        this.entidadesPromedioCierreIncidentes = entidadesPromedioCierreIncidentes;
    }

    public List<Entidad> getEntidadesMayorCantidadIncidentes() {
        return entidadesMayorCantidadIncidentes;
    }

    public void setEntidadesMayorCantidadIncidentes(List<Entidad> entidadesMayorCantidadIncidentes) {
        this.entidadesMayorCantidadIncidentes = entidadesMayorCantidadIncidentes;
    }

    public List<Comunidad> getComunidadesMayorImpacto() {
        return comunidadesMayorImpacto;
    }

    public void setComunidadesMayorImpacto(List<Comunidad> comunidadesMayorImpacto) {
        this.comunidadesMayorImpacto = comunidadesMayorImpacto;
    }
}
