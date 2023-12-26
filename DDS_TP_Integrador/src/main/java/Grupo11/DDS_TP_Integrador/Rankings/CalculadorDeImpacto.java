package Grupo11.DDS_TP_Integrador.Rankings;

import Grupo11.DDS_TP_Integrador.Entidades.Entidad;
import Grupo11.DDS_TP_Integrador.Incidentes.Incidente;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CalculadorDeImpacto {

    public int calcularImpacto(Integer cnf, Entidad entidad){
        int impacto = 0;
        int sumatoriaTiempoResolucion = 0;
        Integer incidentesNoResueltos = entidad.getIncidentesReportados().stream().filter(obj -> !obj.getEstado()).collect(Collectors.toList()).size();
        for(Incidente incidente : entidad.getIncidentesReportados()){
            sumatoriaTiempoResolucion += incidente.duracion();
        }
        impacto = sumatoriaTiempoResolucion + incidentesNoResueltos * cnf;
        return impacto;
    }
}
