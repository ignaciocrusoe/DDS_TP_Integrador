package Grupo11.DDS_TP_Integrador.Comunidades;
import Grupo11.DDS_TP_Integrador.GestoresNotificaciones.*;
import Grupo11.DDS_TP_Integrador.Intereses.*;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import Grupo11.DDS_TP_Integrador.Localizaciones.*;
import Grupo11.DDS_TP_Integrador.GestoresIncidentes.*;
import Grupo11.DDS_TP_Integrador.GestoresNotificaciones.*;

import java.util.ArrayList;
import java.util.List;

public class Persona {
  Boolean esAfectado;
  private List<Miembro> membresias;
  private List<Interes> intereses;
  String nombre;
  Localizacion ubicacionActual;

  GestorNotificacionesPersona gestorNotificaciones;

  public Persona(Boolean esAfectado, String nombre, Localizacion ubicacionActual,MedioComunicacion medio){
    super();
    this.esAfectado = esAfectado;
    this.intereses = new ArrayList<>();
    this.membresias = new ArrayList<>();
    this.nombre = nombre;
    this.ubicacionActual = ubicacionActual;
    this.gestorNotificaciones = new GestorNotificacionesPersona(medio);

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


