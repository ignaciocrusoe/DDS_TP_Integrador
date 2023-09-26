package CalculoRanking.Rankings;

import CalculoRanking.Incidentes.*;
import jakarta.persistence.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Ranking")
public class Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_ranking")
    private Long id_ranking;
    @ManyToMany
    @JoinTable(
            name = "Incidentes",
            inverseJoinColumns = @JoinColumn(name = "id_incidente")
    )
    private List<Incidente> incidentes;

    public void setIncidentes(List<Incidente> incidentes){
        this.incidentes = incidentes;
    }

    public static int generarRanking(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:h2:mem:tpdatabase;DB_CLOSE_ON_EXIT=FALSE", "ernestina", "sa");
        } catch (SQLException e) {
            e.printStackTrace();
            return 400;
        }
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("GET * FROM ENTIDADES");
            List<Incidente> list = new ArrayList<>();
            Ranking ranking = new Ranking();
            ranking.setIncidentes(list);
            while (rs.next()) {
                Incidente incidente =  new Incidente(1L, "Observación de ejemplo.", null, null, null, null, null);
                incidente.setApertura(rs.getDate("horario_apertura").toLocalDate());
                incidente.setCierre(rs.getDate("horario_cierre").toLocalDate());
                incidente.setEstado(rs.getBoolean("estado"));
                incidente.setId_incidente(rs.getLong("id_incidente"));
                // add more fields as needed
                list.add(incidente);
            }
            ranking.setIncidentes(list);
            insertarRanking(ranking);
        } catch (SQLException e) {
            e.printStackTrace();
            return 401;
        }
        return 200;
    }

    public static void insertarRanking(Ranking ranking) {
        String url = "jdbc:h2:mem:tpdatabase;DB_CLOSE_ON_EXIT=FALSE";
        String user = "ernestina";
        String password = "sa";
        String query = "INSERT INTO Ranking (, field2, field3) VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = con.prepareStatement(query)) {

            // set the values of the query parameters
            stmt.setLong(1, ranking.id_ranking);
            stmt.setArray(3, (Array) ranking.incidentes);

            // execute the SQL query
            int rowsInserted = stmt.executeUpdate();
            System.out.println(rowsInserted + " rows inserted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //metodos utilitarios
 /*
    public Ranking() {
    }

    public Long getId_ranking3() {
        return id_ranking3;
    }

    public void setId_ranking3(Long id_ranking3) {
        this.id_ranking3 = id_ranking3;
    }

    public List<Long> getComunidades() {
        return comunidades;
    }
    public void setComunidades(List<Comunidad> comunidades) {
        this.comunidades = comunidades;
    }
    */
}

