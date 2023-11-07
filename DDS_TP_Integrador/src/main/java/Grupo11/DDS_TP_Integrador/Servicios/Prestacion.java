package Grupo11.DDS_TP_Integrador.Servicios;
import Grupo11.DDS_TP_Integrador.Establecimientos.*;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "prestaciones")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "prestacion", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Compuesta")
public class Prestacion{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prestacion;

    @Column(name = "nombre_prestacion")
    private String nombre_prestacion;

    @ManyToOne()
    @JoinColumn(name = "prestacionPadre")
    private Prestacion prestacionPadre;

    @OneToMany(mappedBy = "prestacionPadre", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Prestacion> prestacionesHijas;


    public Prestacion() {
    }

    public Prestacion(Long id_prestacion, String nombre_prestacion, Prestacion prestacionPadre, List<Prestacion> prestacionesHijas) {
        this.id_prestacion = id_prestacion;
        this.nombre_prestacion = nombre_prestacion;
        this.prestacionPadre = prestacionPadre;
        this.prestacionesHijas = prestacionesHijas;
    }

    public boolean isLeaf() {
        return (prestacionesHijas == null || prestacionesHijas.size() == 0);
    }
    public boolean isRoot() {
        return (prestacionesHijas == null);
    }

    public Long getId_prestacion() {
        return id_prestacion;
    }

    public void setId_prestacion(Long id_prestacion) {
        this.id_prestacion = id_prestacion;
    }

    public String getNombre_prestacion() {
        return nombre_prestacion;
    }

    public void setNombre_prestacion(String nombre_prestacion) {
        this.nombre_prestacion = nombre_prestacion;
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

