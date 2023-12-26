package Grupo11.DDS_TP_Integrador.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class EntidadesResponse {
    private Long idEntidad;
    private String nombreEntidad;
    public List<IncidenteResponse> incidentes;
    public void agregarIncidente(IncidenteResponse incidenteNuevo){
            incidentes.add(incidenteNuevo);
    }

    public EntidadesResponse(){
        incidentes = new ArrayList<>();
    }
}
