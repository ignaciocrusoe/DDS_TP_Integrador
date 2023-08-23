package Grupo11.DDS_TP_Integrador.Entidades;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Collections;

import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Rankings.*;
import Grupo11.DDS_TP_Integrador.Rankings.*;
import Grupo11.DDS_TP_Integrador.Establecimientos.*;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import Grupo11.DDS_TP_Integrador.GestoresIncidentes.*;
import Grupo11.DDS_TP_Integrador.Intereses.*;
import Grupo11.DDS_TP_Integrador.Notificadores.*;
import Grupo11.DDS_TP_Integrador.Servicios.*;


public class Entidad extends Interes {

    protected RepoIncidentes repoIncidentes;
    protected InformeSemanal informeSemanal;
    protected GestorRankings gestorRankings;

    public void recibirInforme(){
        this.informeSemanal = gestorRankings.obtenerInforme();
    }

    public RepoIncidentes getRepoIncidentes() {
        return repoIncidentes;
    }
}
