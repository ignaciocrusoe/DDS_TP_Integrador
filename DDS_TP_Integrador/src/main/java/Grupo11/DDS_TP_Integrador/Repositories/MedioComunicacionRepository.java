package Grupo11.DDS_TP_Integrador.Repositories;

import Grupo11.DDS_TP_Integrador.Comunidades.Miembro;
import Grupo11.DDS_TP_Integrador.GestoresNotificaciones.MedioComunicacion;
import Grupo11.DDS_TP_Integrador.Sessions.LoginEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedioComunicacionRepository extends JpaRepository<MedioComunicacion,Long>{
    MedioComunicacion findByNombreMedio(String NombreMedio);
}