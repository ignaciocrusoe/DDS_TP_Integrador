package Grupo11.DDS_TP_Integrador.Localizaciones;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "municipios")
public class Municipio{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_municipio")
    private Long id_municipio;
    @Column(name = "nombre_municipio")
    private String nombre_municipio;
    @ManyToOne
    @JoinColumn(name = "id_provincia")
    private Provincia provincia;

    @Column(name = "latitud_municipio")
    private Double latitud_municipio;
    @Column(name = "longuitud_municipio")
    private Double longuitud_municipio;
    @OneToMany(mappedBy = "municipio")
    private List<Localizacion> localidades;

    public Municipio(Long id_municipio, String nombre_municipio, Provincia provincia, Double latitud_municipio, Double longuitud_municipio, List<Localizacion> localidades) {
        this.id_municipio = id_municipio;
        this.nombre_municipio = nombre_municipio;
        this.provincia = provincia;
        this.latitud_municipio = latitud_municipio;
        this.longuitud_municipio = longuitud_municipio;
        this.localidades = localidades;
    }

    public Municipio() {
    }

    public Long getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(Long id_municipio) {
        this.id_municipio = id_municipio;
    }

    public String getNombre_municipio() {
        return nombre_municipio;
    }

    public void setNombre_municipio(String nombre_municipio) {
        this.nombre_municipio = nombre_municipio;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Double getLatitud_municipio() {
        return latitud_municipio;
    }

    public void setLatitud_municipio(Double latitud_municipio) {
        this.latitud_municipio = latitud_municipio;
    }

    public Double getLonguitud_municipio() {
        return longuitud_municipio;
    }

    public void setLonguitud_municipio(Double longuitud_municipio) {
        this.longuitud_municipio = longuitud_municipio;
    }

    public List<Localizacion> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<Localizacion> localidades) {
        this.localidades = localidades;
    }
}
