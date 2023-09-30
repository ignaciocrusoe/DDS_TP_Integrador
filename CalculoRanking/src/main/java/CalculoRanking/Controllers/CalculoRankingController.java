package CalculoRanking.Controllers;

import CalculoRanking.Calculo.CalculoRanking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculoRankingController {

    @Autowired
    CalculoRanking calculoRanking;

    /*
    @GetMapping("/prueba")
    public Incidente prueba() {
        return new Incidente(1L, "Observación de ejemplo.", null, null, null, null, null);
    }

    @GetMapping("/generarRankingDEPRECATED")
    public List<Entidad> generarRankingDEPRECATED(){
        return calculoRanking.calcularRanking(1);
    }

    @GetMapping("/getListaEntidades")
    public List<Entidad> getListaEntidades() {
        return calculoRanking.generarListaEntidades();
    }

    @PostMapping("/calcularRanking")
    public List<Entidad> calcularEntidad(@RequestBody List<Entidad> entidades){
        //Da error cuando se invoca al método ordenarEntidades()
        return calculoRanking.ordenarEntidades(entidades, 1);
    }

    @PostMapping("/calcularImpacto")
    public Integer calcularImpactoPost(@RequestBody Entidad entidad){
        return calculoRanking.calcularImpacto(entidad, 1);
    }

    @PostMapping("/validarEntidadesPrueba")
    public Integer validar(@RequestBody List<Entidad> entidades){
        return 201;
    }

    @GetMapping("/generarJson")
    public List<Entidad> generarJson() {
        List<Entidad> entidades = new ArrayList<>();
        Entidad entidad = new Entidad();
        entidades.add(entidad);
        Incidente incidente = new Incidente(1L, "Observación de ejemplo.", null, null, null, null, null);
        List<Incidente> incidentes = new ArrayList<>();
        incidentes.add(incidente);
        incidentes.add(incidente);
        entidad.setIncidentes_reportados(incidentes);
        entidades.add(entidad);
        return entidades;
    }
    @GetMapping("/generarJsonI")
    public List<Incidente> generarJsonI(){
        List<Incidente> incidentes = new ArrayList<>();
        Incidente incidente = new Incidente(1L, "Observación de ejemplo.", null, null, null, null, null);
        incidentes.add(incidente);
        return incidentes;
    }



    @GetMapping("/pruebaInsertar")
    public int insertarPrueba(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:h2:mem:tpdatabase;DB_CLOSE_ON_EXIT=FALSE", "ernestina", "sa");
        } catch (SQLException e) {
            e.printStackTrace();
            return 400;
        }
        Statement stmt = null;
        int rs = 0;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeUpdate("INSERT INTO ENTIDADES (ID, CANTIDAD_INCIDENTES) VALUES (1L, 100)");
        } catch (SQLException e) {
            e.printStackTrace();
            return 401;
        }
        return 200;
    }


    @GetMapping("/generarRanking")
    public int generarRankingPost(){
        return CalculoRanking.generarRanking();
    }

    @GetMapping("/prueba_entidad")
    public Entidad buscarEntidad(@RequestParam(id="id_entidad")){
        return new Entidad(id_entidad,)
    }

 */
}