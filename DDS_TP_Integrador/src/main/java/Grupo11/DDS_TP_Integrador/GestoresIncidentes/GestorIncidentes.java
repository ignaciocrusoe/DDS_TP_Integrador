package Grupo11.DDS_TP_Integrador.GestoresIncidentes;
import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Incidentes.Incidente;
import Grupo11.DDS_TP_Integrador.Incidentes.IncidenteProvider;
import Grupo11.DDS_TP_Integrador.Repositories.ComunidadRepository;
import Grupo11.DDS_TP_Integrador.Repositories.EntidadRepository;
import Grupo11.DDS_TP_Integrador.Repositories.IncidenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestorIncidentes {

    @Autowired
    protected IncidenteProvider incidenteProvider;
    @Autowired
    protected IncidenteRepository incidenteRepository;
    @Autowired
    protected ComunidadRepository comunidadRepository;
    @Autowired
    protected EntidadRepository entidadRepository;

    @Transactional
    public void reportarIncidenteParaAfectados(Incidente incidente, List<Comunidad> comunidades){

        for (Comunidad comunidad : comunidades) {
            incidente.getComunidadesAfectadas().add(comunidad);

            comunidad.getIncidentesReportados().add(incidente);


            comunidadRepository.save(comunidad);
            incidenteRepository.save(incidente);

        }
    }

    public List<Incidente> getIncidentesAbiertosByComunidad(Comunidad  comunidad){

        return incidenteRepository.findByComunidadesAfectadasIsContainingAndEstadoTrue(comunidad);

    }
}

