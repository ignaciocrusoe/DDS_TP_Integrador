package CalculoRanking.Rankings;

import java.io.Serializable;

public class RankingPK implements Serializable {
    private Long entidad;
    private Long ranking;

    public RankingPK() {
    }

    public Long getEntidad() {
        return entidad;
    }

    public void setEntidad(Long entidad) {
        this.entidad = entidad;
    }

    public Long getRanking() {
        return ranking;
    }

    public void setRanking(Long ranking) {
        this.ranking = ranking;
    }
}