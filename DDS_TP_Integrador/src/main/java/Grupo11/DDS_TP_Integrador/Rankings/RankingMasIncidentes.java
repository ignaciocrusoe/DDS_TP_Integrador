package Grupo11.DDS_TP_Integrador.Rankings;

import Grupo11.DDS_TP_Integrador.Comunidades.Comunidad;
import Grupo11.DDS_TP_Integrador.Entidades.Entidad;
import jakarta.persistence.*;

import java.util.List;
@Entity(name="rankingMasIncidentes")
public class RankingMasIncidentes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_ranking2")
    private Long id_ranking2;


    @ManyToMany
    @JoinTable(name = "ranking_mas_incidentes_x_entidad",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_id_ranking2"))
    private List<Entidad> entidades;


    //metodos utilitarios

    public RankingMasIncidentes() {
    }

    public RankingMasIncidentes(Long id_ranking2, List<Entidad> entidades) {
        this.id_ranking2 = id_ranking2;
        this.entidades = entidades;
    }

    public Long getId_ranking2() {
        return id_ranking2;
    }

    public void setId_ranking2(Long id_ranking2) {
        this.id_ranking2 = id_ranking2;
    }

    public List<Entidad> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<Entidad> entidades) {
        this.entidades = entidades;
    }
}
