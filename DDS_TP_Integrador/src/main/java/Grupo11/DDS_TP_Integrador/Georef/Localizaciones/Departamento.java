package Grupo11.DDS_TP_Integrador.Georef.Localizaciones;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "departamentos")
public class Departamento{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_departamento")
    private Long id_departamento;

    @Column(name = "nombre_departamento")
    private String nombre_departamento;
    @ManyToOne
    @JoinColumn(name = "id_provincia")
    private Provincia provincia;
    @OneToMany(mappedBy = "departamento")
    private List<Municipio> municipos;

    public Departamento(Long id_departamento, String nombre_departamento, Provincia provincia, List<Municipio> municipos) {
        this.id_departamento = id_departamento;
        this.nombre_departamento = nombre_departamento;
        this.provincia = provincia;
        this.municipos = municipos;
    }

    public Departamento() {
    }

    public Long getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Long id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNombre_departamento() {
        return nombre_departamento;
    }

    public void setNombre_departamento(String nombre_departamento) {
        this.nombre_departamento = nombre_departamento;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public List<Municipio> getMunicipos() {
        return municipos;
    }

    public void setMunicipos(List<Municipio> municipos) {
        this.municipos = municipos;
    }
}
