
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class PasswordValidator {

    // Lista de las 10,000 peores contraseñas
    private static final ArrayList<String> WORST_PASSWORDS = new ArrayList<>() {{
        // Agregar contraseñas aquí
        add("123456");
        add("password");
        add("123456789");
        add("12345678");
        add("12345");
        add("1234567");
        add("1234567890");
        add("qwerty");
        add("abc123");
        add("111111");
    }};

    // Verificar contraseñas débiles
    private static boolean isWeakPassword(String password) {
        return WORST_PASSWORDS.contains(password.toLowerCase());
    }

    // Validar contraseña
    public static ArrayList<String> validatePassword(String username, String password, LocalDateTime lastChangeDate) {
        ArrayList<String> errors = new ArrayList<>();

        // Verificar si la contraseña es débil
        if (isWeakPassword(password)) {
            errors.add("La contraseña es débil. Por favor, elige una contraseña más segura.");
        }

        // Verificar la longitud de la contraseña
        if (password.length() < 8) {
            errors.add("La contraseña debe tener al menos 8 caracteres.");
        }

        // Verificar la complejidad de la contraseña
        Pattern pattern = Pattern.compile("[a-zA-Z0-9!@#$%^&*()_+\\\\-=\\\\[\\\\]{};':\\"\\\\\\\\|,.<>\\\\/?]+");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            errors.add("La contraseña debe contener al menos una letra, un número y un carácter especial.");
        }

        // Verificar si el usuario ha cambiado la contraseña recientemente
        long daysSinceLastChange = lastChangeDate.until(LocalDateTime.now(), ChronoUnit.DAYS);
        if (daysSinceLastChange < 90) { // Cambio de contraseña requerido cada 90 días
            errors.add("Debes cambiar tu contraseña cada 90 días.");
    }

    return errors;
}
