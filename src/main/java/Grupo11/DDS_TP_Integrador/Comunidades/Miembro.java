package Grupo11.DDS_TP_Integrador.Comunidades;

//import Grupo11.DDS_TP_Integrador.Localizaciones.*;

import jakarta.persistence.*;

@Entity(name="membresias")
public class Miembro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_miembro")
    private Long id_miembro;

    @ManyToOne
    @JoinColumn(name="comunidad")
    private Comunidad comunidad;

    @ManyToOne
    @JoinColumn(name = "persona")
    private Persona persona;

    @Enumerated(EnumType.STRING)
    @Column(name="rol_comunidad")
    private Rol rolEnComunidad;

    @Enumerated(EnumType.STRING)
    @Column(name="rol_usuario")
    private TipoUsuario tipoUsuario;

    public Miembro(Long id_miembro, Comunidad comunidad, Persona persona, Rol rolEnComunidad, TipoUsuario tipoUsuario) {
        this.id_miembro = id_miembro;
        this.comunidad = comunidad;
        this.persona = persona;
        this.rolEnComunidad = rolEnComunidad;
        this.tipoUsuario = tipoUsuario;
    }

    public Long getid_miembro() {
        return id_miembro;
    }

    public void setid_miembro(Long id_miembro) {
        this.id_miembro = id_miembro;
    }

    public Comunidad getcomunidad() {
        return comunidad;
    }

    public Persona getPersona() {
        return persona;
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
