package CalculoRanking.Controllers;

import CalculoRanking.Calculo.CalculoRanking;
import CalculoRanking.Entidades.Entidad;
import CalculoRanking.Incidentes.Incidente;
import CalculoRanking.RankingRequest.RankingRequest;
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

import java.util.ArrayList;
import java.util.List;

@RestController
public class CalculoRankingController {

    @Autowired
    CalculoRanking calculoRanking;


    @Operation(summary="Genera un ranking", description="Dada una lista de entidades y un coeficiente entero como body, devuelve la misma ordenada según que entidades tengan mayor impacto en comunidades")
    @GetMapping("/calculoRanking")

    public ResponseEntity<List<Entidad>> calcularRanking(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
        description = "Se pide una lista de entidades y un coeficiente"
            )
        @RequestBody RankingRequest rankingRequest){

        List<Entidad> entidades = rankingRequest.getEntidades();
        int cnf = rankingRequest.getCoeficiente();

        List<Entidad> ranking = calculoRanking.calcularRanking(entidades, cnf);
        return new ResponseEntity<List<Entidad>>(ranking, HttpStatus.OK);
        //List<Entidad> rankingFicticio = new ArrayList<Entidad>();
        //return new ResponseEntity<List<Entidad>>(rankingFicticio, HttpStatus.OK);
    }


//    @GetMapping("/prueba")
//    public Incidente prueba() {
//        return new Incidente(1L, "Observación de ejemplo.", null, null, null, null, null);
//    }
//
//    @GetMapping("/generarRankingDEPRECATED")
//    public List<Entidad> generarRankingDEPRECATED(){
//        return calculoRanking.calcularRanking(1);
//    }
//
//    @GetMapping("/getListaEntidades")
//    public List<Entidad> getListaEntidades() {
//        return calculoRanking.generarListaEntidades();
//    }
//
//    @PostMapping("/calcularRanking")
//    public List<Entidad> calcularEntidad(@RequestBody List<Entidad> entidades){
//        //Da error cuando se invoca al método ordenarEntidades()
//        return calculoRanking.ordenarEntidades(entidades, 1);
//    }
//
//    @PostMapping("/calcularImpacto")
//    public Integer calcularImpactoPost(@RequestBody Entidad entidad){
//        return calculoRanking.calcularImpacto(entidad, 1);
//    }
//
//    @PostMapping("/validarEntidadesPrueba")
//    public Integer validar(@RequestBody List<Entidad> entidades){
//        return 201;
//    }
//
//    @GetMapping("/generarJson")
//    public List<Entidad> generarJson() {
//        List<Entidad> entidades = new ArrayList<>();
//        Entidad entidad = new Entidad();
//        entidades.add(entidad);
//        Incidente incidente = new Incidente(1L, "Observación de ejemplo.", null, null, null, null, null);
//        List<Incidente> incidentes = new ArrayList<>();
//        incidentes.add(incidente);
//        incidentes.add(incidente);
//        entidad.setIncidentes_reportados(incidentes);
//        entidades.add(entidad);
//        return entidades;
//    }
//    @GetMapping("/generarJsonI")
//    public List<Incidente> generarJsonI(){
//        List<Incidente> incidentes = new ArrayList<>();
//        Incidente incidente = new Incidente(1L, "Observación de ejemplo.", null, null, null, null, null);
//        incidentes.add(incidente);
//        return incidentes;
//    }
//
//
//
//    @GetMapping("/pruebaInsertar")
//    public int insertarPrueba(){
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection("jdbc:h2:mem:tpdatabase;DB_CLOSE_ON_EXIT=FALSE", "ernestina", "sa");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return 400;
//        }
//        Statement stmt = null;
//        int rs = 0;
//        try {
//            stmt = conn.createStatement();
//            rs = stmt.executeUpdate("INSERT INTO ENTIDADES (ID, CANTIDAD_INCIDENTES) VALUES (1L, 100)");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return 401;
//        }
//        return 200;
//    }
//
//
//    @GetMapping("/generarRanking")
//    public int generarRankingPost(){
//        return CalculoRanking.generarRanking();
//    }
//
//    @GetMapping("/prueba_entidad")
//    public Entidad buscarEntidad(@RequestParam(id="id_entidad")){
//        return new Entidad(id_entidad,)
//    }
//

}