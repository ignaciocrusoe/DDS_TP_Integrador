package CalculoRanking.Repositories;

import CalculoRanking.Entidades.Entidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntidadRepository extends JpaRepository<Entidad,Long>{
}