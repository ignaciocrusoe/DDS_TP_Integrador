package Grupo11.DDS_TP_Integrador.Sessions;

import Grupo11.DDS_TP_Integrador.Comunidades.Persona;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LoginEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLoginEvent;

    @Column(name = "idUsuario")
    private String idUsuario;  // Updated property name to match the repository method

    @Column(name = "loginTime")
    private LocalDateTime loginTime;  // Updated property name to match the repository method

    @Column(name = "logoutTime")
    private LocalDateTime logoutTime;  // Updated property name to match the repository method

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    public LoginEvent() {
    }

    public LoginEvent(Long idLoginEvent, String idUsuario, LocalDateTime loginTime, LocalDateTime logoutTime, Persona persona) {
        this.idLoginEvent = idLoginEvent;
        this.idUsuario = idUsuario;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
        this.persona = persona;
    }

    public Long getIdLoginEvent() {
        return idLoginEvent;
    }

    public void setIdLoginEvent(Long idLoginEvent) {
        this.idLoginEvent = idLoginEvent;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public LocalDateTime getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(LocalDateTime logoutTime) {
        this.logoutTime = logoutTime;
    }
}
