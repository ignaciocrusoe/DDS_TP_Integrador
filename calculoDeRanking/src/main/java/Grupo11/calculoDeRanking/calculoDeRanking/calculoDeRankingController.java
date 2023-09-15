package Grupo11.calculoDeRanking.calculoDeRanking;

import Grupo11.calculoDeRanking.Entidades.Entidad;
import Grupo11.calculoDeRanking.Incidentes.Incidente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
//import Grupo11.calculoDeRanking.Comunidades.*;

import java.util.List;

@RestController
public class calculoDeRankingController {

    @GetMapping("/prueba")
    public Incidente prueba() {
        return new Incidente(1L, "Observación de ejemplo.", null, null, null, null, null);
    }
    
    @GetMapping("/generarRanking")
    public List<Entidad> generarRanking(){
        return calculoDeRanking.calcularRanking();
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
            rs = stmt.executeUpdate("INSERT INTO ENTIDADES (ID, CANTIDAD_INCIDENTES) VALUES (1, 100)");
        } catch (SQLException e) {
            e.printStackTrace();
            return 401;
        }
        return 200;
    }
/*
    @GetMapping("/prueba_entidad")
    public Entidad buscarEntidad(@RequestParam(id="id_entidad")){
        return new Entidad(id_entidad,)
    }

 */
}
