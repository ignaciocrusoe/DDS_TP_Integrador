package Grupo11.DDS_TP_Integrador.GestoresIncidentes;
import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Incidentes.Incidente;
import Grupo11.DDS_TP_Integrador.Incidentes.IncidenteProvider;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GestorIncidentes {

    @Autowired
    protected IncidenteProvider incidenteProvider;

    public void reportarIncidenteParaAfectados(Incidente incidente, List<Comunidad> comunidades){
        for (Comunidad comunidad : comunidades) {
            comunidad.getIncidentesReportados().add(incidente);
            incidente.getEntidad().getIncidentes_reportados().add(incidente);
        }
    }
}

