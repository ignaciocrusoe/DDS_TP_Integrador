package Grupo11.DDS_TP_Integrador.Responses;

import Grupo11.DDS_TP_Integrador.Comunidades.IntervaloHorario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ConfiguracionNotificacionesResponse {

    private Long idPersona;

    private List<IntervaloHorario> horarios;

    private String mail;

    private IntervaloHorario rangoSeleccionado;

}
