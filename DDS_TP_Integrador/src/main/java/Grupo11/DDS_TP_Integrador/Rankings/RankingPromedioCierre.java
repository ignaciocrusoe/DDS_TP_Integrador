package Grupo11.DDS_TP_Integrador.Rankings;

import Grupo11.DDS_TP_Integrador.Entidades.Entidad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "rankingPromedioCierre")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RankingPromedioCierre {

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

    @Column(name = "id_ranking")
    private Long idRanking;
    //metodos utilitarios

    public RankingPromedioCierre(Entidad entidad, Integer posicion, LocalDateTime fecha, Long ranking) {
        this.entidad = entidad;
        this.posicion = posicion;
        this.fecha = fecha;
        this.idRanking = ranking;
    }


    //metodos utilitarios


//    public Entidad getEntidad() {
//        return entidad;
//    }
//
//    public void setEntidad(Entidad entidad) {
//        this.entidad = entidad;
//    }
//
//    public Integer getPosicion() {
//        return posicion;
//    }
//
//    public void setPosicion(Integer posicion) {
//        this.posicion = posicion;
//    }

    public LocalDateTime getDate() {
        return this.fecha;
    }
}
