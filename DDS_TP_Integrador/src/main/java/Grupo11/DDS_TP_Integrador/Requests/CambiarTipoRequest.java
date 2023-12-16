package Grupo11.DDS_TP_Integrador.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CambiarTipoRequest {
    private Long idMiembro;

    private String tipo;


}
