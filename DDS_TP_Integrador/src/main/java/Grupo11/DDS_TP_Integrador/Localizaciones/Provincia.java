package Grupo11.DDS_TP_Integrador.Localizaciones;

import jakarta.persistence.*;

import java.util.List;

@DiscriminatorValue("Provincia")
public class Provincia extends Localizacion{


    public Provincia(Long idLocalizacion, String nombreLocalizacion, Double latitudLocalizacion, Double longuitudLocalizacion) {
        super(idLocalizacion, nombreLocalizacion, latitudLocalizacion, longuitudLocalizacion);
    }
}
