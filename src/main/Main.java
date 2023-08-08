package main;
import java.io.IOException;
import java.util.List;
import LectorCSV.LectorCSV;

public class Main {
    public static void main(String[] args) throws IOException {
        /*Validador validador = new Validador();

        if (validador.validate_password("Ad31dasgn2")) {
            System.out.print("Contraseña valida!");
        } else {
            System.out.print("Contraseña invalida!");
         */

        LectorCSV reader = new LectorCSV();

        List<List<String>> listaCsv1 = reader.leerCsv1();
        List<List<String>> listaCsv2 = reader.leerCsv1();
        List<List<String>> listaCsv3 = reader.leerCsv1();

     }
}

