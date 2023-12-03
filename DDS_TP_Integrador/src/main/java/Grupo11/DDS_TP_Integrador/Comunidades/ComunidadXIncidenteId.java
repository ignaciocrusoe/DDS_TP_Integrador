package Grupo11.DDS_TP_Integrador.Comunidades;


import Grupo11.DDS_TP_Integrador.Comunidades.Comunidad;
import Grupo11.DDS_TP_Integrador.Incidentes.Incidente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ComunidadXIncidenteId implements Serializable {

    private Long incidente;

    private Long comunidad;
    // Constructores, getters y setters
}
