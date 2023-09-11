package Grupo11.calculoDeRanking.calculoDeRanking;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.*;
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
    public calculoDeRanking(){
        SessionFactory factory = null;
        Session session = factory.openSession();

        Transaction tx = null;

        try {
        tx = session.beginTransaction();
        session.createQuery("SELECT Incidente FROM Incidentes ORDER BY COUNT(Entidad) GROUP BY Entidad");
        tx.commit();
        } finally{}

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
