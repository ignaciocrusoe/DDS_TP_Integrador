package Grupo11.DDS_TP_Integrador.Comunidades;

//import Grupo11.DDS_TP_Integrador.Localizaciones.*;

import jakarta.persistence.*;

@Entity
@Table(name="membresías")
public class Miembro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_miembro")
    private Long idMiembro;

    @Transient
    private Comunidad comunidadMiembro;

    @ManyToOne
    private Persona personaMiembro;

    @Enumerated(EnumType.STRING)
    private Rol rolEnComunidad;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    public Miembro() {
    }

    public Miembro(Long idMiembro, Comunidad comunidadMiembro, Persona personaMiembro, Rol rolEnComunidad, TipoUsuario tipoUsuario) {
        this.idMiembro = idMiembro;
        this.comunidadMiembro = comunidadMiembro;
        this.personaMiembro = personaMiembro;
        this.rolEnComunidad = rolEnComunidad;
        this.tipoUsuario = tipoUsuario;
    }

    public Long getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(Long idMiembro) {
        this.idMiembro = idMiembro;
    }

    public Comunidad getComunidadMiembro() {
        return comunidadMiembro;
    }

    public Persona getPersonaMiembro() {
        return personaMiembro;
    }

    public Rol getRolEnComunidad() {
        return rolEnComunidad;
    }

    public void setRolEnComunidad(Rol rolEnComunidad) {
        this.rolEnComunidad = rolEnComunidad;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
