package Grupo11.DDS_TP_Integrador.LectorCSV;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.*;

public class LectorCSV {
    private static final String CSV1_FILE_PATH = "src/main/1.csv";
    private static final String CSV2_FILE_PATH = "src/main/2.csv";
    private static final String CSV3_FILE_PATH = "src/main/3.csv";
    private static final String[] HEADERS1 = {"nombre_organismo","mail_organismo","nombre_entidad"};
    private static final String[] HEADERS2 = {"nombre_prestador","mail_prestador","nombre_entidad","nombre_establecimiento"};
    private static final String[] HEADERS3 = {"nombre_establecimiento","prestacion","localizacion"};
    public List<List<String>> leerCsv1() throws IOException {

        Reader reader = Files.newBufferedReader(Paths.get(CSV1_FILE_PATH));
        List<List<String>> listaCsv = new ArrayList<>();
        List<String> listaInterior = new ArrayList<>();

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setHeader(HEADERS1).setSkipHeaderRecord(true).setDelimiter(";").build();
        CSVParser csvParser = new CSVParser(reader, csvFormat);

            for (CSVRecord csvRecord : csvParser) {

                listaInterior.add(csvRecord.get("nombre_organismo"));
                listaInterior.add(csvRecord.get("mail_organismo"));
                listaInterior.add(csvRecord.get("nombre_entidad"));

                listaCsv.add(listaInterior);
            }
            return listaCsv;
        }

    public List<List<String>> leerCsv2() throws IOException {

        Reader reader = Files.newBufferedReader(Paths.get(CSV2_FILE_PATH));
        List<List<String>> listaCsv = new ArrayList<>();
        List<String> listaInterior = new ArrayList<>();

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setHeader(HEADERS2).setSkipHeaderRecord(true).setDelimiter(";").build();
        CSVParser csvParser = new CSVParser(reader, csvFormat);

        for (CSVRecord csvRecord : csvParser) {
            listaInterior.add(csvRecord.get("nombre_prestador"));
            listaInterior.add(csvRecord.get("mail_prestador"));
            listaInterior.add(csvRecord.get("nombre_entidad"));
            listaInterior.add(csvRecord.get("nombre_establecimiento"));

            listaCsv.add(listaInterior);
        }
        return listaCsv;
    }

    public List<List<String>> leerCsv3() throws IOException { //no anda por algun motivo

        Reader reader = Files.newBufferedReader(Paths.get(CSV3_FILE_PATH));
        List<List<String>> listaCsv = new ArrayList<>();
        List<String> listaInterior = new ArrayList<>();

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setHeader(HEADERS3).setSkipHeaderRecord(true).setDelimiter(";").build();
        CSVParser csvParser = new CSVParser(reader, csvFormat);

        for (CSVRecord csvRecord : csvParser) {
            listaInterior.add(csvRecord.get("nombre_establecimiento"));
            listaInterior.add(csvRecord.get("prestacion"));
            listaInterior.add(csvRecord.get("localizacion"));

            listaCsv.add(listaInterior);
        }
        return listaCsv;
    }


}
