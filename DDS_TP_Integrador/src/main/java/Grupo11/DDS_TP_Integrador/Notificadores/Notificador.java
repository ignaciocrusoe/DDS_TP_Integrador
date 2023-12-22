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


        List<Notificacion> notificaciones = new ArrayList<>();
        for (Miembro miembro : comunidad1.getMiembros()
        ) {
            Miembro miembrodb = miembroRepository.findById(miembro.getIdMiembro()).get();
            Persona persona = personaRepository.findByIdPersona(miembrodb.getPersona().getIdPersona());
            notificaciones.add(new Notificacion(persona, nuevoIncidente, tipoNotificacion));

        }

        notificacionRepository.saveAll(notificaciones);

    }
}

