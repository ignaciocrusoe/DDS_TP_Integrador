package Grupo11.DDS_TP_Integrador.Rankings;

import Grupo11.DDS_TP_Integrador.Entidades.Entidad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Ranking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_ranking")
    private Long id_ranking;

    @Column(name = "fechaRanking")
    private LocalDateTime fechaRanking;

    @Column(name = "tipo_ranking")
    private Integer tipoRanking;

//    @OneToMany(mappedBy = "ranking")
//    private List<RankingMasIncidentes> rankingMasIncidentes;

//    @OneToMany(mappedBy = "ranking")
//    private List<RankingPromedioCierre> rankingPromedioCierre;

//    @OneToMany(mappedBy = "ranking")
//    private List<RankingMayorImpacto> rankingMayorImpacto;

//    public Ranking() {
//        this.rankingMayorImpacto = new ArrayList<>();
//    }
//
//    public Ranking(Long id_ranking, LocalDateTime fechaRanking, List<RankingMasIncidentes> rankingMasIncidentes, List<RankingPromedioCierre> rankingPromedioCierre, List<RankingMayorImpacto> rankingMayorImpacto) {
//        this.id_ranking = id_ranking;
//        this.fechaRanking = fechaRanking;
//        this.rankingMasIncidentes = rankingMasIncidentes;
//        this.rankingPromedioCierre = rankingPromedioCierre;
//        this.rankingMayorImpacto = rankingMayorImpacto;
//    }
//
//    public Ranking(LocalDateTime fechaRanking) {
//        this.fechaRanking = fechaRanking;
//    }
//    public Long getId_ranking() {
//        return id_ranking;
//    }
//
//    public void setId_ranking(Long id_ranking) {
//        this.id_ranking = id_ranking;
//    }
//
//    public LocalDateTime getFechaRanking() {
//        return fechaRanking;
//    }
//
//    public void setFechaRanking(LocalDateTime fechaRanking) {
//        this.fechaRanking = fechaRanking;
//    }
//
//    public List<RankingMasIncidentes> getRankingMasIncidentes() {
//        return rankingMasIncidentes;
//    }
//
//    public void setRankingMasIncidentes(List<RankingMasIncidentes> rankingMasIncidentes) {
//        this.rankingMasIncidentes = rankingMasIncidentes;
//    }
//
//    public List<RankingPromedioCierre> getRankingPromedioCierre() {
//        return rankingPromedioCierre;
//    }
//
//    public void setRankingPromedioCierre(List<RankingPromedioCierre> rankingPromedioCierre) {
//        this.rankingPromedioCierre = rankingPromedioCierre;
//    }
//
//    public List<RankingMayorImpacto> getRankingMayorImpacto() {
//        return rankingMayorImpacto;
//    }
//
//    public void setRankingMayorImpacto(List<RankingMayorImpacto> rankingMayorImpacto) {
//        this.rankingMayorImpacto = rankingMayorImpacto;
//    }

    public LocalDateTime getDate() {
        return this.fechaRanking;
    }
    public void setTipoRanking(Integer tipoRanking){this.tipoRanking = tipoRanking;}
    public Integer getTipoRanking(){
        return tipoRanking;
    }
}
