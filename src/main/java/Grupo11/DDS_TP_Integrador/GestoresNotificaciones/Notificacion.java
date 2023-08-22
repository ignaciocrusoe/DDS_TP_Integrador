package Grupo11.DDS_TP_Integrador.GestoresNotificaciones;

import Grupo11.DDS_TP_Integrador.Incidentes.Incidente;

public class Notificacion {
    private Incidente incidente;
    private TipoNotificacion tipo;

    public Notificacion(Incidente incidente, TipoNotificacion tipo){
        super();
        this.incidente = incidente;
        this.tipo = tipo;
    }

    public Incidente getIncidente() {
        return incidente;
    }
    public TipoNotificacion getTipo() {
        return tipo;
    }
}
