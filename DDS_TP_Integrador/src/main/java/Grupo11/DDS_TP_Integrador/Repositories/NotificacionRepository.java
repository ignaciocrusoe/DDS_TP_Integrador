package Grupo11.DDS_TP_Integrador.Repositories;

import Grupo11.DDS_TP_Integrador.Notificadores.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion,Long> {

    List<Notificacion> findAllByPersonaIdPersona(Long idPersona);

}
