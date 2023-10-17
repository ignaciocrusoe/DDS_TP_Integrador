package CalculoRanking.Rankings;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Ranking")
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_ranking")
    private Long id_ranking;
    @Column(name = "fechaRanking")
    private LocalDateTime fechaRanking;

    @OneToMany( mappedBy = "ranking", cascade = CascadeType.ALL)
    private List<RankingMayorImpacto> rankingMayorImpacto;

    public Ranking() {
        this.rankingMayorImpacto = new ArrayList<>();
    }

    public Ranking(Long id_ranking, LocalDateTime fechaRanking, List<RankingMayorImpacto> rankingMayorImpacto) {
        this.id_ranking = id_ranking;
        this.fechaRanking = fechaRanking;
        this.rankingMayorImpacto = rankingMayorImpacto;
    }

    public Ranking(LocalDateTime fechaRanking) {
        this.fechaRanking = fechaRanking;
    }

    public Long getId_ranking() {
        return id_ranking;
    }

    public void setId_ranking(Long id_ranking) {
        this.id_ranking = id_ranking;
    }

    public LocalDateTime getFechaRanking() {
        return fechaRanking;
    }

    public void setFechaRanking(LocalDateTime fechaRanking) {
        this.fechaRanking = fechaRanking;
    }

    public List<RankingMayorImpacto> getRankingMayorImpacto() {
        return rankingMayorImpacto;
    }

    public void setRankingMayorImpacto(List<RankingMayorImpacto> rankingMayorImpacto) {
        this.rankingMayorImpacto = rankingMayorImpacto;
    }
}
