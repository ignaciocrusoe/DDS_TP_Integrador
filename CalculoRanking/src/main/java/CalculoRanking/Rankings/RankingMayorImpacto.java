package CalculoRanking.Rankings;


import CalculoRanking.Entidades.Entidad;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity(name="rankingMayorImpacto")
@IdClass(RankingPK.class)
public class RankingMayorImpacto {

    @Id
    @ManyToOne
    @JoinColumn(name = "entidad")
    private Entidad entidad;

    @JsonIgnore
    @Id
    @ManyToOne
    @JoinColumn(name = "ranking")
    private Ranking ranking;

    @Column(name = "posicion")
    private Integer posicion;

    //metodos utilitarios


    public RankingMayorImpacto(Entidad entidad, Ranking ranking, Integer posicion) {
        this.entidad = entidad;
        this.ranking = ranking;
        this.posicion = posicion;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

    public RankingMayorImpacto() {
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }
}

