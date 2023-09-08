package Grupo11.DDS_TP_Integrador.Rankings;

import Grupo11.DDS_TP_Integrador.Entidades.Entidad;
import jakarta.persistence.*;

import java.util.List;
@Entity(name="rankingPromedioCierreIncidente")
public class RankingPromedioCierreIncidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_ranking1")
    private Long id_ranking1;
    @OneToMany(mappedBy = "rankingPromedioCierreIncidente")
    private List<Entidad> entidades;




    //metodos utilitarios

    public RankingPromedioCierreIncidente() {
    }

    public Long getId_ranking1() {
        return id_ranking1;
    }

    public void setId_ranking1(Long id_ranking1) {
        this.id_ranking1 = id_ranking1;
    }

    public List<Entidad> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<Entidad> entidades) {
        this.entidades = entidades;
    }
}
