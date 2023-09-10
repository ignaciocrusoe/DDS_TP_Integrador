package Grupo11.calculoDeRanking.Entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "prestadores")
public class Prestador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_prestador")
    private Long id_prestador;

    @Column(name="nombre_prestador")
    private String nombre;

    @Column(name="mail_prestador")
    private String mail;
    @OneToMany(mappedBy = "prestador")
    private List<Entidad> entidades;

    public Long getId_prestador() {
        return id_prestador;
    }

    public void setId_prestador(Long id_prestador) {
        this.id_prestador = id_prestador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Entidad> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<Entidad> entidades) {
        this.entidades = entidades;
    }
}
