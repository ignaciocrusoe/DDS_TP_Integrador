package CalculoRanking.Entidades;

import CalculoRanking.Incidentes.*;
import CalculoRanking.Intereses.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import CalculoRanking.Rankings.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "entidades")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Entidad extends Interes{

    @Column(name = "id_entidad")
    private Long id_entidad;

    @Column(name = "nombre_entidad")
    private String nombre_entidad;

    @OneToMany(mappedBy = "entidad",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected List<Incidente> incidentes_reportados;

    @JsonIgnore
    @OneToMany(mappedBy = "entidad")
    protected List<RankingMayorImpacto> rankingMayorImpacto;


    //metodos utilitarios
    public Entidad() {
        this.incidentes_reportados = new ArrayList<>();
    }

    public Entidad(List<Incidente> incidentes_reportados, List<RankingMayorImpacto> rankingMayorImpacto) {
        this.incidentes_reportados = incidentes_reportados;
        this.rankingMayorImpacto = rankingMayorImpacto;
    }

    public List<Incidente> getIncidentes_reportados() {
        return incidentes_reportados;
    }

    public void setIncidentes_reportados(List<Incidente> incidentes_reportados) {
        this.incidentes_reportados = incidentes_reportados;
    }

    public List<RankingMayorImpacto> getRankingMayorImpacto() {
        return rankingMayorImpacto;
    }

    public void setRankingMayorImpacto(List<RankingMayorImpacto> rankingMayorImpacto1) {
        this.rankingMayorImpacto = rankingMayorImpacto1;
    }

}
