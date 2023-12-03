package Grupo11.DDS_TP_Integrador.GestoresNotificaciones;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Notificadores.*;
import Grupo11.DDS_TP_Integrador.Repositories.NotificacionRepository;
import jakarta.persistence.*;
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
    public void notificarEnHorario(){

    }
//    public void sugerirMiembroCercaActualizarIncidente(Persona personaMiembroCerca,List<Incidente> incidentesCerca){
//        for (Incidente incidente: incidentesCerca
//             ) {
//            notificadorComunidad.notificarPersonas((List<Persona>) personaMiembroCerca, new Notificacion(incidente, SUGERENCIA));
//        }

//    }

//    public List<Notificacion> obtenerNotificacionesPendientesPersona(Persona persona){
//
//        //return notificacionRepository.findAllByPersonaIdPersona(persona.getIdPersona()); depende qué traemos de bbdd
//        return persona.getListaNotificaciones();
//    }


}

