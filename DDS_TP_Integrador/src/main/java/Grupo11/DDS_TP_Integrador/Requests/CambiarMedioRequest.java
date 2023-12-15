package Grupo11.DDS_TP_Integrador.Requests;

import Grupo11.DDS_TP_Integrador.Comunidades.IntervaloHorario;
import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class CambiarMedioRequest {

    private Long idPersona;
    private List<IntervaloHorario> rangosHorariosPersona;
    private String nombreMedio;

    public CambiarMedioRequest(Long idPersona, List<IntervaloHorario> rangosHorariosPersona, String nombreMedio) {
        this.idPersona = idPersona;
        this.rangosHorariosPersona = rangosHorariosPersona;
        this.nombreMedio = nombreMedio;
    }

    public CambiarMedioRequest() {
        this.rangosHorariosPersona = new ArrayList<IntervaloHorario>();
    }
}
