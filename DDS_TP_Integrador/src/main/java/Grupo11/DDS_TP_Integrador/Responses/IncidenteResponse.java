package Grupo11.DDS_TP_Integrador.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class IncidenteResponse {
    private Long idIncidente;
    private LocalDateTime apertura;
    private LocalDateTime cierre;
    private Boolean estado; //true abierto, false cerrado
}
