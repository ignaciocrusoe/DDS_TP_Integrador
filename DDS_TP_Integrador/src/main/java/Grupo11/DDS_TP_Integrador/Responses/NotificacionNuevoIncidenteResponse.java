package Grupo11.DDS_TP_Integrador.Responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class NotificacionNuevoIncidenteResponse {

    private Long idIncidente;

    private LocalDateTime fechaApertura;

    private Boolean estado;

    private String nombrePrestacion;


    private String nombreEstablecimiento;

    private Double latitudEstablecimiento;
    private Double longitudEstablecimiento;

    private String tipo = "Estándar";
}
