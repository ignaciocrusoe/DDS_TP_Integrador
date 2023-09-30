package CalculoRanking.RankingRequest;

import CalculoRanking.Entidades.Entidad;
import java.util.ArrayList;
import java.util.List;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

public class RankingRequest {

    @Parameter(
            description = "Un coeficiente entero",
            required = true,
            schema = @Schema(type = "integer")
    )
    private int coeficiente;

    @Parameter(
            description = "Una lista de entidades en formato JSON",
            required = true,
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Entidad.class))
    )
    private List<Entidad> entidades;

    public int getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(int coeficiente) {
        this.coeficiente = coeficiente;
    }

    public List<Entidad> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<Entidad> entidades) {
        this.entidades = entidades;
    }
}
