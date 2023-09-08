package Grupo11.DDS_TP_Integrador.Servicios;

import jakarta.persistence.*;

@Entity(name = "servicios")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_servicio")
    protected Long id_servicio;

    @Column(name = "nombre_servicio")
    private String nombre_servicio;

    public Servicio() {
    }

    public Servicio(Long id_servicio, String nombre_servicio) {
        this.id_servicio = id_servicio;
        this.nombre_servicio = nombre_servicio;
    }

    public Long getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Long id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }
}

