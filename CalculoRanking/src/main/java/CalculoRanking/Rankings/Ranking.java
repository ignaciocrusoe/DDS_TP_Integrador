package CalculoRanking.Rankings;

import CalculoRanking.Entidades.Entidad;
import CalculoRanking.Incidentes.*;
import jakarta.persistence.*;

import java.sql.*;
import java.util.ArrayList;
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
    private List<Entidad> entidades;

    public void setEntidades(List<Entidad> entidades){
        this.entidades = entidades;
    }



    //metodos utilitarios



    public Ranking() {
    }

    public Long getId() {
        return id_ranking;
    }
    public List<Entidad> getEntidades(){
        return this.entidades;
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

