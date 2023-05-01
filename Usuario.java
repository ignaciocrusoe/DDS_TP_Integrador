import java.time.LocalDate;
import validator.PasswordValidator;

public class User {
    private String username;
    private String email;
    private String password;
    private String lastPasswordChangeDate;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        //Valido la nueva contraseña
        List<String> errors = PasswordValidator.validatePassword(this.username, this.password, this.lastPasswordChangeDate);

        //Analizo si hay errores en la validación
        if (errors.isEmpty()) {
            for (String str : list) {
                System.out.println(str);
            }
        } else {
            this.password = password;
            this.lastPasswordChangeDate = LocalDate.now();
        }
    }
}