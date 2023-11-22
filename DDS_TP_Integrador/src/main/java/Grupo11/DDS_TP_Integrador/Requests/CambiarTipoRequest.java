package Grupo11.DDS_TP_Integrador.Requests;

public class CambiarTipoRequest {
    private Long idMiembro;

    private String tipo;

    public Long getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(Long idMiembro) {
        this.idMiembro = idMiembro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
