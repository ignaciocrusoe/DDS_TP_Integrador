package Grupo11.DDS_TP_Integrador.GestoresIncidentes;

import Grupo11.DDS_TP_Integrador.Comunidades.Comunidad;
import Grupo11.DDS_TP_Integrador.Incidentes.Incidente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestorIncidentesPersona extends GestorIncidentes {
    public void cerrarIncidente(Incidente incidente, List<Comunidad> comunidades) {
        for (Comunidad comunidad : comunidades) {
            List<Incidente> incidentes = comunidad.getIncidentesReportados();
            incidenteProvider.cerrarIncidente(incidentes, incidente);
        }
    }
}
