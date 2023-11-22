package Grupo11.DDS_TP_Integrador.Controllers;

import Grupo11.DDS_TP_Integrador.Comunidades.Comunidad;
import Grupo11.DDS_TP_Integrador.Comunidades.Miembro;
import Grupo11.DDS_TP_Integrador.Comunidades.Persona;
import Grupo11.DDS_TP_Integrador.Comunidades.TipoUsuario;
import Grupo11.DDS_TP_Integrador.Entidades.Entidad;
import Grupo11.DDS_TP_Integrador.Establecimientos.Establecimiento;
import Grupo11.DDS_TP_Integrador.GestoresIncidentes.GestorIncidentesPersona;
import Grupo11.DDS_TP_Integrador.GestoresNotificaciones.MedioComunicacion;
import Grupo11.DDS_TP_Integrador.Incidentes.Incidente;
import Grupo11.DDS_TP_Integrador.LectorCSV.LectorCSV;
import Grupo11.DDS_TP_Integrador.Repositories.*;
import Grupo11.DDS_TP_Integrador.Requests.*;
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
    private MiembroRepository miembroRepository;
    @Autowired
    private MedioComunicacionRepository medioComunicacionRepository;
    @Autowired
    private GestorIncidentesPersona gestorIncidentesPersona;

    @Autowired
    private ComunidadRepository comunidadRepository;

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

    @PostMapping("/crear_incidente") // Replace with your actual endpoint
    public String reportIncidente(@ModelAttribute ReportarIncidenteRequest reportarIncidenteRequest) {
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

        return "redirect:/reportar_incidente";
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




    @PostMapping("/cerrar_incidente")
    public String createIncidente(@ModelAttribute CerrarIncidenteRequest cerrarIncidenteRequest) {
        // Handle the data received from the frontend
        Incidente incidente = incidenteRepository.findByIdIncidente(cerrarIncidenteRequest.getIdIncidente());
        String nuevaObservacion = cerrarIncidenteRequest.getDescription();
        System.out.println(nuevaObservacion);

        incidente.setObservaciones(nuevaObservacion);
        incidente.setCierre(LocalDateTime.now());
        incidente.setEstado(false);

        incidenteRepository.save(incidente);

        // Return a response, e.g., a success message
        return "redirect:/buscar_incidente/" + incidente.getIdIncidente();
    }


    @GetMapping("/editar_perfil/{idPersona}")
    public ModelAndView editar_perfil(@PathVariable() Long idPersona) {

        Persona persona = personaRepository.findByIdPersona(idPersona);
        List<MedioComunicacion> mediosComunicaciones = medioComunicacionRepository.findAll();
        List<Miembro> membresias = persona.getMembresias();

        ModelAndView modelAndView = new ModelAndView("editar_perfil");
        modelAndView.addObject("persona", persona);
        modelAndView.addObject("membresias", membresias);
        modelAndView.addObject("mediosComunicaciones", mediosComunicaciones);

        return modelAndView;
    }


    @PostMapping("/abandonar_comunidad")
    public String abandonarComunidad(@ModelAttribute AbandonarComunidadRequest abandonarComunidadRequest) {


        Miembro miembro = miembroRepository.getReferenceById(abandonarComunidadRequest.getIdMiembro());

        miembroRepository.delete(miembro);

        return "redirect:/editar_perfil/" + miembro.getPersona().getIdPersona();
    }

    @PostMapping("/cambiar_tipo")
    public String cambiarTipo(@ModelAttribute CambiarTipoRequest cambiarTipoRequest) {


        Miembro miembro = miembroRepository.getReferenceById(cambiarTipoRequest.getIdMiembro());

        if( cambiarTipoRequest.getTipo().equals("Observador")){
            miembro.setTipoUsuario(TipoUsuario.OBSERVADOR);
        }else if (cambiarTipoRequest.getTipo().equals("Afectado")){
            miembro.setTipoUsuario(TipoUsuario.AFECTADO);
        }else{
            miembro.setTipoUsuario( miembro.getTipoUsuario());
        }

        miembroRepository.save(miembro);

        System.out.println(cambiarTipoRequest.getIdMiembro());
        System.out.println(cambiarTipoRequest.getTipo());

        return "redirect:/editar_perfil/" + miembro.getPersona().getIdPersona();
    }

    @PostMapping("/cambiar_nombre")
    public String cambiarNombre(@ModelAttribute CambiarNombreRequest cambiarNombreRequest) {

        Persona persona = personaRepository.findByIdPersona(cambiarNombreRequest.getIdPersona());
        persona.setNombre(cambiarNombreRequest.getNuevoNombre());
        persona.setApellido(cambiarNombreRequest.getNuevoApellido());
        personaRepository.save(persona);

        return "redirect:/editar_perfil/" + persona.getIdPersona();
    }

    @PostMapping("/cambiar_medio")
    public String cambiarMedio(@ModelAttribute CambiarMedioRequest cambiarMedioRequest) {

        Persona persona = personaRepository.findByIdPersona(cambiarMedioRequest.getIdPersona());
        persona.setHorarios(cambiarMedioRequest.getHorario());

        System.out.println(cambiarMedioRequest.getHorario());

        MedioComunicacion medio = medioComunicacionRepository.findByNombreMedio(cambiarMedioRequest.getNombreMedio());
        persona.setMedioComunicacion(medio);
        personaRepository.save(persona);

        return "redirect:/editar_perfil/" + persona.getIdPersona();

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

