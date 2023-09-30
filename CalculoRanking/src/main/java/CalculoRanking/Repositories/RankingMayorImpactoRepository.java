package CalculoRanking.Repositories;

import CalculoRanking.Entidades.Entidad;
import CalculoRanking.Rankings.RankingMayorImpacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankingMayorImpactoRepository extends JpaRepository<RankingMayorImpacto,Long> {
}
