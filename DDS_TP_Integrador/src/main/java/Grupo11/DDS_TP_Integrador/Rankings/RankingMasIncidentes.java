package Grupo11.DDS_TP_Integrador.Rankings;

import Grupo11.DDS_TP_Integrador.Comunidades.Comunidad;
import Grupo11.DDS_TP_Integrador.Entidades.Entidad;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
@Entity(name="rankingMasIncidentes")
//@IdClass(RankingPK.class)
public class RankingMasIncidentes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "entidad")
    private Entidad entidad;

    @Column(name = "posicion")
    private Integer posicion;

    @Column(name = "fecha")
    private LocalDateTime fecha;
    //metodos utilitarios


    public RankingMasIncidentes(Entidad entidad, Integer posicion , LocalDateTime fecha) {
        this.entidad = entidad;
        this.posicion = posicion;
        this.fecha = fecha;
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
        return fecha;
    }
}


