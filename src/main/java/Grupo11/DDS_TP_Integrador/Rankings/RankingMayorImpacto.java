package Grupo11.DDS_TP_Integrador.Rankings;

import Grupo11.DDS_TP_Integrador.Comunidades.Comunidad;
import Grupo11.DDS_TP_Integrador.Entidades.Entidad;
import jakarta.persistence.*;

import java.util.List;

@Entity(name="rankingMayorImpacto")
public class RankingMayorImpacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_ranking3")
    private Long id_ranking3;
    @OneToMany(mappedBy = "rankingMayorImpacto")
    private List<Comunidad> comunidades;





    //metodos utilitarios

    public RankingMayorImpacto() {
    }

    public RankingMayorImpacto(Long id_ranking3, List<Comunidad> comunidades) {
        this.id_ranking3 = id_ranking3;
        this.comunidades = comunidades;
    }

    public Long getId_ranking3() {
        return id_ranking3;
    }

    public void setId_ranking3(Long id_ranking3) {
        this.id_ranking3 = id_ranking3;
    }

    public List<Comunidad> getComunidades() {
        return comunidades;
    }

    public void setComunidades(List<Comunidad> comunidades) {
        this.comunidades = comunidades;
    }
}

