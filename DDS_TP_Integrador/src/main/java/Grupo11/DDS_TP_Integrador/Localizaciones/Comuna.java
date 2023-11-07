package Grupo11.DDS_TP_Integrador.Localizaciones;

import jakarta.persistence.DiscriminatorValue;

@DiscriminatorValue("Comuna")
public class Comuna extends Localizacion{
    public Comuna(Long idLocalizacion, String nombreLocalizacion, Double latitudLocalizacion, Double longuitudLocalizacion) {
        super(idLocalizacion, nombreLocalizacion, latitudLocalizacion, longuitudLocalizacion);
    }
}
