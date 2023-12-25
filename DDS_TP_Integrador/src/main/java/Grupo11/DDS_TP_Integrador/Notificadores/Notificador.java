package Grupo11.DDS_TP_Integrador.Notificadores;

import Grupo11.DDS_TP_Integrador.GestoresNotificaciones.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Incidentes.Incidente;
import Grupo11.DDS_TP_Integrador.Repositories.ComunidadRepository;
import Grupo11.DDS_TP_Integrador.Repositories.MiembroRepository;
import Grupo11.DDS_TP_Integrador.Repositories.NotificacionRepository;
import Grupo11.DDS_TP_Integrador.Repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class Notificador {
    @Autowired
    private MiembroRepository miembroRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private NotificacionRepository notificacionRepository;
    @Autowired
    private ComunidadRepository comunidadRepository;


    public void notificarPersonas(Comunidad comunidad, Incidente nuevoIncidente, TipoNotificacion tipoNotificacion) {

        Comunidad comunidad1 = comunidadRepository.getReferenceById(comunidad.getIdComunidad());

        Set<Long> miembrodb_ids = comunidad.getMiembros().stream().map(Miembro::getIdMiembro).collect(Collectors.toSet());


        List<Notificacion> notificaciones = new ArrayList<>();
        for (Long miembroId : miembrodb_ids
        ) {

            Persona persona = personaRepository.findByIdPersona(miembroId);
         if(persona!=null){
             notificaciones.add(new Notificacion(persona, nuevoIncidente, tipoNotificacion));
         }
        }

        notificacionRepository.saveAll(notificaciones);

    }
}

