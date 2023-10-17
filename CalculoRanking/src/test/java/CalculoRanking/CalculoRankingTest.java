package CalculoRanking;

import CalculoRanking.Entidades.Entidad;
import CalculoRanking.Incidentes.Incidente;

import CalculoRanking.Repositories.EntidadRepository;
import CalculoRanking.Repositories.RankingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import CalculoRanking.Calculo.CalculoRanking;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest

public class CalculoRankingTest {
    @Autowired
    private EntidadRepository entidadRepo;
    @Autowired
    private RankingRepository rankingRepo;
    @Autowired
    private CalculoRanking calculoRanking;

    @Test
    public void guardarEntidades() throws InterruptedException {
        Incidente incidente1 = new Incidente(LocalDateTime.now() );
        Thread.sleep(2000);
        Incidente incidente2 = new Incidente(LocalDateTime.now() );
        Thread.sleep(2000);

        Entidad entidad1 = new Entidad();
        Entidad entidad2 = new Entidad();

        incidente1.setEntidad(entidad1);
        incidente2.setEntidad(entidad1);

        List<Incidente> incidentes1 = new ArrayList<Incidente>();

        incidentes1.add(incidente1);
        incidentes1.add(incidente2);

        entidad1.setIncidentes_reportados(incidentes1);

        Incidente incidente3 = new Incidente(LocalDateTime.now() );
        Thread.sleep(2000);
        Incidente incidente4 = new Incidente(LocalDateTime.now() );

        incidente3.setEntidad(entidad2);
        incidente4.setEntidad(entidad2);

        List<Incidente> incidentes2 = new ArrayList<Incidente>();
        incidentes2.add(incidente3);
        incidentes2.add(incidente4);

        entidad2.setIncidentes_reportados(incidentes2);

        entidadRepo.save(entidad1);
        entidadRepo.save(entidad2);
    }

    @Test
    public void calcularRanking(){
        calculoRanking.calcularRankingSemanal(2);
    }


}
