package Grupo11.DDS_TP_Integrador.Repositories;

import Grupo11.DDS_TP_Integrador.Entidades.*;
import Grupo11.DDS_TP_Integrador.Rankings.RankingMasIncidentes;
import Grupo11.DDS_TP_Integrador.Rankings.RankingMayorImpacto;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RankingMasIncidentesRepository extends JpaRepository<RankingMasIncidentes,Long> {
}
