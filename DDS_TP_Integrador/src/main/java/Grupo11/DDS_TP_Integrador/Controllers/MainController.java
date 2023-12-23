package Grupo11.DDS_TP_Integrador.Controllers;

import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Entidades.Entidad;
import Grupo11.DDS_TP_Integrador.Entidades.OrganismoControl;
import Grupo11.DDS_TP_Integrador.Establecimientos.Establecimiento;
import Grupo11.DDS_TP_Integrador.GestoresIncidentes.GestorIncidentesPersona;
import Grupo11.DDS_TP_Integrador.GestoresNotificaciones.MedioComunicacion;
import Grupo11.DDS_TP_Integrador.Incidentes.Incidente;
import Grupo11.DDS_TP_Integrador.Notificadores.Notificacion;
import Grupo11.DDS_TP_Integrador.Notificadores.Notificador;
import Grupo11.DDS_TP_Integrador.Notificadores.TipoNotificacion;
import Grupo11.DDS_TP_Integrador.Rankings.*;
import Grupo11.DDS_TP_Integrador.Repositories.*;
import Grupo11.DDS_TP_Integrador.Requests.*;
import Grupo11.DDS_TP_Integrador.Servicios.Prestacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
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

    @Autowired
    private IntervaloHorarioRepository  intervaloHorarioRepository;

    @Autowired
    private RankingMayorImpactoRepository rankingMayorImpactoRepository;

    @Autowired
    private RankingMasIncidentesRepository rankingMasIncidentesRepository;

    @Autowired
    private RankingPromedioCierreRepository rankingPromedioCierreRepository;
    
    @Autowired
    private OrganismoControlRepository organismoControlRepository;

    @Autowired
    private PrestadoresRepository prestadoresRepository;

    @Autowired
    private GestorRankings gestorRankings;

    @Autowired
    private Notificador noificador;

    @Autowired
    RankingRepository rankingRepository;

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

    @PostMapping("/crear_incidente")
    public String reportIncidente(@ModelAttribute ReportarIncidenteRequest reportarIncidenteRequest) {
        Establecimiento establecimiento = establecimientoRepository.findByNombreEstablecimiento(reportarIncidenteRequest.getEstablecimiento());
        Prestacion prestacion = prestacionRepository.findByNombrePrestacion(reportarIncidenteRequest.getPrestacion());
        Persona persona = personaRepository.findByIdPersona(reportarIncidenteRequest.getIdPersona());
        Entidad entidad = establecimiento.getEntidad();
        List<Comunidad> comunidades = persona.getMembresias()
                .stream()
                .map(Miembro::getComunidad)
                .toList();

        Incidente nuevoIncidente = new Incidente();
        nuevoIncidente.setEstablecimiento(establecimiento);
        nuevoIncidente.setPersonaQueReporto(persona);
        nuevoIncidente.setObservaciones(reportarIncidenteRequest.getDescripcion());
        nuevoIncidente.setPrestacionIncidentada(prestacion);
        nuevoIncidente.setEntidad(entidad);

        entidad.getIncidentes_reportados().add(nuevoIncidente);

        incidenteRepository.save(nuevoIncidente);
        entidadRepository.save(entidad);

        for (Comunidad comunidad : comunidades) {


            comunidad.getIncidentesReportados().add(nuevoIncidente);

            nuevoIncidente.getComunidadesAfectadas().add(comunidad);
            noificador.notificarPersonas(comunidad,nuevoIncidente,TipoNotificacion.NUEVO_INCIDENTE);

            comunidadRepository.save(comunidad);

        }



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
        membresias.forEach(membresia ->System.out.println(membresia.getIdMiembro()));

        List<IntervaloHorario> rangosDefault = intervaloHorarioRepository.findAll();
        List<IntervaloHorario> rangosActualesPersona = persona.getHorarios();

        CambiarMedioRequest cambiarMedioRequest = new CambiarMedioRequest();
        CambiarNombreRequest cambiarNombreRequest = new CambiarNombreRequest();
        AbandonarComunidadRequest abandonarComunidadRequest = new AbandonarComunidadRequest();
        CambiarTipoRequest cambiarTipoRequest = new CambiarTipoRequest();

        ModelAndView modelAndView = new ModelAndView("editar_perfil");
        modelAndView.addObject("persona", persona);
        modelAndView.addObject("membresias", membresias);
        modelAndView.addObject("mediosComunicaciones", mediosComunicaciones);
        modelAndView.addObject("rangosHorariosDefault", rangosDefault);
        modelAndView.addObject("rangosActualesPersona", rangosActualesPersona);
        modelAndView.addObject("cambiarMedioRequest", cambiarMedioRequest);
        modelAndView.addObject("cambiarNombreRequest", cambiarNombreRequest);
        modelAndView.addObject("cambiarTipoRequest", cambiarTipoRequest);
        modelAndView.addObject("abandonarComunidadRequest", abandonarComunidadRequest);

        return modelAndView;
    }

    @GetMapping("/comunidades/{idPersona}")
    public ModelAndView obtenerVistaComunidadesPersona(@PathVariable() Long idPersona) {

        Persona persona = personaRepository.findByIdPersona(idPersona);

        List<Miembro> membresiasPersona = new ArrayList<>();

        membresiasPersona = persona.getMembresias();

        for(Miembro membresia : membresiasPersona){
            System.out.println(membresia.getIdMiembro());
        }

        AbandonarComunidadRequest abandonarComunidadRequest = new AbandonarComunidadRequest();
        CambiarTipoRequest cambiarTipoRequest = new CambiarTipoRequest();

        List<Comunidad> comunidades = comunidadRepository.findAll();

        UnirseAComunidadRequest unirseAComunidadRequest = new UnirseAComunidadRequest();

        ModelAndView modelAndView = new ModelAndView("mis_comunidades");
        modelAndView.addObject("personaEnCuestion", persona);
        modelAndView.addObject("unirseAComunidadRequest", unirseAComunidadRequest);
        modelAndView.addObject("comunidades",comunidades);
        modelAndView.addObject("membresias", membresiasPersona);
        modelAndView.addObject("abandonarComunidadRequest", abandonarComunidadRequest);
        modelAndView.addObject("cambiarTipoRequest", cambiarTipoRequest);
        return modelAndView;
    }

    @PostMapping("/unirse_a_comunidad")
    public String unirseAComunidad(@ModelAttribute UnirseAComunidadRequest unirseAComunidadRequest) {
        // Handle the data received from the frontend

        System.out.println("La persona que se quiere unir es: " + unirseAComunidadRequest.getIdPersona());
        Persona persona = personaRepository.findByIdPersona(unirseAComunidadRequest.getIdPersona());
        Comunidad comunidad = comunidadRepository.getReferenceById(unirseAComunidadRequest.getIdComunidad());

        //todo poner dentro de un gestor de comunidades + usar algún patron

        List<Long> idPersonasMiembro = comunidad.getMiembros().stream().map(miembro -> miembro.getPersona().getIdPersona()).toList();

        if(!idPersonasMiembro.contains(persona.getIdPersona())){
            Miembro miembro = new Miembro();
            miembro.setComunidad(comunidad);
            miembro.setPersona(persona);
            miembro.setTipoUsuario(TipoUsuario.AFECTADO);
            miembro.setRolEnComunidad(Rol.COMUN);
            miembro.setNombre(comunidad.getDescripcionComunidad());
            miembroRepository.save(miembro);
        }else{

            //todo considerar throw error y manejarlo con un msj en el front
            System.out.println("La persona ya es miembro de dicha comunidad");
        }
        // Return a response, e.g., a success message
        return "redirect:/comunidades/" + persona.getIdPersona().toString();
    }


    @PostMapping("/abandonar_comunidad")
    public String abandonarComunidad(@ModelAttribute AbandonarComunidadRequest abandonarComunidadRequest) {
        System.out.println("membresia a eliminar: " + abandonarComunidadRequest.getIdMiembroAEliminar());

        Miembro miembro = miembroRepository.getReferenceById(abandonarComunidadRequest.getIdMiembroAEliminar());

        miembroRepository.delete(miembro);

        return "redirect:/comunidades/" + miembro.getPersona().getIdPersona();
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

        return "redirect:/comunidades/" + miembro.getPersona().getIdPersona();
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


        System.out.println("request agregar horarios " + cambiarMedioRequest.getRangosHorariosPersona());

        if(cambiarMedioRequest.getNombreMedio() != null){
            MedioComunicacion medio = medioComunicacionRepository.findByNombreMedio(cambiarMedioRequest.getNombreMedio());
            persona.setMedioComunicacion(medio);
        }

        cambiarMedioRequest.getRangosHorariosPersona().forEach(intervaloHorario -> persona.getHorarios().add(intervaloHorario));

        Set<Long> segundosSinRepetir = new HashSet<>();
        persona.getHorarios().forEach(horario -> segundosSinRepetir.add(horario.getSegundos()));

        List<IntervaloHorario> intervalosSinRepetir = new ArrayList<>();

        segundosSinRepetir.forEach(segundos->intervalosSinRepetir.add(new IntervaloHorario(segundos)));

        persona.setHorarios(intervalosSinRepetir);

        persona.setIntervaloSeleccionado(cambiarMedioRequest.getRangoSeleccionado());
        personaRepository.save(persona);

        return "redirect:/editar_perfil/" + persona.getIdPersona();

    }

    @GetMapping("/importar-entidades-prestadoras")
    public String importarentidadesprestadoras() {
        return "importar-entidades-prestadoras";
    }

    @GetMapping("/importar-organismos-de-control")
    public String importarorganismos() {
        return "importar-organismos";
    }

    @PostMapping(value = "/importar-entidades-prestadoras/csv", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> importar_entidades_prestadoras(@RequestBody List<SubirCsvEntidadesRequest> subirCsvEntidadesRequest) {
        System.out.println(subirCsvEntidadesRequest.get(1).getNombre_entidad());
        System.out.println(subirCsvEntidadesRequest.get(1).getOrganismo_de_control());
        System.out.println(subirCsvEntidadesRequest.get(1).getPrestador());
        System.out.println(subirCsvEntidadesRequest.get(1).getCategoria());

        for (SubirCsvEntidadesRequest request : subirCsvEntidadesRequest) {
            Entidad entidad = new Entidad();
            entidad.setNombre_entidad(request.getNombre_entidad());
            entidad.setPrestador(prestadoresRepository.findById(request.getPrestador()).get());
            entidad.setOrganismoControl(organismoControlRepository.findById(request.getOrganismo_de_control()).get());
            entidadRepository.save(entidad);
        }

        return ResponseEntity.ok(Map.of("message", "Objects received successfully"));
    }

    @PostMapping(value = "/importar-organismos-de-control/csv", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> importar_organismos_de_control(@RequestBody List<SubirCsvOrganismosRequest> subirCsvOrganismosRequest) {
        System.out.println(subirCsvOrganismosRequest.get(1).getNombreOrganismoControl());
        System.out.println(subirCsvOrganismosRequest.get(1).getMailOrganismoControl());

        for (SubirCsvOrganismosRequest request : subirCsvOrganismosRequest) {
            OrganismoControl organismo = new OrganismoControl();
            organismo.setNombre(request.getNombreOrganismoControl());
            organismo.setMail(request.getMailOrganismoControl());
            organismoControlRepository.save(organismo);
        }

        return ResponseEntity.ok(Map.of("message", "Objects received successfully"));
    }

    @GetMapping("/rankings")
    public ModelAndView obtenerUltimoRanking() throws ParseException {


        ModelAndView modelAndView = new ModelAndView("rankings");

        List<Ranking> rankings = rankingRepository.findAll();

        //Ordeno por fecha
        Collections.sort(rankings, new Comparator<Ranking>() {
            public int compare(Ranking ranking1, Ranking ranking2) {
                return ranking1.getDate().compareTo(ranking2.getDate());
            }
        });
        Collections.reverse(rankings);

        Ranking rankingPromedioCierre = rankings.stream()
                .filter(obj -> obj.getTipoRanking() == 1)
                .collect(Collectors.toList())
                .get(0);

        Ranking rankingMasIncidentes = rankings.stream()
                .filter(obj -> obj.getTipoRanking() == 2)
                .collect(Collectors.toList())
                .get(0);

        Ranking rankingMayorImpacto = rankings.stream()
                .filter(obj -> obj.getTipoRanking() == 3)
                .collect(Collectors.toList())
                .get(0);

        System.out.println(rankings);


        List<RankingPromedioCierre> rankingsPromedioCierre;
        List<RankingMasIncidentes> rankingsMasIncidentes;
        List<RankingMayorImpacto> rankingsMayorImpacto;

        rankingsPromedioCierre = rankingPromedioCierreRepository.findAll()
        .stream().
                filter(obj -> obj.getRanking().getId() == rankingPromedioCierre.getId())
                .collect(Collectors.toList());
        modelAndView.addObject("rankingsPromedioCierre", rankingsPromedioCierre);

        rankingsMasIncidentes = rankingMasIncidentesRepository.findAll()
        .stream().
                filter(obj -> obj.getRanking() == rankingMasIncidentes)
                .collect(Collectors.toList());
        modelAndView.addObject("rankingsMasIncidentes", rankingsMasIncidentes);

        rankingsMayorImpacto = rankingMayorImpactoRepository.findAll()
        .stream().
                filter(obj -> obj.getRanking() == rankingMayorImpacto)
                .collect(Collectors.toList());
        modelAndView.addObject("rankingsMayorImpacto", rankingsMayorImpacto);

        return modelAndView;
    }


    @GetMapping("/rankings/{fecha}")
    public ModelAndView obtenerRanking( @PathVariable() String fecha) throws ParseException {


        ModelAndView modelAndView = new ModelAndView("rankings");


        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaComoDate = LocalDate.parse(fecha, formato);


        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = fechaComoDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate endOfWeek = fechaComoDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

        List<Ranking> rankings = rankingRepository.findAll()
        .stream().
                filter(obj -> obj.getDate().isAfter(startOfWeek.atStartOfDay()) && obj.getDate().isBefore(endOfWeek.atStartOfDay()))
                .collect(Collectors.toList());

        Ranking rankingPromedioCierre = rankings.stream()
                .filter(obj -> obj.getTipoRanking() == 1)
                .collect(Collectors.toList())
                .get(0);

        Ranking rankingMasIncidentes = rankings.stream()
                .filter(obj -> obj.getTipoRanking() == 2)
                .collect(Collectors.toList())
                .get(0);

        Ranking rankingMayorImpacto = rankings.stream()
                .filter(obj -> obj.getTipoRanking() == 3)
                .collect(Collectors.toList())
                .get(0);



        List<RankingPromedioCierre> rankingsPromedioCierre;
        List<RankingMasIncidentes> rankingsMasIncidentes;
        List<RankingMayorImpacto> rankingsMayorImpacto;

        rankingsPromedioCierre = rankingPromedioCierreRepository.findAll()
        .stream().
                filter(obj -> obj.getRanking().getId_ranking() == rankingPromedioCierre.getId_ranking())
                .collect(Collectors.toList());
        modelAndView.addObject("rankingsPromedioCierre", rankingsPromedioCierre);

        rankingsMasIncidentes = rankingMasIncidentesRepository.findAll()
         .stream().
                filter(obj -> obj.getRanking().getId_ranking() == rankingMasIncidentes.getId_ranking())
                .collect(Collectors.toList());
        modelAndView.addObject("rankingsMasIncidentes", rankingsMasIncidentes);

        rankingsMayorImpacto = rankingMayorImpactoRepository.findAll()
        .stream().
                filter(obj -> obj.getRanking().getId_ranking() == rankingMayorImpacto.getId_ranking())
                .collect(Collectors.toList());
        modelAndView.addObject("rankingsMayorImpacto", rankingsMayorImpacto);

        return modelAndView;
    }

    @GetMapping("/incidentes")
    public ModelAndView obtenerIncidentesDeComunidad() throws ParseException {
        ModelAndView modelAndView = new ModelAndView("buscar-incidentes");
        List<Incidente> incidentes = incidenteRepository.findAll();
        modelAndView.addObject("incidentes", incidentes);
        return modelAndView;
    }

    @PostMapping("/calcular-rankings")
    public ResponseEntity<Map<String, String>> calcularRankings() {
        //String dateTime = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        gestorRankings.calcularRankings();
        return ResponseEntity.ok(Map.of("message", "Objects received successfully"));
    }

}