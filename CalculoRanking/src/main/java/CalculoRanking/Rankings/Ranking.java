package CalculoRanking.Rankings;

import CalculoRanking.Incidentes.*;
import jakarta.persistence.*;

import java.util.List;

@Entity(name="Ranking")
public class Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_ranking")
    private Long id_ranking;
    @ManyToMany
    @JoinTable(
            name = "Incidentes",
            inverseJoinColumns = @JoinColumn(name = "id_incidente")
    )
    private List<Incidente> incidentes;

    public void setIncidentes(List<Incidente> incidentes){
        this.incidentes = incidentes;
    }



    //metodos utilitarios
 /*
    public Ranking() {
    }

    public Long getId_ranking3() {
        return id_ranking3;
    }

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

