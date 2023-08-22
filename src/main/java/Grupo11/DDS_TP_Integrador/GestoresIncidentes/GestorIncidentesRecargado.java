package Grupo11.DDS_TP_Integrador.GestoresIncidentes;

import Grupo11.DDS_TP_Integrador.Comunidades.Comunidad;
import Grupo11.DDS_TP_Integrador.Incidentes.Incidente;

import java.util.List;

public class GestorIncidentesRecargado extends GestorIncidentes {
    public void cerrarIncidente(Incidente incidente, List<Comunidad> comunidades) {
        for (Comunidad comunidad : comunidades) {
            comunidad.getRepoIncidentes().cerrarIncidente(incidente);
        }
    }
}
