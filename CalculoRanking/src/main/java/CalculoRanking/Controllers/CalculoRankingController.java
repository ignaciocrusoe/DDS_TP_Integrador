package CalculoRanking.Controllers;

import CalculoRanking.Entidades.Entidad;
import CalculoRanking.Incidentes.Incidente;
import CalculoRanking.RankingRequest.RankingRequest;
import CalculoRanking.Rankings.CalculadorRankingMayorImpacto;
import CalculoRanking.Rankings.Ranking;
import CalculoRanking.Rankings.RankingMayorImpacto;
import CalculoRanking.Repositories.EntidadRepository;
import CalculoRanking.Repositories.RankingMayorImpactoRepository;
import CalculoRanking.Repositories.RankingRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class CalculoRankingController {


    @Autowired
    CalculadorRankingMayorImpacto calculadorRankingMayorImpacto;

    @Autowired
    RankingRepository rankingRepository;

    @Autowired
    RankingMayorImpactoRepository rankingMayorImpactoRepository;

    @Autowired
    EntidadRepository entidadRepository;


    @Operation(summary="Genera un ranking", description="Dada una lista de entidades y un coeficiente entero como body, devuelve devuelve un ranking ordenado según que entidades tengan mayor impacto en comunidades.")
    @GetMapping("/calculoRanking")

    public ResponseEntity<List<RankingMayorImpacto>> calcularRanking(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
        description = "Se pide una lista de entidades y un coeficiente"
            )
        @RequestBody RankingRequest rankingRequest){

        List<Entidad> entidades = rankingRequest.getEntidades();
        int cnf = rankingRequest.getCoeficiente();
        LocalDateTime fechaActual = LocalDateTime.now();

        List<Entidad> entidadesOrdenadas = calculadorRankingMayorImpacto.calcularRanking(entidades);
        Ranking nuevoRanking = new Ranking();
        nuevoRanking.setTime(fechaActual);
        nuevoRanking.setTipoRanking(3);
        List <RankingMayorImpacto> rankingsMayorImpacto = calculadorRankingMayorImpacto.generarRanking(entidadesOrdenadas, nuevoRanking, cnf);
        return new ResponseEntity<List<RankingMayorImpacto>>(rankingsMayorImpacto, HttpStatus.OK);

    }

    @PostMapping("/calcular-ranking")
    public ResponseEntity<Map<String, String>> calcularRankings(/*@RequestParam Integer cnf*/) {
        //String dateTime = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        Integer cnf = 2;
        LocalDateTime fechaActual = LocalDateTime.now();
        List<Entidad> entidades = entidadRepository.findAll();
        List<Entidad> entidadesOrdenadas = calculadorRankingMayorImpacto.calcularRanking(entidades);
        Ranking nuevoRanking = new Ranking();
        nuevoRanking.setTime(fechaActual);
        nuevoRanking.setTipoRanking(3);
        rankingRepository.save(nuevoRanking);
        List<RankingMayorImpacto> rankingsMayorImpacto = calculadorRankingMayorImpacto.generarRanking(entidadesOrdenadas, nuevoRanking, cnf);


        rankingMayorImpactoRepository.saveAll(rankingsMayorImpacto);

        return ResponseEntity.ok(Map.of("message", "Objects received successfully"));
    }

    @PostMapping("/calcular-ranking-prueba")
    public List<Entidad> calcularRankingsTest() {
        //String dateTime = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        Integer cnf = 2;
        LocalDateTime fechaActual = LocalDateTime.now();
        List<Entidad> entidades = entidadRepository.findAll();
        List<Entidad> entidadesOrdenadas = calculadorRankingMayorImpacto.calcularRanking(entidades);
        Ranking nuevoRanking = new Ranking();
        nuevoRanking.setTime(fechaActual);
        nuevoRanking.setTipoRanking(3);

        List<RankingMayorImpacto> rankingsMayorImpacto = calculadorRankingMayorImpacto.generarRanking(entidadesOrdenadas, nuevoRanking, cnf);



        return entidades;
    }

}