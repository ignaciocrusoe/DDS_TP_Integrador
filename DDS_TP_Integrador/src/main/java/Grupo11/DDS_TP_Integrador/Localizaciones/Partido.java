package Grupo11.DDS_TP_Integrador.Localizaciones;

import jakarta.persistence.DiscriminatorValue;

@DiscriminatorValue("Partido")
public class Partido extends Localizacion{


    public Partido(Long idLocalizacion, String nombreLocalizacion, Double latitudLocalizacion, Double longuitudLocalizacion) {
        super(idLocalizacion, nombreLocalizacion, latitudLocalizacion, longuitudLocalizacion);
    }
}
