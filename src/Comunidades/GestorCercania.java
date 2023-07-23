package Comunidades;
public class GestorCercania {

    Comunidad comunidadGestionada;
    Double radio;

    public GestorCercania(Comunidad comunidadGestionada, Double radioCercania){
        this.radio = radioCercania;
        this.comunidadGestionada = comunidadGestionada;
    }

    public void verificarMiembrosDentroDeRadio(){

        //todo verificarMiembrosDentroDeRadio()
//        deberia generar una lista de miembros cerca de un
//        incidente en particular de la comunidad
//        y por cada miembro (for each), avisarle a la comunidad que
//        notifique con comunidad.sugerirActualizarIncidente()




    }
    public void setRadioCercania(Double radio){
        this.radio = radio;
    }

}
