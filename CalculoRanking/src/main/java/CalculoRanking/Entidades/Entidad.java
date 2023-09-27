package CalculoRanking.Entidades;

import CalculoRanking.Incidentes.*;
import CalculoRanking.Intereses.*;
import jakarta.persistence.*;
import CalculoRanking.Rankings.*;

import java.util.List;

@Entity(name = "entidades")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Entidad extends Interes{

    @OneToMany(mappedBy = "entidad")
    protected List<Incidente> incidentes_reportados;

    @Column(name = "cantidadIncidentes")
    protected int cantidadIncidentes; //cantidad de incidentes?

    @ManyToOne
    @JoinColumn(name = "rankingMayorImpacto")
    private Ranking rankingMayorImpacto;




    //metodos utilitarios
    public Entidad() {
    }

    public Entidad(List<Incidente> incidentes_reportados, int cantidadIncidentes, Ranking rankingMayorImpacto) {
        this.incidentes_reportados = incidentes_reportados;
        this.cantidadIncidentes = cantidadIncidentes;
        this.rankingMayorImpacto = rankingMayorImpacto;
    }

    public List<Incidente> getIncidentes_reportados() {
        return incidentes_reportados;
    }

    public void setIncidentes_reportados(List<Incidente> incidentes_reportados) {
        this.incidentes_reportados = incidentes_reportados;
    }


    public int cantidadIncidentes() {
        return cantidadIncidentes;
        //return incidentes_reportados.size();
    }
    public void setCantidadIncidentes(int cant) {
        this.cantidadIncidentes = cant;
    }

}
