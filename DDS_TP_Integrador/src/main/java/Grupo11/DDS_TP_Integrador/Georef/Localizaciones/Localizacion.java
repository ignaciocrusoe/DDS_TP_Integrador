package Grupo11.DDS_TP_Integrador.Georef.Localizaciones;
import Grupo11.DDS_TP_Integrador.Establecimientos.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Intereses.*;
import jakarta.persistence.*;

@Entity(name = "localizaciones")
@PrimaryKeyJoinColumn(name = "id_localizacion")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Localizacion extends Interes{

    @ManyToOne
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;

    @Column(name = "latitud")
    private Double latitud;
    @Column(name = "longuitud")
    private Double longuitud;


    public Localizacion(Municipio municipio, Double latitud, Double longuitud) {
        this.municipio = municipio;
        this.latitud = latitud;
        this.longuitud = longuitud;
    }

    public Localizacion() {
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLonguitud() {
        return longuitud;
    }

    public void setLonguitud(Double longuitud) {
        this.longuitud = longuitud;
    }
}

