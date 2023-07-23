package Rankings;

import Comunidades.Comunidad;
import Entidades.Entidad;
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
