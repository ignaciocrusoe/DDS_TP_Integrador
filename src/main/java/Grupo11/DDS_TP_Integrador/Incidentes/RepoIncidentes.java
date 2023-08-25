package Grupo11.DDS_TP_Integrador.Incidentes;

import java.util.List;
import java.util.function.Predicate;


//todo faltaría poder actualizar los incidentes, tienen que ser distintos metodos dependiendo que se quiere actualizar
public class RepoIncidentes {
    private List<Incidente> listaIncidentes;

    public List<Incidente> getListaIncidentes() {
        return listaIncidentes;
    }
    public void addIncidente(Incidente incidente){
        listaIncidentes.add(incidente);
    }

    public void cerrarIncidente(Incidente incidente){
        var index = listaIncidentes.indexOf(incidente);
        listaIncidentes.get(index).cerrarIncidente();
    }

    public List<Incidente> getIncidenteSegunEstado(Boolean estado){
        Predicate<Incidente> mismoEstado = (i) -> i.getEstado() == estado;
        return listaIncidentes.stream().filter(mismoEstado).toList();
    }

    public long promedioIncidentes(){

        long sumatoria=0;
        for (Incidente incidente:listaIncidentes) {
            sumatoria+=incidente.duracion();

        }
        return (sumatoria/(listaIncidentes.size()));
    }

    public int cantidadIncidentes() {
        return listaIncidentes.size();
    }
}
