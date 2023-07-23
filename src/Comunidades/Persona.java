package Comunidades;
import Intereses.Interes;
import Incidentes.Incidente;
import Localizaciones.Localizacion;
import GestoresIncidentes.GestorIncidentesRecargado;
import GestoresNotificaciones.GestorNotificacionesPersona;

import java.util.ArrayList;
import java.util.List;

public class Persona {
  Boolean esAfectado;
  private List<Miembro> membresias;
  private List<Interes> intereses;
  String nombre;
  Localizacion ubicacionActual;

  GestorNotificacionesPersona gestorNotificaciones;

  public Persona(Boolean esAfectado, String nombre, Localizacion ubicacionActual){
    super();
    this.esAfectado = esAfectado;
    this.intereses = new ArrayList<>();
    this.membresias = new ArrayList<>();
    this.nombre = nombre;
    this.ubicacionActual = ubicacionActual;
    this.gestorNotificaciones = new GestorNotificacionesPersona();
  }

    public Persona() {

    }

  public void cambiarRol(Boolean esAfectado){
    this.esAfectado = esAfectado;
  }

  public boolean estaDentroDeRadio(Double radio) {

    //todo estaDentroDeRadio(radio)

    return true;
  }

  public GestorNotificacionesPersona getGestorNotificaciones() {
    return this.gestorNotificaciones;
  }
}


