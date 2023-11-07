package Grupo11.DDS_TP_Integrador.Localizaciones;

import jakarta.persistence.*;

@DiscriminatorValue("Departamento")
public class Departamento extends Localizacion{


    public Departamento(Long idLocalizacion, String nombreLocalizacion, Double latitudLocalizacion, Double longuitudLocalizacion) {
        super(idLocalizacion, nombreLocalizacion, latitudLocalizacion, longuitudLocalizacion);
    }
}
