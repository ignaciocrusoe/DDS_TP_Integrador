package Grupo11.DDS_TP_Integrador.Controllers;
import Grupo11.DDS_TP_Integrador.Comunidades.Comunidad;
import Grupo11.DDS_TP_Integrador.Comunidades.Miembro;
import Grupo11.DDS_TP_Integrador.Comunidades.Persona;
import Grupo11.DDS_TP_Integrador.GestoresIncidentes.GestorIncidentes;
import Grupo11.DDS_TP_Integrador.GestoresNotificaciones.GestorNotificacionesPersona;
import Grupo11.DDS_TP_Integrador.Incidentes.Incidente;
import Grupo11.DDS_TP_Integrador.Notificadores.Notificacion;
import Grupo11.DDS_TP_Integrador.Repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

@Controller
public class NotificadoresController {

    @Autowired
    GestorNotificacionesPersona gestorNotificacionesPersona;

    @Autowired
    private GestorIncidentes gestorIncidentes;

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("/notificaciones")
    public String vistaNotificaciones(){
        return "notificaciones";
    }

    @GetMapping("/{idPersona}/notificacionesActualizadas/{latitud}/{longitud}")
    public ResponseEntity<List<Notificacion>> notificacionesActualizadasEndpoint(@PathVariable() Long idPersona, @PathVariable() Double latitud, @PathVariable() Double longitud) {
        Persona persona = personaRepository.findByIdPersona(idPersona);

        List<Miembro> membresias = persona.getMembresias();
        List<Comunidad> comunidadesPersona = membresias.stream().map(miembro -> miembro.getComunidad()).collect(Collectors.toList());
        List<Incidente> incidentesPersona = comunidadesPersona.stream().map(comunidad -> gestorIncidentes.getIncidentesAbiertosByComunidad(comunidad)).flatMap(List::stream).collect(Collectors.toList());

        incidentesPersona.stream().filter(incidente -> estaCerca(incidente, latitud, longitud, 1000.0));
        gestorNotificacionesPersona.sugerirMiembroCercaActualizarIncidente(persona, incidentesPersona);

        List<Notificacion> notificacionesActualizadas = gestorNotificacionesPersona.obtenerNotificacionesPendientesPersona(persona);
        return new ResponseEntity<List<Notificacion>>(notificacionesActualizadas, HttpStatus.OK);
    }


            //esto re va en otro lugar pero bueno
    private Boolean estaCerca(Incidente incidente, Double latitud, Double longitud, Double radio) {

        return abs(latitud - incidente.getEstablecimiento().getLocalizacion().getLatitudLocalizacion()) <= radio
                && abs(longitud - incidente.getEstablecimiento().getLocalizacion().getLonguitudLocalizacion()) <= radio;
    }

}
