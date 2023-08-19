package Grupo11.DDS_TP_Integrador.Rankings;

import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Entidades.*;
import java.util.List;

public class InformeSemanal {

    private List<Entidad> entidadesPromedioCierreIncidentes;
    private List<Entidad> entidadesMayorCantidadIncidentes;
    private List<Comunidad> comunidadesMayorImpacto;

    public void agregarListaPromedio(List<Entidad> listaEntidad){
        this.entidadesPromedioCierreIncidentes = listaEntidad;
    }

    public void agregarListaCantidad(List<Entidad> listaEntidad){
        this.entidadesMayorCantidadIncidentes = listaEntidad;
    }
}
