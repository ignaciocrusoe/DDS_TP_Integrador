package Grupo11.DDS_TP_Integrador.Rankings;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Collections;
import Grupo11.DDS_TP_Integrador.Entidades.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;

import Grupo11.DDS_TP_Integrador.Entidades.*;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import Grupo11.DDS_TP_Integrador.Repositories.EntidadRepository;
import Grupo11.DDS_TP_Integrador.Requests.SubirCsvEntidadesRequest;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Component
    public class TareaProgramada {

        @Scheduled(cron = "0 0 0 ? * SUN")  // Ejecutar cada domingo a medianoche
        public void ejecutarTareaSemanal() {
            calcularRankings();
        }

        public void calcularRankings() {

            //obtiene las entidades de la DB
            List<Entidad> entidades = entidadRepository.findAll();

            //calcula los rankings

            List<Entidad> entidadesSegunMasincidentes = calculadorRankingMasIncidentes.calcularRanking(entidades);
            List<Entidad> entidadesSegunTiempoPromedio =  calculadorRankingTiempoPromedio.calcularRanking(entidades);

            //almacena los rankings en la DB
            calculadorRankingMasIncidentes.guardarRankingMasIncidentes(entidadesSegunMasincidentes);
            calculadorRankingTiempoPromedio.guardarRankingPromedioCierre(entidadesSegunTiempoPromedio);
        }

    }
}

