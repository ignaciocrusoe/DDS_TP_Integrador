package main;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;


//esto es una prueba no mas
//VER COMO USAR APACHE COMMONS CSV PARA ACTUALIZAR UN CSV Y NO TENER QUE ESCRIBIRLO DE CERO
public static void leerCSV(String archivoCSV) throws IOException {
    // Abre el archivo CSV para lectura
    Reader reader = new FileReader(archivoCSV);
    CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

    // Itera sobre los registros del CSV
    for (CSVRecord csvRecord : csvParser) {
        // Accede a los valores de cada columna del registro actual
        String columna1 = csvRecord.get(0);
        String columna2 = csvRecord.get(1);
        // ... Accede a más columnas según sea necesario

        // Realiza las operaciones necesarias con los valores de las columnas
        // Por ejemplo, puedes imprimirlos en la consola
        System.out.println("Columna 1: " + columna1);
        System.out.println("Columna 2: " + columna2);
        // ... Realiza operaciones adicionales con los valores
    }

    // Cierra el recurso
    csvParser.close();
    reader.close();
}

try {
    leerCSV("archivo.csv");
} catch (IOException e) {
    e.printStackTrace();
}

/*Asegúrate de reemplazar "archivo.csv" con la ruta y el nombre de tu archivo CSV.

Este código abrirá el archivo CSV especificado, leerá los registros y te permitirá acceder a
 los valores de cada columna del registro utilizando el método get() de la clase CSVRecord.
  Puedes realizar las operaciones que necesites con los valores de las columnas dentro del bucle for.*/