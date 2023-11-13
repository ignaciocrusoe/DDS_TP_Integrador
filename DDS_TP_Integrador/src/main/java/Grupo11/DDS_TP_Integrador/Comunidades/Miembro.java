package Grupo11.DDS_TP_Integrador.Comunidades;

//import Grupo11.DDS_TP_Integrador.Localizaciones.*;

import jakarta.persistence.*;

@Entity(name="membresias")
public class Miembro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_miembro")
    private Long idMiembro;

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

    //metodos utilitarios


    public Miembro(Long idMiembro, Comunidad comunidad, Persona persona, Rol rolEnComunidad, TipoUsuario tipoUsuario) {
        this.idMiembro = idMiembro;
        this.comunidad = comunidad;
        this.persona = persona;
        this.rolEnComunidad = rolEnComunidad;
        this.tipoUsuario = tipoUsuario;
    }

    public Miembro() {

    }

    public Long getidMiembro() {
        return idMiembro;
    }

    public void setidMiembro(Long id_miembro) {
        this.idMiembro = id_miembro;
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

    public Long getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(Long idMiembro) {
        this.idMiembro = idMiembro;
    }

    public Comunidad getComunidad() {
        return comunidad;
    }

    public void setComunidad(Comunidad comunidad) {
        this.comunidad = comunidad;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
