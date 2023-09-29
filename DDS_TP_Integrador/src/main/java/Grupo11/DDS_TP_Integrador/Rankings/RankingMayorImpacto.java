package Grupo11.DDS_TP_Integrador.Rankings;

import Grupo11.DDS_TP_Integrador.Entidades.Entidad;
import Grupo11.DDS_TP_Integrador.Entidades.Entidad;
import jakarta.persistence.*;

import java.util.List;

@Entity(name="rankingMayorImpacto")
public class RankingMayorImpacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_ranking3")
    private Long id_ranking3;
    @ManyToMany
    @JoinTable(name = "ranking_mayor_impacto_x_entidad",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_id_ranking3"))
    private List<Entidad> Entidades;

    

    //metodos utilitarios

    public RankingMayorImpacto() {
    }

    public RankingMayorImpacto(Long id_ranking3, List<Entidad> Entidades) {
        this.id_ranking3 = id_ranking3;
        this.Entidades = Entidades;
    }

    public Long getId_ranking3() {
        return id_ranking3;
    }

    public void setId_ranking3(Long id_ranking3) {
        this.id_ranking3 = id_ranking3;
    }

    public List<Entidad> getEntidades() {
        return Entidades;
    }

    public void setEntidades(List<Entidad> Entidades) {
        this.Entidades = Entidades;
    }
}

