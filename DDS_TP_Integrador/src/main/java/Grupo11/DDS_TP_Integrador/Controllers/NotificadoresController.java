package Grupo11.DDS_TP_Integrador.Controllers;

import Grupo11.DDS_TP_Integrador.Comunidades.ComunidadService;
import Grupo11.DDS_TP_Integrador.Comunidades.Miembro;
import Grupo11.DDS_TP_Integrador.Comunidades.Persona;
import Grupo11.DDS_TP_Integrador.GestoresIncidentes.GestorIncidentes;
import Grupo11.DDS_TP_Integrador.GestoresNotificaciones.GestorNotificacionesPersona;
import Grupo11.DDS_TP_Integrador.Incidentes.Incidente;
import Grupo11.DDS_TP_Integrador.Incidentes.IncidenteService;
import Grupo11.DDS_TP_Integrador.Repositories.PersonaRepository;
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
    private GestorIncidentes gestorIncidentes;

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
    public ResponseEntity<List<Incidente>> incidentesDeInteres(@PathVariable() Long idPersona) {
        Persona persona = personaRepository.findByIdPersona(idPersona);
        List<Long> comunidadesMiembro = comunidadService.getComunidadesMiembroId(persona);

        List<Incidente> incidentes = new ArrayList<>();

        for (Long idComunidad : comunidadesMiembro
        ) {
            for (Incidente incidente : incidenteService.getIncidentesByComunidadAfectadaId(idComunidad)
            ) {
                if (!incidente.getEstado()) { //incidentes abiertos
                    incidentes.add(incidente);
                }

            }

        }

        return new ResponseEntity<List<Incidente>>(incidentes, HttpStatus.OK);
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


    //no anda hay recursividad
//    @GetMapping("/{idPersona}/comunidades")
//    public ResponseEntity<List<Comunidad>> comunidadesPersona(@PathVariable() Long idPersona) {
//        Persona persona = personaRepository.findByIdPersona(idPersona);
//
//        List<Miembro> membresias = persona.getMembresias();
//        List<Comunidad> comunidadesPersona = membresias.stream().map(miembro -> miembro.getComunidad()).collect(Collectors.toList());
//       return new ResponseEntity<List<Comunidad>>(comunidadesPersona, HttpStatus.OK);
//    }



}
