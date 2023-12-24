package Grupo11.DDS_TP_Integrador.Repositories;

import Grupo11.DDS_TP_Integrador.Comunidades.Comunidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComunidadRepository extends JpaRepository<Comunidad,Long>{
    Comunidad findByIdComunidad(Long idComunidad);
}