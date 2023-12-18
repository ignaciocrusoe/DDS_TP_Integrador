package Grupo11.DDS_TP_Integrador.Repositories;

import Grupo11.DDS_TP_Integrador.Entidades.*;
import Grupo11.DDS_TP_Integrador.Rankings.RankingMayorImpacto;
import Grupo11.DDS_TP_Integrador.Rankings.RankingPromedioCierre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankingPromedioCierreRepository extends JpaRepository<RankingPromedioCierre,Long> {
}
