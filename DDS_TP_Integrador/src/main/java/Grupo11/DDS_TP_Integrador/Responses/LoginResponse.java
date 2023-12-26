package Grupo11.DDS_TP_Integrador.Responses;
public class LoginResponse {
    private String message;
    private Long IdPersona;

    public LoginResponse(String message, Long IdPersona) {
        this.message = message;
        this.IdPersona = IdPersona;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(Long IdPersona) {
        this.IdPersona = IdPersona;
    }
}

