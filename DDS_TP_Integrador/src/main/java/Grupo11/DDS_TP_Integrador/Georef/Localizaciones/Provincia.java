package Grupo11.DDS_TP_Integrador.Georef.Localizaciones;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "provincias")
public class Provincia{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_provincia")
    private Long id_provincia;

    @Column(name = "nombre_provincia")
    private String nombre_provincia;

    @Column(name = "latitud_provincia")
    private Double latitud_provincia;
    @Column(name = "longuitud_provincia")
    private Double longuitud_provincia;

    @OneToMany(mappedBy = "provincia")
    private List<Municipio> municipos;

    public Provincia(Long id_provincia, String nombre_provincia, Double latitud_provincia, Double longuitud_provincia, List<Municipio> municipos) {
        this.id_provincia = id_provincia;
        this.nombre_provincia = nombre_provincia;
        this.latitud_provincia = latitud_provincia;
        this.longuitud_provincia = longuitud_provincia;
        this.municipos = municipos;
    }

    public Provincia() {
    }

    public Long getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(Long id_provincia) {
        this.id_provincia = id_provincia;
    }

    public String getNombre_provincia() {
        return nombre_provincia;
    }

    public void setNombre_provincia(String nombre_provincia) {
        this.nombre_provincia = nombre_provincia;
    }

    public List<Municipio> getMunicipos() {
        return municipos;
    }

    public Double getLatitud_provincia() {
        return latitud_provincia;
    }

    public void setLatitud_provincia(Double latitud_provincia) {
        this.latitud_provincia = latitud_provincia;
    }

    public Double getLonguitud_provincia() {
        return longuitud_provincia;
    }

    public void setLonguitud_provincia(Double longuitud_provincia) {
        this.longuitud_provincia = longuitud_provincia;
    }

    public void setMunicipos(List<Municipio> municipos) {
        this.municipos = municipos;
    }
}
