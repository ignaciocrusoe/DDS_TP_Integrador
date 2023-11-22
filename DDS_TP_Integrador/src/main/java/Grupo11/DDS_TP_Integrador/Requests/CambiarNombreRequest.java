package Grupo11.DDS_TP_Integrador.Requests;

public class CambiarNombreRequest {
    private String nuevoNombre;
    private String nuevoApellido;
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
}
