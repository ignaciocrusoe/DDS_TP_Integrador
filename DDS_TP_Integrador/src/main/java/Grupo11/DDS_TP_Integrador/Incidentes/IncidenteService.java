package Grupo11.DDS_TP_Integrador.Incidentes;


import Grupo11.DDS_TP_Integrador.Comunidades.Comunidad;
import Grupo11.DDS_TP_Integrador.Comunidades.ComunidadService;
import Grupo11.DDS_TP_Integrador.Comunidades.ComunidadXIncidente;
import Grupo11.DDS_TP_Integrador.Repositories.ComunidadRepository;
import Grupo11.DDS_TP_Integrador.Repositories.ComunidadXIncidenteRepository;
import Grupo11.DDS_TP_Integrador.Repositories.IncidenteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncidenteService {

    @Autowired
    IncidenteRepository incidenteRepository;

    @Autowired
    ComunidadService comunidadService;

    @Autowired
    ComunidadXIncidenteRepository comunidadXIncidenteRepository;


    public List<Incidente> getIncidentesByComunidadAfectadaId(Long idComunidad){

        List<Incidente> incidentes = new ArrayList<>();
        for (ComunidadXIncidente cxi: comunidadXIncidenteRepository.findAllByIdComunidad(idComunidad)
             ) {
            incidentes.add(cxi.getIncidente());
        }
        return incidentes;

    }
}
