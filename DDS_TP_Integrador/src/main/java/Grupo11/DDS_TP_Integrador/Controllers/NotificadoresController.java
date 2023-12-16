package Grupo11.DDS_TP_Integrador.Controllers;

import Grupo11.DDS_TP_Integrador.Comunidades.ComunidadService;
import Grupo11.DDS_TP_Integrador.Comunidades.Miembro;
import Grupo11.DDS_TP_Integrador.Comunidades.Persona;
import Grupo11.DDS_TP_Integrador.GestoresNotificaciones.GestorNotificacionesPersona;
import Grupo11.DDS_TP_Integrador.Incidentes.Incidente;
import Grupo11.DDS_TP_Integrador.Incidentes.IncidenteService;
import Grupo11.DDS_TP_Integrador.Notificadores.Notificacion;
import Grupo11.DDS_TP_Integrador.Repositories.PersonaRepository;
import Grupo11.DDS_TP_Integrador.Responses.NotificacionModificarIncidenteResponse;
import Grupo11.DDS_TP_Integrador.Responses.NotificacionNuevoIncidenteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

@Controller
public class NotificadoresController {

    @Autowired
    GestorNotificacionesPersona gestorNotificacionesPersona;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    ComunidadService comunidadService;

    @Autowired
    IncidenteService incidenteService;


    @GetMapping("/notificaciones")
    public String vistaNotificaciones() {
        return "notificaciones";
    }

    @GetMapping("/{idPersona}/incidentesDeInteres")
    public ResponseEntity<List<NotificacionModificarIncidenteResponse>> incidentesDeInteres(@PathVariable() Long idPersona) {
        Persona persona = personaRepository.findByIdPersona(idPersona);
        List<Long> comunidadesMiembro = comunidadService.getComunidadesMiembroId(persona);

        List<NotificacionModificarIncidenteResponse> incidentes = new ArrayList<>();

        for (Long idComunidad : comunidadesMiembro
        ) {
            for (Incidente incidente : incidenteService.getIncidentesByComunidadAfectadaId(idComunidad)

            ) {
                if (incidente.getEstado()) { //incidentes abiertos
                    NotificacionModificarIncidenteResponse noti = new NotificacionModificarIncidenteResponse(
                            incidente.getIdIncidente(),
                            incidente.getApertura(),
                            incidente.getEstado(),
                            incidente.getEstablecimiento().getNombreEstablecimiento(),
                            incidente.getPrestacionIncidentada().getNombrePrestacion(),
                            incidente.getEstablecimiento().getLocalizacion().getLatitudLocalizacion(),
                            incidente.getEstablecimiento().getLocalizacion().getLonguitudLocalizacion(),"Modificar Incidente"
                    );
                    incidentes.add(noti);
                }

            }

        }
        return new ResponseEntity<List<NotificacionModificarIncidenteResponse>>(incidentes, HttpStatus.OK);
    }

    @GetMapping("/{idPersona}/notificaciones")
    public ResponseEntity<List<NotificacionNuevoIncidenteResponse>> notificacionesNuevosIncidentesPersona(@PathVariable() Long idPersona) {
        Persona persona = personaRepository.findByIdPersona(idPersona);

        List<Notificacion> notificacionesPersona = persona.getListaNotificaciones();

        List<NotificacionNuevoIncidenteResponse> notificacionesNuevoIncidenteResponse = new ArrayList<>();

        notificacionesPersona.forEach(notificacion -> {
            notificacionesNuevoIncidenteResponse.add(
                    NotificacionNuevoIncidenteResponse.builder()
                            .nombrePrestacion(notificacion.getIncidente().getPrestacionIncidentada().getNombrePrestacion())
                            .tipo("Nuevo Incidente")
                            .estado(notificacion.getIncidente().getEstado())
                            .idIncidente(notificacion.getIncidente().getIdIncidente())
                            .fechaApertura(notificacion.getIncidente().getApertura())
                            .nombreEstablecimiento(notificacion.getIncidente().getEstablecimiento().getNombreEstablecimiento())
                            .build()
            );
        });

        return new ResponseEntity<List<NotificacionNuevoIncidenteResponse>>(notificacionesNuevoIncidenteResponse, HttpStatus.OK);
    }



    //pruebas json
    @GetMapping("/{idPersona}/idsComunidadesMiembro")
    public ResponseEntity<List<Long>> idsComunidadesMiembro(@PathVariable() Long idPersona) {
        Persona persona = personaRepository.findByIdPersona(idPersona);

        List<Long> comunidadesMiembro = comunidadService.getComunidadesMiembroId(persona);

        return new ResponseEntity<List<Long>>(comunidadesMiembro, HttpStatus.OK);
    }

    @GetMapping("/{idPersona}/datos")
    public ResponseEntity<Persona> datosPersoan(@PathVariable() Long idPersona) {
        Persona persona = personaRepository.findByIdPersona(idPersona);
        return new ResponseEntity<Persona>(persona, HttpStatus.OK);
    }

    @GetMapping("/{idPersona}/membresias")
    public ResponseEntity<List<Miembro>> membresiasPersona(@PathVariable() Long idPersona) {
        Persona persona = personaRepository.findByIdPersona(idPersona);

        List<Miembro> membresias = persona.getMembresias();
        return new ResponseEntity<List<Miembro>>(membresias, HttpStatus.OK);
    }




}
