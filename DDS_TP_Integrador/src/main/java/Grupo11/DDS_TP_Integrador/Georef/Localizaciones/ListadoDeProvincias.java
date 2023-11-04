package Grupo11.DDS_TP_Integrador.Georef.Localizaciones;
import java.util.List;
import java.util.Optional;

public class ListadoDeProvincias {
    public int cantidad;
    public int total;
    public int inicio;
    public Parametro parametros;
    public List<Provincia> provincias;


    //no se para que es esto
    public Optional<Provincia> provinciaDeId(int id){
        return this.provincias.stream()
                .filter(p -> p.getId_provincia() == id)
                .findFirst();
    }

    private class Parametro {
        public List<String> campos;
    }
}