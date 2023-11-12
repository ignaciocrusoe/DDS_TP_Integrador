package Grupo11.DDS_TP_Integrador.Repositories;

import Grupo11.DDS_TP_Integrador.Comunidades.Miembro;
import Grupo11.DDS_TP_Integrador.GestoresNotificaciones.MedioComunicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedioComunicacionRepository extends JpaRepository<MedioComunicacion,Long>{
}