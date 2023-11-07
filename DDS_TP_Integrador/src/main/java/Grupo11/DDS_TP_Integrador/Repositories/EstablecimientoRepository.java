package Grupo11.DDS_TP_Integrador.Repositories;

import Grupo11.DDS_TP_Integrador.Establecimientos.Establecimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstablecimientoRepository extends JpaRepository<Establecimiento,Long>{
    Establecimiento findByNombreEstablecimiento(String establecimiento);
}