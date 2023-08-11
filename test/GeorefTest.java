import Georef.ServicioGeoref;
import Georef.entities.ListadoDeMunicipios;
import Georef.entities.ListadoDeProvincias;
import Georef.entities.Municipio;
import Georef.entities.Provincia;
import org.junit.Test;

import java.io.IOException;

public class GeorefTest {

    @Test
    public void listadoDeProvinciasTest() throws IOException {

        ServicioGeoref api = new ServicioGeoref();

        ListadoDeProvincias provincias = api.listadoDeProvincias();

        System.out.println("\nEstas son las provincias de Argentina");

        for (Provincia provincia:provincias.provincias
             ) {

            System.out.println(provincia.nombre);
        }


    }

    @Test
    public void listadoDeMunicipiosDeProvinciaTest() throws IOException {

        ServicioGeoref api = new ServicioGeoref();

        ListadoDeProvincias provincias = api.listadoDeProvincias();
        int indexProvincia = 5;
        System.out.println("\n Estos son los municipios de: " + provincias.provincias.get(indexProvincia).nombre);

        ListadoDeMunicipios municipiosDeProvincia = api.listadoDeMunicipiosDeProvincia(provincias.provincias.get(indexProvincia));

        for (Municipio municipio: municipiosDeProvincia.municipios
        ) {

            System.out.println(municipio.nombre);
        }


    }

}
