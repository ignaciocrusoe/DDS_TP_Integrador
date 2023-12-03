package Grupo11.DDS_TP_Integrador.Servicios;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "prestaciones")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "prestacion", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Compuesta")
public class Prestacion{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrestacion;

    @Column(name = "nombre_prestacion")
    private String nombrePrestacion;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "prestacionPadre")
    private Prestacion prestacionPadre;

    @OneToMany(mappedBy = "prestacionPadre", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JsonIgnore
    private List<Prestacion> prestacionesHijas;


    public Prestacion() {
    }

    public Prestacion(Long idPrestacion, String nombrePrestacion, Prestacion prestacionPadre, List<Prestacion> prestacionesHijas) {
        this.idPrestacion = idPrestacion;
        this.nombrePrestacion = nombrePrestacion;
        this.prestacionPadre = prestacionPadre;
        this.prestacionesHijas = prestacionesHijas;
    }

    public boolean isLeaf() {
        return (prestacionesHijas == null || prestacionesHijas.size() == 0);
    }
    public boolean isRoot() {
        return (prestacionesHijas == null);
    }

    public Long getIdPrestacion() {
        return idPrestacion;
    }

    public void setIdPrestacion(Long idPrestacion) {
        this.idPrestacion = idPrestacion;
    }

    public String getNombrePrestacion() {
        return nombrePrestacion;
    }

    public void setNombrePrestacion(String nombrePrestacion) {
        this.nombrePrestacion = nombrePrestacion;
    }

    public Prestacion getPrestacionPadre() {
        return prestacionPadre;
    }

    public void setPrestacionPadre(Prestacion prestacionPadre) {
        this.prestacionPadre = prestacionPadre;
    }

    public List<Prestacion> getPrestacionesHijas() {
        return prestacionesHijas;
    }

    public void setPrestacionesHijas(List<Prestacion> prestacionesHijas) {
        this.prestacionesHijas = prestacionesHijas;
    }

}

