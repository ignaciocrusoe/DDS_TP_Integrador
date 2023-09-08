package Grupo11.DDS_TP_Integrador.Georef;

import Grupo11.DDS_TP_Integrador.Georef.Localizaciones.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface GeorefService {

    //OJO! LOS TIPOS DE DATO LONG PODRIAN SER INT
    @GET("provincias")
    Call<ListadoDeProvincias> provincias();

    @GET("provincias")
    Call<ListadoDeProvincias> provincias(@Query("campos") String campos);

    @GET("municipios")
    Call<ListadoDeMunicipios> municipios(@Query("provincia") long idProvincia);

    @GET("municipios")
    Call<ListadoDeMunicipios> municipios(@Query("provincia") long idProvincia, @Query("campos") String campos);

    @GET("municipios")
    Call<ListadoDeMunicipios> municipios(@Query("provincia") long idProvincia, @Query("campos") String campos, @Query("max") int max);
}