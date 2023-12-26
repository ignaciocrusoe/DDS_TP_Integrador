package Grupo11.DDS_TP_Integrador.Incidentes;

import Grupo11.DDS_TP_Integrador.Comunidades.Comunidad;
import Grupo11.DDS_TP_Integrador.Repositories.IncidenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class IncidenteProvider {

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
        if(incidentes.size() == 0)
        {
            return 0;
        }
        {
            return (sumatoria/(incidentes.size()));
        }

    }

    public int cantidadIncidentes(List<Incidente> incidentes) {
        return incidentes.size();
    }


}
