package Grupo11.DDS_TP_Integrador.Comunidades;


import Grupo11.DDS_TP_Integrador.Repositories.ComunidadRepository;
import Grupo11.DDS_TP_Integrador.Repositories.MiembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComunidadService {

    @Autowired
    ComunidadRepository comunidadRepository;

    @Autowired
    MiembroRepository miembroRepository;

    public List<Long> getComunidadesMiembroId(Persona persona){

        List<Long> comunidadesMiembro = new ArrayList<>();

        for (Miembro miembro: persona.getMembresias()
             ) {
            comunidadesMiembro.add(miembro.getComunidad().getIdComunidad());
        }

        return comunidadesMiembro;

    }

    public Comunidad getComunidadById(Long idComunidad) {
        return comunidadRepository.getReferenceById(idComunidad);
    }
}
