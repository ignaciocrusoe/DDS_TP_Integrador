package Grupo11.DDS_TP_Integrador.Responses;

import Grupo11.DDS_TP_Integrador.Incidentes.Incidente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class EntidadesResponse {
    private Long idEntidad;
    private String nombreEntidad;
    public List<Incidente> incidentes;
    public void agregarIncidentes(List<Incidente> incidentesNuevos){
        for(Incidente incidente : incidentesNuevos){
            incidentes.add(incidente);
        }
    }

    public EntidadesResponse(){
        incidentes = new ArrayList<>();
    }
}
