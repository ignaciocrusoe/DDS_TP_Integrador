package Grupo11.DDS_TP_Integrador.Rankings;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Collections;
import Grupo11.DDS_TP_Integrador.Entidades.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;

import Grupo11.DDS_TP_Integrador.Entidades.*;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import org.springframework.beans.factory.annotation.Autowired;

public class GestorRankings {

    @Autowired
    private CalculadorRanking calculadorRanking;

    public void calcularRankings(){
        //obtiene las entidades de la DB
        //calcula los rankings
        //almacena los rankings en la DB
    }

    public void setCalculadorRanking(CalculadorRanking calculadorRanking) {
        this.calculadorRanking = calculadorRanking;
    }
}

