package Grupo11.DDS_TP_Integrador.Repositories;

import Grupo11.DDS_TP_Integrador.Sessions.LoginEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface LoginEventRepository extends JpaRepository<LoginEvent, Long> {
    LoginEvent findFirstByIdUsuarioOrderByLoginTimeDesc(String idUsuario);
    
}