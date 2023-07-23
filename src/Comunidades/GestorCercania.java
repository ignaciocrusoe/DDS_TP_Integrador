package Comunidades;

import Incidentes.Incidente;

import java.util.List;

public class GestorCercania {
    //todo : decidir forma de funcionamiento
    //corre en paralelo y analiza cada cierto tiempo, o bien la comunidad lo manda a hacer el analisis cada cierto tiempo
    Comunidad comunidadGestionada;
    Double radio;

    public GestorCercania(Comunidad comunidadGestionada, Double radioCercania){
        this.radio = radioCercania;
        this.comunidadGestionada = comunidadGestionada;
    }

    public void verificarMiembrosDentroDeRadio(){

        //todo test verificarMiembrosDentroDeRadio()

        // por cada incidente en la lista de inicidentes activos de la comunidad
        for (Incidente incidente:comunidadGestionada.getIncidentesSegun(true)
             ) {

                // Genera una lista con los miembros cerca del incidente

                List<Miembro> miembrosCercaIncidente = (List<Miembro>) comunidadGestionada.getMiembros().stream().filter(miembro -> miembro.estaDentroDeRadio(radio));

                // Le indica a la comunidad que le sugiera actualizar el incidente a esos miembros

                comunidadGestionada.sugerirActualizarIncidente(miembrosCercaIncidente,incidente);


        }


    }
    public void setRadioCercania(Double radio){
        this.radio = radio;
    }

}
