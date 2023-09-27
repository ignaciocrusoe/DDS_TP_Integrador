package CalculoRanking.Rankings;

import CalculoRanking.Entidades.Entidad;
import CalculoRanking.Incidentes.*;
import jakarta.persistence.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="RankingMayorImpacto")
public class Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_ranking3")
    private Long id_ranking;
    @OneToMany(mappedBy = "rankingMayorImpacto")
    private List<Entidad> entidades;





    //metodos utilitarios



    public Ranking() {
    }

    public Ranking(Long id_ranking, List<Entidad> entidades) {
        this.id_ranking = id_ranking;
        this.entidades = entidades;
    }

    public Long getId_ranking() {
        return id_ranking;
    }

    public void setId_ranking(Long id_ranking) {
        this.id_ranking = id_ranking;
    }

    public Long getId() {
        if(id_ranking == null){
            return 0L;
        }
        else {
            return id_ranking;
        }
    }
    public List<Entidad> getEntidades(){
        return this.entidades;
    }

    public void setEntidades(List<Entidad> entidades){
        this.entidades = entidades;
    }
 /*
    public void setId_ranking3(Long id_ranking3) {
        this.id_ranking3 = id_ranking3;
    }

    public List<Long> getComunidades() {
        return comunidades;
    }
    public void setComunidades(List<Comunidad> comunidades) {
        this.comunidades = comunidades;
    }
    */
}

