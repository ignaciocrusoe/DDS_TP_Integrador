package Grupo11.DDS_TP_Integrador.Comunidades;

import Grupo11.DDS_TP_Integrador.Incidentes.Incidente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comunidad_x_incidente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComunidadXIncidente {

    @EmbeddedId
    private ComunidadXIncidenteId id;

    @ManyToOne
    @MapsId("incidente")
    @JoinColumn(name = "id_incidente")
    private Incidente incidente;

    @ManyToOne
    @MapsId("comunidad")
    @JoinColumn(name = "id_comunidad")
    private Comunidad comunidad;


}