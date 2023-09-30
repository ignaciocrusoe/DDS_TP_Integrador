package CalculoRanking.Rankings;

import CalculoRanking.Entidades.Entidad;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name="RankingMayorImpacto")
public class RankingMayorImpacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_ranking3")
    private Long id_ranking;
    @ManyToMany()
    @JoinTable(name = "ranking_mayor_impacto_x_entidad",
            joinColumns = @JoinColumn(name = "id_ranking3"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Entidad> entidades;





    //metodos utilitarios



    public RankingMayorImpacto() {

    }

    public RankingMayorImpacto(Long id_ranking, List<Entidad> entidades) {
        this.id_ranking = id_ranking;
        this.entidades = entidades;
    }

    public RankingMayorImpacto(Long id_ranking) {
        this.id_ranking = id_ranking;
        this.entidades = new ArrayList<>();
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

