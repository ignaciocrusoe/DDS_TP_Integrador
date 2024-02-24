package Grupo11.DDS_TP_Integrador.Requests;

import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Field;

public class CambiarNombreRequest {
    private String nuevoNombre;
    private String nuevoApellido;
    private String nuevaImagen;
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

    public void setNuevaImagen(String imagen_perfil) { this.nuevaImagen = imagen_perfil; }
    public String getNuevaImagen() { return nuevaImagen; }
}
