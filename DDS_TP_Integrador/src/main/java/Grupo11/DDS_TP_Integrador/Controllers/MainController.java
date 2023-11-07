package Grupo11.DDS_TP_Integrador.Controllers;

import Grupo11.DDS_TP_Integrador.Entidades.Entidad;
import Grupo11.DDS_TP_Integrador.Repositories.EntidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class MainController {

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

        List<Entidad> entidades = entidadRepository.findAll(); // Replace with your actual data retrieval logic
        model.addAttribute("entidades", entidades);
        return "reportar_incidente";
    }

    @GetMapping("/cerrar_incidente")
    public String cerrar_incidente() {
        return "cerrar_incidente";
    }

    @GetMapping("/buscar_incidentes")
    public String buscar_incidentes() {
        return "buscar_incidentes";
    }

}