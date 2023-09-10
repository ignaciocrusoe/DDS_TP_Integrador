package Grupo11.calculoDeRanking.Entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "organismosControl")
public class OrganismoControl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_organismoControl")
    private Long id_organismoControl;

    @Column(name="nombre_organismoControl")
    private String nombre;

    @Column(name="mail_organismoControl")
    private String mail;
    @OneToMany(mappedBy = "organismoControl")
    private List<Entidad> entidades;

    public Long getId_organismoControl() {
        return id_organismoControl;
    }

    public void setId_organismoControl(Long id_organismoControl) {
        this.id_organismoControl = id_organismoControl;
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
