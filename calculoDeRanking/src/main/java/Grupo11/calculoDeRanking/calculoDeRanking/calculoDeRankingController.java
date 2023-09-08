package Grupo11.calculoDeRanking.calculoDeRanking;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import Grupo11.calculoDeRanking.Incidentes.*;

@RestController
public class calculoDeRankingController {

    @GetMapping("/prueba")
    public String prueba() {
        return "prueba1";
    }

}
