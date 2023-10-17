package CalculoRanking.Controllers;

import CalculoRanking.Calculo.CalculoRanking;
import CalculoRanking.Entidades.Entidad;
import CalculoRanking.Incidentes.Incidente;
import CalculoRanking.RankingRequest.RankingRequest;
import CalculoRanking.Rankings.Ranking;
import CalculoRanking.Rankings.RankingMayorImpacto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CalculoRankingController {

    @Autowired
    CalculoRanking calculoRanking;


    @Operation(summary="Genera un ranking", description="Dada una lista de entidades y un coeficiente entero como body, devuelve devuelve un ranking ordenado según que entidades tengan mayor impacto en comunidades.")
    @GetMapping("/calculoRanking")

    public ResponseEntity<Ranking> calcularRanking(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
        description = "Se pide una lista de entidades y un coeficiente"
            )
        @RequestBody RankingRequest rankingRequest){

        List<Entidad> entidades = rankingRequest.getEntidades();
        int cnf = rankingRequest.getCoeficiente();

        List<Entidad> entidadesOrdenadas = calculoRanking.calcularRanking(entidades, cnf);

        int index = 0;
        Ranking ranking = new Ranking(LocalDateTime.now());

        for (Entidad entidad : entidadesOrdenadas) {
            ranking.getRankingMayorImpacto().add(new RankingMayorImpacto(entidad, ranking, index));
            index++;
        }
        return new ResponseEntity<Ranking>(ranking, HttpStatus.OK);

    }

}