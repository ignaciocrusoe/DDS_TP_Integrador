package Grupo11.DDS_TP_Integrador.Localizaciones;

import Grupo11.DDS_TP_Integrador.Establecimientos.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;
import jakarta.persistence.*;

@Entity(name = "localizaciones")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "categoria", discriminatorType = DiscriminatorType.STRING)
public class Localizacion{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idLocalizacion")
    protected Long idLocalizacion;
    @Column(name = "nombreLocalizacion")
    protected String nombreLocalizacion;

    @Column(name = "latitudLocalizacion")
    protected Double latitudLocalizacion;
    @Column(name = "longuitudLocalizacion")
    protected Double longuitudLocalizacion;

    public Localizacion(Long idLocalizacion, String nombreLocalizacion, Double latitudLocalizacion, Double longuitudLocalizacion) {
        this.idLocalizacion = idLocalizacion;
        this.nombreLocalizacion = nombreLocalizacion;
        this.latitudLocalizacion = latitudLocalizacion;
        this.longuitudLocalizacion = longuitudLocalizacion;
    }

    public Localizacion() {
    }

    public Long getIdLocalizacion() {
        return idLocalizacion;
    }

    public void setIdLocalizacion(Long idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public String getNombreLocalizacion() {
        return nombreLocalizacion;
    }

    public void setNombreLocalizacion(String nombreLocalizacion) {
        this.nombreLocalizacion = nombreLocalizacion;
    }

    public Double getLatitudLocalizacion() {
        return latitudLocalizacion;
    }

    public void setLatitudLocalizacion(Double latitudLocalizacion) {
        this.latitudLocalizacion = latitudLocalizacion;
    }

    public Double getLonguitudLocalizacion() {
        return longuitudLocalizacion;
    }

    public void setLonguitudLocalizacion(Double longuitudLocalizacion) {
        this.longuitudLocalizacion = longuitudLocalizacion;
    }
}

