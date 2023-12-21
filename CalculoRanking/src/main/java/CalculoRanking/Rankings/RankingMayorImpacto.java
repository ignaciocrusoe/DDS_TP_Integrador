package CalculoRanking.Rankings;


import CalculoRanking.Entidades.Entidad;
import CalculoRanking.Incidentes.Incidente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Entity(name="rankingMayorImpacto")
//@IdClass(RankingPK.class)
public class RankingMayorImpacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "entidad")
    private Entidad entidad;

    @ManyToOne
    @JoinColumn(name = "ranking")
    private Ranking ranking;

    @Column(name = "posicion")
    private Integer posicion;

    @Column(name = "impacto")
    private Long impacto;

    @Column(name = "fecha")
    private LocalDateTime fecha;
    //metodos utilitarios
/*
    private Long calcularImpacto(Integer cnf, Entidad entidad){
        Long impacto = 0L;
        Long sumatoriaTiempoResolucion = 0L;
        Integer incidentesNoResueltos = entidad.getIncidentes_reportados().stream().filter(obj -> !obj.getEstado()).collect(Collectors.toList()).size();
        for(Incidente incidente : entidad.getIncidentes_reportados()){
            sumatoriaTiempoResolucion += incidente.duracion();
        }
        impacto = sumatoriaTiempoResolucion + incidentesNoResueltos * cnf;
    }
*/

    public RankingMayorImpacto(Entidad entidad, Ranking ranking, int posicion, LocalDateTime fecha) {
        this.entidad = entidad;
        this.ranking = ranking;
        this.fecha = fecha;
        this.posicion = posicion;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
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

