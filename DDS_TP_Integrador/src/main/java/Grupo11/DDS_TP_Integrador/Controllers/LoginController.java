package Grupo11.DDS_TP_Integrador.Controllers;

import Grupo11.DDS_TP_Integrador.Repositories.LoginEventRepository;
import Grupo11.DDS_TP_Integrador.Sessions.LoginEvent;
import Grupo11.DDS_TP_Integrador.Sessions.LoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Controller
public class LoginController{

    @Autowired
    private LoginEventRepository loginEventRepository;

    @PostMapping("/login-session")
    public ResponseEntity<String> handleLoginEvent(@RequestBody LoginInfo loginInfo) {
            String userId = loginInfo.getUserId();

            // Create a new LoginEvent record for the user's login
            LoginEvent loginEvent = new LoginEvent();
            loginEvent.setIdUsuario(userId);
            loginEvent.setLoginTime(LocalDateTime.now());

            // Save the LoginEvent entity to the database using Hibernate
            loginEventRepository.save(loginEvent);

            // You can also store the login event in a session to track the user's current session status
            // You might need to implement a custom session management mechanism for this
            // ...

            return ResponseEntity.ok("Login event processed successfully");
    }

    @PostMapping("/logout-session")
    public ResponseEntity<String> handleLogoutEvent(@RequestBody LoginInfo loginInfo) {
            String userId = loginInfo.getUserId();

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

