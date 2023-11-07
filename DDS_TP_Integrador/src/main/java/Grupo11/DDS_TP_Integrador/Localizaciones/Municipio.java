package Grupo11.DDS_TP_Integrador.Localizaciones;

import jakarta.persistence.*;

import java.util.List;

@DiscriminatorValue("Municipio")
public class Municipio extends Localizacion{


    public Municipio(Long idLocalizacion, String nombreLocalizacion, Double latitudLocalizacion, Double longuitudLocalizacion) {
        super(idLocalizacion, nombreLocalizacion, latitudLocalizacion, longuitudLocalizacion);
    }
}
