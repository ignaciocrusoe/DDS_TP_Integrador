package Grupo11.DDS_TP_Integrador.Rankings;
import java.time.LocalTime;
import java.util.*;
import java.time.LocalDateTime;

import Grupo11.DDS_TP_Integrador.Entidades.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;

import Grupo11.DDS_TP_Integrador.Entidades.*;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import Grupo11.DDS_TP_Integrador.Repositories.EntidadRepository;
import Grupo11.DDS_TP_Integrador.Repositories.RankingRepository;
import Grupo11.DDS_TP_Integrador.Requests.SubirCsvEntidadesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class GestorRankings {

    @Autowired
    private CalculadorRankingMasIncidentes calculadorRankingMasIncidentes;

    @Autowired
    private CalculadorRankingTiempoPromedio calculadorRankingTiempoPromedio;

    @Autowired
    EntidadRepository entidadRepository;

    @Autowired
    RankingRepository rankingRepository;

    public void calcularRankings() {

        LocalDateTime currentTime = LocalDateTime.now();

        //Creamos los tres nuevos rankings
        Ranking rankingPromedioCierre = new Ranking();
        rankingPromedioCierre.setFechaRanking(currentTime);
        rankingPromedioCierre.setTipoRanking(1);

        Ranking rankingMasIncidentes = new Ranking();
        rankingMasIncidentes.setFechaRanking(currentTime);
        rankingMasIncidentes.setTipoRanking(2);

        //Ranking rankingMayorImpacto = new Ranking();
        //rankingMayorImpacto.setFechaRanking(currentTime);
        //rankingMayorImpacto.setTipoRanking(3);

        //obtiene las entidades de la DB
        List<Entidad> entidades = entidadRepository.findAll();

        //calcula los rankings

        List<Entidad> entidadesSegunMasincidentes = calculadorRankingMasIncidentes.calcularRanking(entidades);
        List<Entidad> entidadesSegunTiempoPromedio =  calculadorRankingTiempoPromedio.calcularRanking(entidades);

        //Invierto el orden porque tienen que esar ordenadas de mayor a menor
        Collections.reverse(entidadesSegunMasincidentes);
        Collections.reverse(entidadesSegunTiempoPromedio);

        //almacena los rankings en la DB
        calculadorRankingMasIncidentes.guardarRankingMasIncidentes(entidadesSegunMasincidentes, rankingMasIncidentes);
        calculadorRankingTiempoPromedio.guardarRankingPromedioCierre(entidadesSegunTiempoPromedio, rankingPromedioCierre);

        }

    @Scheduled(cron = "0 0 0 ? * SUN")  // Ejecutar cada domingo a medianoche
    public void calcularRankingsSemanalmente() {
        this.calcularRankings();
    }

}

