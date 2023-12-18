package Grupo11.DDS_TP_Integrador.Rankings;

import Grupo11.DDS_TP_Integrador.Comunidades.Comunidad;
import Grupo11.DDS_TP_Integrador.Entidades.Entidad;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
@Entity(name="rankingMasIncidentes")
@IdClass(RankingPK.class)
public class RankingMasIncidentes {
    @Id
    @ManyToOne
    @JoinColumn(name = "entidad")
    private Entidad entidad;

    @Id
    @ManyToOne
    @JoinColumn(name = "ranking")
    private Ranking ranking;

    @Column(name = "posicion")
    private Integer posicion;

    //metodos utilitarios


    public RankingMasIncidentes(Entidad entidad, Ranking ranking, Integer posicion) {
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

    public RankingMasIncidentes() {
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

    public LocalDateTime getDate() {
        return this.ranking.getDate();
    }
}
