package Grupo11.DDS_TP_Integrador.Servicios;
import Grupo11.DDS_TP_Integrador.Establecimientos.*;
import jakarta.persistence.*;

@Entity(name = "prestaciones")
public class Prestacion{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prestacion;

    @Column(name = "nombre_prestacion")
    private String nombre_prestacion;

    @ManyToOne
    @JoinColumn(name = "establecimiento")
    private Establecimiento establecimiento;

    @OneToOne
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;

    public Prestacion() {
    }

    public Prestacion(Long id_prestacion, String nombre_prestacion, Establecimiento establecimiento, Servicio servicio) {
        this.id_prestacion = id_prestacion;
        this.nombre_prestacion = nombre_prestacion;
        this.establecimiento = establecimiento;
        this.servicio = servicio;
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

    public Prestacion(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}

