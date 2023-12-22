package Grupo11.DDS_TP_Integrador.Requests;

import lombok.Data;

public class AbandonarComunidadRequest {
    private Long idMiembroAEliminar;

    public Long getIdMiembroAEliminar() {
        return idMiembroAEliminar;
    }

    public void setIdMiembroAEliminar(Long idMiembroAEliminar) {
        this.idMiembroAEliminar = idMiembroAEliminar;
    }
}
