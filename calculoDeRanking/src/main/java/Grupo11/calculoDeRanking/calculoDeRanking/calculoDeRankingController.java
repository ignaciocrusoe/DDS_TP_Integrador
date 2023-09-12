package Grupo11.calculoDeRanking.calculoDeRanking;

import Grupo11.calculoDeRanking.Entidades.Entidad;
import Grupo11.calculoDeRanking.Incidentes.Incidente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @GetMapping("/generarRanking")
    public int generarRanking(){
        //calculoDeRanking.calculoDeRanking();
        return 1;
    }
/*
    @GetMapping("/prueba_entidad")
    public Entidad buscarEntidad(@RequestParam(id="id_entidad")){
        return new Entidad(id_entidad,)
    }

 */
}
