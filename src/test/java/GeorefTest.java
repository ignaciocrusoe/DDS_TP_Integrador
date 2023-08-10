import Georef.ServicioGeoref;
import org.junit.Test;
import Georef.entities.*;

import java.io.IOException;

public class GeorefTest {

    @Test
    public void listadoDeProvinciasTest() throws IOException {

        ServicioGeoref api = new ServicioGeoref();

        ListadoDeProvincias provincias = api.listadoDeProvincias();

        for (Provincia provincia:provincias.provincias
             ) {

            System.out.println(provincia.nombre);
        }


    }

    @Test
    public void listadoDeMunicipiosDeProvinciaTest() throws IOException {

        ServicioGeoref api = new ServicioGeoref();

        ListadoDeProvincias provincias = api.listadoDeProvincias();

        ListadoDeMunicipios municipiosDeProvincia = api.listadoDeMunicipiosDeProvincia(provincias.provincias.get(1));

        for (Municipio municipio: municipiosDeProvincia.municipios
        ) {

            System.out.println(municipio.nombre);
        }


    }

}
