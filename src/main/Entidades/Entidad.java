package main.Entidades;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Collections;
import package.Rankings.InformeSemanal;
import package.Rankings.GestorRankings;
import package.Establecimientos.Establecimiento;
import package.Incidentes.Incidente;
import package.Intereses.Interes;
import package.GestoresIncidentes.GestorIncidentes;
import package.Notificadores.Notificador;


public class Entidad extends Interes{
    //List<Incidente> incidentes;

    //public int promedioIncidentes(){
        return incidentes.map(x -> x.duracion()).average().orElse(0.0);
    }
    //public int cantidadDeIncidentes(){
        return incidentes.size();
    }
}

public class Organizacion extends Entidad{

}
public class Linea extends Entidad{

}
public class Prestador{

}
public class OrganismoControl{

}