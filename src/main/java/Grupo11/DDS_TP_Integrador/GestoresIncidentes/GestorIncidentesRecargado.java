package Grupo11.DDS_TP_Integrador.GestoresIncidentes;

import Grupo11.DDS_TP_Integrador.Comunidades.Comunidad;
import Grupo11.DDS_TP_Integrador.Incidentes.Incidente;
import Grupo11.DDS_TP_Integrador.Incidentes.RepoIncidentes;

import java.util.List;

public class GestorIncidentesRecargado extends GestorIncidentes {
    public void cerrarIncidente(Incidente incidente, List<Comunidad> comunidades) {
        for (Comunidad comunidad : comunidades) {
            List<Incidente> incidentes = comunidad.getIncidentesReportados();
            RepoIncidentes repoIncidentes = comunidad.getRepoIncidentes();
            repoIncidentes.cerrarIncidente(incidentes, incidente);
        }
    }
}
