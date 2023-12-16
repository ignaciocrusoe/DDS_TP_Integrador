package Grupo11.DDS_TP_Integrador.Controllers;

import Grupo11.DDS_TP_Integrador.Comunidades.IntervaloHorario;
import Grupo11.DDS_TP_Integrador.Comunidades.Persona;
import Grupo11.DDS_TP_Integrador.Repositories.IntervaloHorarioRepository;
import Grupo11.DDS_TP_Integrador.Repositories.LoginEventRepository;
import Grupo11.DDS_TP_Integrador.Repositories.PersonaRepository;
import Grupo11.DDS_TP_Integrador.Responses.LoginResponse;
import Grupo11.DDS_TP_Integrador.Sessions.LoginEvent;
import Grupo11.DDS_TP_Integrador.Requests.LoginRequest;
import jakarta.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController{

    @Autowired
    private LoginEventRepository loginEventRepository;
    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    IntervaloHorarioRepository intervaloHorarioRepository;


    @PostMapping("/login-session")
    public ResponseEntity<LoginResponse> handleLoginEvent(@RequestBody LoginRequest loginRequest) {
        String userId = loginRequest.getUserId();

        // Buscar el primer LoginEvent con el mismo idUsuario
        LoginEvent loginEventAnterior = loginEventRepository.findFirstByIdUsuarioOrderByIdUsuarioAsc(userId);

        // Inicializar una nueva Persona
        Persona personaNueva = new Persona();

        if (loginEventAnterior != null) {
            // Si se encontró un LoginEvent anterior, obtén su Persona
            personaNueva = loginEventAnterior.getPersona();
        }else{

            //seteo intervalo de notificaciones default
            IntervaloHorario intervaloDefault30segs = intervaloHorarioRepository.getReferenceById(30000L);
             List<IntervaloHorario> intervalosDefault = new ArrayList<>();
            personaNueva.setIntervaloSeleccionado(intervaloDefault30segs);
            intervalosDefault.add(intervaloDefault30segs);
            personaNueva.setHorarios(intervalosDefault);
            personaRepository.save(personaNueva);
        }

        // Crear un nuevo LoginEvent y asignarle la misma Persona
        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setIdUsuario(userId);
        loginEvent.setLoginTime(LocalDateTime.now());
        loginEvent.setPersona(personaNueva);

        // Guardar el LoginEvent en la base de datos
        loginEventRepository.save(loginEvent);

        // Puedes seguir con el resto de tu lógica aquí

        LoginResponse loginResponse = new LoginResponse("IdPersona", personaNueva.getIdPersona());

        return ResponseEntity.ok(loginResponse);

    }


    @PostMapping("/logout-session")
    public ResponseEntity<String> handleLogoutEvent(@RequestBody LoginRequest loginRequest) {
            String userId = loginRequest.getUserId();

            // Find the most recent login event for the user
            LoginEvent loginEvent = loginEventRepository.findFirstByIdUsuarioOrderByLoginTimeDesc(userId);

            if (loginEvent != null) {
            loginEvent.setLogoutTime(LocalDateTime.now());
            loginEventRepository.save(loginEvent);
            }

            // Handle the user logout in your session management mechanism
            // ...

            return ResponseEntity.ok("Logout event processed successfully");
    }

}

