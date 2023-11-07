package Grupo11.DDS_TP_Integrador.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/inicio")
    public String inicio() {
        return "inicio";
    }

    @GetMapping("/reportar_incidente")
    public String reportar_incidente() {
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