package main;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
public class LeerDatosCSV {
    private static final String SAMPLE_CSV_FILE_PATH = "src/main/probando.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)

        ) {

            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String nombre_organismo = csvRecord.get(0);
                String mail_organismo = csvRecord.get(1);
                String entidades = csvRecord.get(2);



                System.out.println("Record No - " + csvRecord.getRecordNumber()); //imprime el numero de fila que leyo
                System.out.println("---------------");
                System.out.println("Nombre organismo : " + nombre_organismo);
                System.out.println("mail organismo: " + mail_organismo);
                System.out.println("Entidades: " + entidades);

                System.out.println("---------------\n\n");
            }
        }
    }

}
