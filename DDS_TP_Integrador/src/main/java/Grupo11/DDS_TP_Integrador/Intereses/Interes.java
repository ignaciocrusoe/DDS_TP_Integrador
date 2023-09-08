package Grupo11.DDS_TP_Integrador.Intereses;

import Grupo11.DDS_TP_Integrador.Comunidades.Comunidad;
import Grupo11.DDS_TP_Integrador.Comunidades.Persona;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "intereses")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Interes{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    protected Long id;

    @ManyToMany(mappedBy = "intereses_comunidad")
    private List<Comunidad> comunidades;


    @ManyToMany(mappedBy = "intereses_persona")
    private List<Persona> personas;

    @Column(name="nombre")
    protected String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id_interes) {
        this.id = id_interes;
    }

    public List<Comunidad> getComunidades() {
        return comunidades;
    }

    public void setComunidades(List<Comunidad> comunidades) {
        this.comunidades = comunidades;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}