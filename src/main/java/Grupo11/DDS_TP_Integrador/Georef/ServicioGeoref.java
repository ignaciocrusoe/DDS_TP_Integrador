package Grupo11.DDS_TP_Integrador.Georef;

import Grupo11.DDS_TP_Integrador.Georef.Localizaciones.*;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ServicioGeoref implements GeorefService {
    private static ServicioGeoref instancia = null;
    private static int maximaCantidadRegistrosDefault = 200;
    private static final String urlApi = "https://apis.datos.gob.ar/georef/api/";
    private Retrofit retrofit;

    public ServicioGeoref() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlApi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ServicioGeoref instancia(){
        if(instancia== null){
            instancia = new ServicioGeoref();
        }
        return instancia;
    }

    public ListadoDeProvincias listadoDeProvincias() throws IOException {
        GeorefService georefService = this.retrofit.create(GeorefService.class);
        Call<ListadoDeProvincias> requestProvinciasArgentinas = georefService.provincias();
        Response<ListadoDeProvincias> responseProvinciasArgentinas = requestProvinciasArgentinas.execute();
        return responseProvinciasArgentinas.body();
    }

    public ListadoDeMunicipios listadoDeMunicipiosDeProvincia(Provincia provincia) throws IOException {
        GeorefService georefService = this.retrofit.create(GeorefService.class);
        Call<ListadoDeMunicipios> requestListadoDeMunicipios = georefService.municipios(provincia.id, "id, nombre", maximaCantidadRegistrosDefault);
        Response<ListadoDeMunicipios> responseListadoDeMunicipios = requestListadoDeMunicipios.execute();
        return responseListadoDeMunicipios.body();
    }

    @Override
    public Call<ListadoDeProvincias> provincias() {
        return null;
    }

    @Override
    public Call<ListadoDeProvincias> provincias(String campos) {
        return null;
    }

    @Override
    public Call<ListadoDeMunicipios> municipios(int idProvincia) {
        return null;
    }

    @Override
    public Call<ListadoDeMunicipios> municipios(int idProvincia, String campos) {
        return null;
    }

    @Override
    public Call<ListadoDeMunicipios> municipios(int idProvincia, String campos, int max) {
        return null;
    }
}