package Grupo11.DDS_TP_Integrador.Rankings;

import Grupo11.DDS_TP_Integrador.Entidades.Entidad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Ranking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_ranking")
    private Long id_ranking;

    @Column(name = "fechaRanking")
    private LocalDateTime fechaRanking;

    @Column(name = "tipo_ranking")
    private Integer tipoRanking;

    public LocalDateTime getDate() {
        return this.fechaRanking;
    }
    public void setTipoRanking(Integer tipoRanking){this.tipoRanking = tipoRanking;}
    public Integer getTipoRanking(){
        return tipoRanking;
    }

    public Long getId() {
        return id_ranking;
    }
    void setTime(LocalDateTime time)
    {
        this.fechaRanking = time;
    }
}
