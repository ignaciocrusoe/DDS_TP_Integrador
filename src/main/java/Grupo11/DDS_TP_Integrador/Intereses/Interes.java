package Grupo11.DDS_TP_Integrador.Intereses;

import Grupo11.DDS_TP_Integrador.Comunidades.Comunidad;
import Grupo11.DDS_TP_Integrador.Comunidades.Persona;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "intereses")
@Inheritance(strategy = InheritanceType.JOINED)
public class Interes{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_interes")
    private Long id_interes;


    @ManyToMany(mappedBy = "intereses_comunidad")
    private List<Comunidad> comunidades;


    @ManyToMany(mappedBy = "intereses_persona")
    private List<Persona> personas;

    @Column(name="nombre_interes")
    private String nombre_interes;

    public Long getId_interes() {
        return id_interes;
    }

    public void setId_interes(Long id_interes) {
        this.id_interes = id_interes;
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

    public String getNombre_interes() {
        return nombre_interes;
    }

    public void setNombre_interes(String nombre_interes) {
        this.nombre_interes = nombre_interes;
    }
}