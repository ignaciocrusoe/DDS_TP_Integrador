package Grupo11.DDS_TP_Integrador.GestoresNotificaciones;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Notificadores.*;
import Grupo11.DDS_TP_Integrador.Repositories.NotificacionRepository;
import Grupo11.DDS_TP_Integrador.Repositories.PersonaRepository;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.transaction.UserTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static Grupo11.DDS_TP_Integrador.Notificadores.TipoNotificacion.SUGERENCIA;

@Service
public class GestorNotificacionesPersona {

    @Autowired
    private Notificador notificadorComunidad;
    @Autowired
    private NotificacionRepository notificacionRepository;

    @Autowired
    private PersonaRepository personaRepository;
    public void notificarEnHorario(){

    }

    //todo este tmb se puede eliminar
//    public void sugerirMiembroCercaActualizarIncidente(Persona personaMiembroCerca,List<Incidente> incidentesCerca){
//        for (Incidente incidente: incidentesCerca
//             ) {
//            notificadorComunidad.notificarPersonas((List<Persona>) personaMiembroCerca, new Notificacion(incidente, SUGERENCIA));
//        }
//
//    }

    @Transactional
    public List<Notificacion> obtenerNotificacionesPendientesPersona(Long idPersona) {
        Persona persona = personaRepository.findByIdPersona(idPersona);

        List<Notificacion> notificaciones = new ArrayList<>(persona.getListaNotificaciones());

        // Eliminar las notificaciones pendientes
        notificacionRepository.deleteAll(notificaciones);

        // Desvincular las notificaciones antes de guardar la persona
        persona.setListaNotificaciones(null);

        // Guardar la entidad persona después de eliminar notificaciones
        personaRepository.save(persona);

        return notificaciones;
    }


}

