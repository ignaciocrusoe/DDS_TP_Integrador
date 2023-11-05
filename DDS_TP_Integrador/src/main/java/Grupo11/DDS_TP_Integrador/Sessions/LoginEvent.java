package Grupo11.DDS_TP_Integrador.Sessions;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LoginEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idUsuario")
    private String idUsuario;  // Updated property name to match the repository method

    @Column(name = "loginTime")
    private LocalDateTime loginTime;  // Updated property name to match the repository method

    @Column(name = "logoutTime")
    private LocalDateTime logoutTime;  // Updated property name to match the repository method

    public LoginEvent() {
    }

    public LoginEvent(Long id, String idUsuario, LocalDateTime loginTime, LocalDateTime logoutTime) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
