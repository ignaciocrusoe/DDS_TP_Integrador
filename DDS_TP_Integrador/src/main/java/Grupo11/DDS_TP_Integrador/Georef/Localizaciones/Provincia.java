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

    @OneToMany(mappedBy = "provincia")
    private List<Departamento> departamentos;

    public Provincia(Long id_provincia, String nombre_provincia, List<Departamento> departamentos) {
        this.id_provincia = id_provincia;
        this.nombre_provincia = nombre_provincia;
        this.departamentos = departamentos;
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

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
}
