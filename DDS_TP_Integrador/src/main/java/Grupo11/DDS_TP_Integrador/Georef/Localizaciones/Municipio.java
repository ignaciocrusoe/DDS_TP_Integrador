package Grupo11.DDS_TP_Integrador.Georef.Localizaciones;

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
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

    @OneToMany(mappedBy = "municipio")
    private List<Localizacion> localizaciones;

    public Municipio(Long id_municipio, String nombre_municipio, Departamento departamento, List<Localizacion> localizaciones) {
        this.id_municipio = id_municipio;
        this.nombre_municipio = nombre_municipio;
        this.departamento = departamento;
        this.localizaciones = localizaciones;
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Localizacion> getLocalizaciones() {
        return localizaciones;
    }

    public void setLocalizaciones(List<Localizacion> localizaciones) {
        this.localizaciones = localizaciones;
    }
}
