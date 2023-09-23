package Grupo11.calculoDeRanking.calculoDeRanking;

import Grupo11.calculoDeRanking.Entidades.Entidad;
import Grupo11.calculoDeRanking.Incidentes.Incidente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/*
public class calculoDeRanking {
}
*/
/*
public class calculoDeRanking {
    public static List<Entidad> topFiveEntidades(String[] args) {
        List<Entidad> topFive = new ArrayList<>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Entidad.class);
        criteria.addOrder(Order.desc("cantidad"));
        criteria.setMaxResults(5);
        List<Entidad> entidades = criteria.list();
        for (Entidad entidad : entidades) {
            topFive.add(entidad);
        }
        session.close();
        factory.close();
        return topFive;
    }
}
*/
public class calculoDeRanking {

    static int calcularImpacto(Entidad entidad, int cnf){
        int tResolucion = 0;
        int cNoResueltos = 0;
        if(entidad.getIncidentes_reportados() == null){
            return 0;
        }
        for(Incidente incidente : entidad.getIncidentes_reportados()){
            if(!incidente.getEstado()){
            tResolucion += Duration.between(incidente.getCierre(), incidente.getApertura()).toDays();
            }
            else{
                cNoResueltos++;
            }
        }
    return tResolucion + cNoResueltos * cnf;
}


    public static List<Entidad> ordenarEntidades(List<Entidad> entidades, int cnf) {
        Collections.sort(entidades, new Comparator<Entidad>() {
            @Override
            public int compare(Entidad entidad1, Entidad entidad2) {
                return calculoDeRanking.calcularImpacto(entidad1, cnf) - calculoDeRanking.calcularImpacto(entidad2, cnf);
            }
        });
        Collections.reverse(entidades);
        return entidades;
    }
    /*

        public static List<Entidad> ordenarEntidades(List<Entidad> entidades, int cnf) {
            int n = entidades.size();
            Entidad entidad = null;
            for(int i = 0; i < n; i++) {
                for(int j = 1; j < (n - i); j++) {
                    if(calculoDeRanking.calcularImpacto(entidades.get(j - 1),cnf) < calculoDeRanking.calcularImpacto(entidades.get(j),cnf)) {
                        entidad = entidades.get(j - 1);
                        entidades.set(j - 1, entidades.get(j));
                        entidades.set(j, entidad);
                    }
                }
            }
            return entidades;
        }
      */
    public static List<Entidad> generarListaEntidades(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:h2:mem:tpdatabase;DB_CLOSE_ON_EXIT=FALSEe", "ernestina", "sa");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT ID, NOMBRE, COUNT(ID_INCIDENTE)'CANTIDAD_INCIDENTES' FROM INCIDENTES LEFT JOIN ENTIDADES ON ENTIDAD = ID WHERE ESTADO = true GROUP BY ID");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Entidad> list = new ArrayList<>();
        try {
            while (rs.next()) {
                Entidad obj = new Entidad();
                //obj.setOrganismoControl(rs.getObject("ORGANISMO_CONTROL", Class<OrganismoControl>));
                obj.setCantidadIncidentes(rs.getInt("CANTIDAD_INCIDENTES"));
                obj.setId(rs.getLong("ID"));
                obj.setNombre(rs.getString("NOMBRE"));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return list;
    }


    public static List<Entidad> calcularRanking(int cnf){
        return ordenarEntidades(generarListaEntidades(), cnf);
        /*
        SessionFactory factory = null;
        Session session = factory.openSession();

        Transaction tx = null;

        try {
        tx = session.beginTransaction();
        session.createQuery("SELECT Incidente FROM Incidentes ORDER BY COUNT(Entidad) GROUP BY Entidad");
        tx.commit();
        } finally{}
        */

    }
    /*

        try(Connection conn = DriveManager.getConnection(
            "REEMPLAZAR CON BASE DE DATOS DE MYSQL");
            Statement stmt = conn.createStatement();
            //query =
            //ResultSet rs = stmt.executeQuery("SELECT * FROM Incidentes ORDER BY COUNT(Entidad) DESC GROUP BY ID LEFT JOIN Entidades")
            stm.executeUpdate("INSERT INTO RANKING_MAS_INCIDENTE (Incidente, Entidad) VALUES (SELECT Incidente FROM Incidentes ORDER BY COUNT(Entidad) DESC GROUP BY ID LEFT JOIN Entidades, SELECT Entidad FROM Incidentes ORDER BY COUNT(Entidad) DESC GROUP BY ID LEFT JOIN Entidades)");
                ){}

    }

    */
}
