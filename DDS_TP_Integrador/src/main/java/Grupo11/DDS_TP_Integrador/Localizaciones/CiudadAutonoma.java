package Grupo11.DDS_TP_Integrador.Localizaciones;

import jakarta.persistence.DiscriminatorValue;

@DiscriminatorValue("Ciudad Autónoma")
public class CiudadAutonoma extends Localizacion{


    public CiudadAutonoma(Long idLocalizacion, String nombreLocalizacion, Double latitudLocalizacion, Double longuitudLocalizacion) {
        super(idLocalizacion, nombreLocalizacion, latitudLocalizacion, longuitudLocalizacion);
    }
}
