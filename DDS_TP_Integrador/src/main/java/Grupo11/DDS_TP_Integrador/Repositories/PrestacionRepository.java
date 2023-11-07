package Grupo11.DDS_TP_Integrador.Repositories;

import Grupo11.DDS_TP_Integrador.Establecimientos.Establecimiento;
import Grupo11.DDS_TP_Integrador.Servicios.Prestacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestacionRepository extends JpaRepository<Prestacion,Long>{
    Prestacion findByNombrePrestacion(String prestacion);
}