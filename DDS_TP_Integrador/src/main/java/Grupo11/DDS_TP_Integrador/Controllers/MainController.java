package Grupo11.DDS_TP_Integrador.Controllers;

import Grupo11.DDS_TP_Integrador.Comunidades.Comunidad;
import Grupo11.DDS_TP_Integrador.Comunidades.Miembro;
import Grupo11.DDS_TP_Integrador.Comunidades.Persona;
import Grupo11.DDS_TP_Integrador.Entidades.Entidad;
import Grupo11.DDS_TP_Integrador.Establecimientos.Establecimiento;
import Grupo11.DDS_TP_Integrador.GestoresIncidentes.GestorIncidentes;
import Grupo11.DDS_TP_Integrador.GestoresIncidentes.GestorIncidentesPersona;
import Grupo11.DDS_TP_Integrador.GestoresNotificaciones.MedioComunicacion;
import Grupo11.DDS_TP_Integrador.Incidentes.Incidente;
import Grupo11.DDS_TP_Integrador.LectorCSV.LectorCSV;
import Grupo11.DDS_TP_Integrador.Repositories.*;
import Grupo11.DDS_TP_Integrador.Requests.CerrarIncidenteRequest;
import Grupo11.DDS_TP_Integrador.Requests.ReportarIncidenteRequest;
import Grupo11.DDS_TP_Integrador.Servicios.Prestacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.time.LocalDateTime;
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
    private MedioComunicacionRepository medioComunicacionRepository;
    @Autowired
    private GestorIncidentesPersona gestorIncidentesPersona;


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

        gestorIncidentesPersona.reportarIncidenteParaAfectados(nuevoIncidente, comunidades);

        return ResponseEntity.ok("Incident reported successfully!");
    }

    @GetMapping("/buscar_incidente")
    public String buscar_incidente() {
        return "buscar_incidente";
    }

    @GetMapping("/buscar_incidente/{idIncidente}")
    public ModelAndView obtenerInformacion(@PathVariable() Long idIncidente) {
        Incidente incidente = incidenteRepository.findByIdIncidente(idIncidente);
        Establecimiento establecimiento = incidente.getEstablecimiento();
        Entidad entidad = incidente.getEntidad();
        Prestacion prestacion = incidente.getPrestacionIncidentada();

        ModelAndView modelAndView = new ModelAndView("info_incidente");
        modelAndView.addObject("incidente", incidente);
        modelAndView.addObject("establecimiento", establecimiento);
        modelAndView.addObject("entidad", entidad);
        modelAndView.addObject("prestacion", prestacion);

        return modelAndView;
    }




    @PostMapping("/cerrar-incidente")
    public ResponseEntity<String> createIncident(@RequestBody CerrarIncidenteRequest cerrarIncidenteRequest) {
        // Handle the data received from the frontend
        Incidente incidente = incidenteRepository.findByIdIncidente(cerrarIncidenteRequest.getIdIncidente());
        String nuevaObservacion = cerrarIncidenteRequest.getDescription();
        System.out.println(nuevaObservacion);

        incidente.setObservaciones(nuevaObservacion);
        incidente.setCierre(LocalDateTime.now());
        incidente.setEstado(false);

        incidenteRepository.save(incidente);

        // Return a response, e.g., a success message
        return ResponseEntity.ok("Incident created successfully");
    }


    @GetMapping("/editar_perfil/{idPersona}")
    public ModelAndView editar_perfil(@PathVariable() Long idPersona) {

        Persona persona = personaRepository.findByIdPersona(idPersona);
        List<MedioComunicacion> mediosComunicaciones = medioComunicacionRepository.findAll();

        ModelAndView modelAndView = new ModelAndView("editar_perfil");
        modelAndView.addObject("persona", persona);
        modelAndView.addObject("mediosComunicaciones", mediosComunicaciones);

        System.out.println(persona.getNombre());

        return modelAndView;
    }



    @PostMapping("/importar-entidades-prestadoras/csv")
    public ResponseEntity<String> uploadCsvFile(@RequestParam("file") MultipartFile file) throws IOException {
        // Validate file
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }
        if (!file.getContentType().equals("text/csv")) {
            return ResponseEntity.badRequest().body("File is not a CSV");
        }

        // Process file
        LectorCSV.leerCsv1();
        try {
            // Parse CSV data and store in database


            return ResponseEntity.ok("File uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing file");
        }
    }

}

