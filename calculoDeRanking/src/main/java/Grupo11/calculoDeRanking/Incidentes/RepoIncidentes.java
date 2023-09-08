package Grupo11.DDS_TP_Integrador.Incidentes;

import java.util.List;
import java.util.function.Predicate;


//todo faltaría poder actualizar los incidentes, tienen que ser distintos metodos dependiendo que se quiere actualizar
public class RepoIncidentes {

    public void cerrarIncidente(List<Incidente> incidentes, Incidente incidente){
        var index = incidentes.indexOf(incidente);
        incidentes.get(index).cerrarIncidente();
    }

    public List<Incidente> getIncidenteSegunEstado(List<Incidente> incidentes, Boolean estado){
        Predicate<Incidente> mismoEstado = (i) -> i.getEstado() == estado;
        return incidentes.stream().filter(mismoEstado).toList();
    }

    public long promedioIncidentes(List<Incidente> incidentes){

        long sumatoria=0;
        for (Incidente incidente:incidentes) {
            sumatoria+=incidente.duracion();

        }
        return (sumatoria/(incidentes.size()));
    }

    public int cantidadIncidentes(List<Incidente> incidentes) {
        return incidentes.size();
    }
}
