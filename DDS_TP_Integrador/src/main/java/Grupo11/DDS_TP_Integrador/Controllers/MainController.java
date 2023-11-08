package Grupo11.DDS_TP_Integrador.Controllers;

import Grupo11.DDS_TP_Integrador.Comunidades.Comunidad;
import Grupo11.DDS_TP_Integrador.Comunidades.Miembro;
import Grupo11.DDS_TP_Integrador.Comunidades.Persona;
import Grupo11.DDS_TP_Integrador.Entidades.Entidad;
import Grupo11.DDS_TP_Integrador.Establecimientos.Establecimiento;
import Grupo11.DDS_TP_Integrador.GestoresIncidentes.GestorIncidentesPersona;
import Grupo11.DDS_TP_Integrador.Incidentes.Incidente;
import Grupo11.DDS_TP_Integrador.Repositories.*;
import Grupo11.DDS_TP_Integrador.Requests.BuscarIncidenteRequest;
import Grupo11.DDS_TP_Integrador.Requests.ReportarIncidenteRequest;
import Grupo11.DDS_TP_Integrador.Servicios.Prestacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;



@Controller
public class MainController {

    @Autowired
    private EstablecimientoRepository establecimientoRepository;
    @Autowired
    private PrestacionRepository prestacionRepository;
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private IncidenteRepository incidenteRepository;
    @Autowired
    private GestorIncidentesPersona gestorIncidentes;

    @Autowired
    private EntidadRepository entidadRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/inicio")
    public String inicio() {
        return "inicio";
    }

    @GetMapping("/reportar_incidente")
    public String reportar_incidente(Model model) {

        List<Establecimiento> establecimientos = establecimientoRepository.findAll(); // Replace with your actual data retrieval logic
        model.addAttribute("establecimientos", establecimientos);

        List<Prestacion> prestaciones = prestacionRepository.findAll(); // Replace with your actual data retrieval logic
        model.addAttribute("prestaciones", prestaciones);

        return "reportar_incidente";
    }

    @PostMapping("/crear-incidente") // Replace with your actual endpoint
    public ResponseEntity<String> reportIncident(@RequestBody ReportarIncidenteRequest reportarIncidenteRequest) {
        Establecimiento establecimiento = establecimientoRepository.findByNombreEstablecimiento(reportarIncidenteRequest.getEstablecimiento());
        Prestacion prestacion = prestacionRepository.findByNombrePrestacion(reportarIncidenteRequest.getPrestacion());
        Persona persona = personaRepository.findByIdPersona(reportarIncidenteRequest.getIdPersona());
        Entidad entidad = establecimiento.getEntidad();
        List<Comunidad> comunidades = persona.getMembresias()
                .stream()
                .map(Miembro::getComunidad)
                .collect(Collectors.toList());

        Incidente nuevoIncidente = new Incidente();
        nuevoIncidente.setEstablecimiento(establecimiento);
        nuevoIncidente.setPersonaQueReporto(persona);
        nuevoIncidente.setObservaciones(reportarIncidenteRequest.getDescripcion());
        nuevoIncidente.setPrestacionIncidentada(prestacion);
        nuevoIncidente.setEntidad(entidad);

        entidad.getIncidentes_reportados().add(nuevoIncidente);

        incidenteRepository.save(nuevoIncidente);
        entidadRepository.save(entidad);

        gestorIncidentes.reportarIncidenteParaAfectados(nuevoIncidente, comunidades);

        //System.out.println("todo bien" + " " + reportarIncidenteRequest.getDescripcion() );

        return ResponseEntity.ok("Incident reported successfully!");
    }

    @GetMapping("/info_incidente")
    public String info_incidente() {
        return "info_incidente";
    }

    @GetMapping("/buscar_incidentes")
    public String buscar_incidentes() {
        return "buscar_incidentes";
    }

    @GetMapping("/buscar-incidente-id")
    public ModelAndView obtenerInformacion(@RequestParam("idIncidente") Long idIncidente) {
        Incidente incidente = incidenteRepository.findByIdIncidente(idIncidente);

        ModelAndView modelAndView = new ModelAndView("info_incidente");

        return modelAndView;
    }

}