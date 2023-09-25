package CalculoRanking.Intereses;
/*
import Grupo11.DDS_TP_Integrador.Comunidades.Comunidad;
import Grupo11.DDS_TP_Integrador.Comunidades.Persona;
*/

import jakarta.persistence.*;

@Entity(name = "intereses")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Interes{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    protected Long id;

    @Column(name="nombre")
    protected String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id_interes) {
        this.id = id_interes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}