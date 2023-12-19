package Grupo11.DDS_TP_Integrador.Rankings;

import Grupo11.DDS_TP_Integrador.Entidades.Entidad;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
@Entity(name="rankingPromedioCierre")
@IdClass(RankingPK.class)
public class RankingPromedioCierre {
    @Id
    @ManyToOne
    @JoinColumn(name = "entidad")
    private Entidad entidad;

    @Column(name = "posicion")
    private Integer posicion;

    @Column(name = "fecha")
    private LocalDateTime fecha;
    //metodos utilitarios



    //metodos utilitarios


    public RankingPromedioCierre() {
    }

    public RankingPromedioCierre(Entidad entidad, Integer posicion, LocalDateTime) {
        this.entidad = entidad;
        this.posicion = posicion;
        this.fecha = fecha;
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
