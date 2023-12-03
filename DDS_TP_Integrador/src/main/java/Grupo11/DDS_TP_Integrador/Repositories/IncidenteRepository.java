package Grupo11.DDS_TP_Integrador.Repositories;

import Grupo11.DDS_TP_Integrador.Comunidades.Comunidad;
import Grupo11.DDS_TP_Integrador.Incidentes.Incidente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncidenteRepository extends JpaRepository<Incidente,Long> {
    Incidente findByIdIncidente(Long idIncidente);

    List<Incidente> findByComunidadesAfectadasIsContainingAndEstadoTrue(Comunidad comunidad);
}