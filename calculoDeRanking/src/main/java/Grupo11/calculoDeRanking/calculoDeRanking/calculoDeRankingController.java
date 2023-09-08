package Grupo11.calculoDeRanking.calculoDeRanking;

import Grupo11.calculoDeRanking.Incidentes.Incidente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//import Grupo11.calculoDeRanking.Comunidades.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class calculoDeRankingController {

    @GetMapping("/prueba")
    public Incidente prueba() {
        return new Incidente(1L, "Observación de ejemplo.", null, null, null, null, null);
    }
    
}
