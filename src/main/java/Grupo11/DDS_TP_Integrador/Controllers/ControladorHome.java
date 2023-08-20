package Grupo11.DDS_TP_Integrador.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorHome {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

}