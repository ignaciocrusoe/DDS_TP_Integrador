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
    private IntervaloHorario rangoSeleccionado;


    public CambiarMedioRequest() {
        this.rangosHorariosPersona = new ArrayList<IntervaloHorario>();
    }
}
