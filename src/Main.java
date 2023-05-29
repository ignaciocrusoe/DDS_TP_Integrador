import java.io.IOException;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Validador validador = new Validador();
        CargadorDatos cargador = new CargadorDatos();

        /*if (validador.validate_password("Ad31dasgn2!")) {
            System.out.print("Contraseña valida!");
        } else {
            System.out.print("Contraseña invalida!");*/

        cargador.dataLines.add(new String[]{ "prueba", "1234" });
        cargador.givenDataArray_whenConvertToCSV_thenOutputCreated();
    }
}
