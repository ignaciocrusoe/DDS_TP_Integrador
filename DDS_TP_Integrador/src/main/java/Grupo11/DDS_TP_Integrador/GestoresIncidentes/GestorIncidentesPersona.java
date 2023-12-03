package Grupo11.DDS_TP_Integrador.GestoresIncidentes;

import Grupo11.DDS_TP_Integrador.Comunidades.Comunidad;
import Grupo11.DDS_TP_Integrador.Incidentes.Incidente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestorIncidentesPersona extends GestorIncidentes {
    public void cerrarIncidente(Incidente incidente, List<Comunidad> comunidades) {
        for (Comunidad comunidad : comunidades) {
            //todo no deberia obtenerse desde comunidad sino desde un service de incidentes buscando por id comonidad
            //List<Incidente> incidentes = comunidad.getIncidentesReportados();
            //incidenteProvider.cerrarIncidente(incidentes, incidente);
        }
    }
}
