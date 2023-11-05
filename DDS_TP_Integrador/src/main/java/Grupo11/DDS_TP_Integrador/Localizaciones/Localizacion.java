package Grupo11.DDS_TP_Integrador.Localizaciones;

import Grupo11.DDS_TP_Integrador.Establecimientos.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;
import jakarta.persistence.*;

@Entity(name = "localizaciones")
public class Localizacion{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_localizacion;

    @Column(name = "nombre_localizacion")
    private String nombre_localizacion;

    @ManyToOne
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;

    @Column(name = "latitud")
    private Double latitud;
    @Column(name = "longuitud")
    private Double longuitud;


    public Localizacion(Long id_localizacion, String nombre_localizacion, Municipio municipio, Double latitud, Double longuitud) {
        this.id_localizacion = id_localizacion;
        this.nombre_localizacion = nombre_localizacion;
        this.municipio = municipio;
        this.latitud = latitud;
        this.longuitud = longuitud;
    }

    public Localizacion() {
    }

    public Long getId_localizacion() {
        return id_localizacion;
    }

    public void setId_localizacion(Long id_localizacion) {
        this.id_localizacion = id_localizacion;
    }

    public String getNombre_localizacion() {
        return nombre_localizacion;
    }

    public void setNombre_localizacion(String nombre_localizacion) {
        this.nombre_localizacion = nombre_localizacion;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLonguitud() {
        return longuitud;
    }

    public void setLonguitud(Double longuitud) {
        this.longuitud = longuitud;
    }
}

