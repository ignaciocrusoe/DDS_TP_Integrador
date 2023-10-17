package CalculoRanking.Repositories;

import CalculoRanking.Rankings.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankingRepository extends JpaRepository<Ranking,Long> {
}
