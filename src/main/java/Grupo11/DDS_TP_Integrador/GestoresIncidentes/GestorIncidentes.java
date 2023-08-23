package Grupo11.DDS_TP_Integrador.GestoresIncidentes;
import Grupo11.DDS_TP_Integrador.Entidades.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Incidentes.Incidente;

import java.util.List;

public class GestorIncidentes {
    public void reportarIncidenteParaAfectados(Incidente incidente, List<Comunidad> comunidades){
        for (Comunidad comunidad : comunidades) {
            comunidad.getRepoIncidentes().addIncidente(incidente);
            incidente.getEntidad().getRepoIncidentes().addIncidente(incidente);
        }
    }
}

