package Grupo11.DDS_TP_Integrador.Repositories;


import Grupo11.DDS_TP_Integrador.Comunidades.ComunidadXIncidente;
import Grupo11.DDS_TP_Integrador.Comunidades.ComunidadXIncidenteId;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Table(name = "comunidad_x_incidente")

public interface ComunidadXIncidenteRepository extends JpaRepository<ComunidadXIncidente, ComunidadXIncidenteId> {

    List<ComunidadXIncidente> findAllByIdComunidad(Long idComunidad);

}