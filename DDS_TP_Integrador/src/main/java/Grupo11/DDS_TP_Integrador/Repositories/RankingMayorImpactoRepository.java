package Grupo11.DDS_TP_Integrador.Repositories;

import Grupo11.DDS_TP_Integrador.Entidades.*;
import Grupo11.DDS_TP_Integrador.Rankings.RankingMayorImpacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingMayorImpactoRepository extends JpaRepository<RankingMayorImpacto,Long> {
}
