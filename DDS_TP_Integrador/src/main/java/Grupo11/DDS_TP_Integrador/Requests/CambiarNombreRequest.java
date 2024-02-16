package Grupo11.DDS_TP_Integrador.Requests;

public class CambiarNombreRequest {
    private String nuevoNombre;
    private String nuevoApellido;
    private String imagen_perfil;
    private Long idPersona;

    public String getNuevoNombre() {
        return nuevoNombre;
    }

    public void setNuevoNombre(String nuevoNombre) {
        this.nuevoNombre = nuevoNombre;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }
    public String getNuevoApellido() {
        return nuevoApellido;
    }

    public void setNuevoApellido(String nuevoApellido) {
        this.nuevoApellido = nuevoApellido;
    }

    public void setImagen_perfil(String imagen_perfil) {
        this.imagen_perfil = imagen_perfil;
    }
    public String getImagen_perfil() {
        return imagen_perfil;
    }
}
