package Grupo11.DDS_TP_Integrador.Comunidades;
import Grupo11.DDS_TP_Integrador.Georef.Localizaciones.Localizacion;
import Grupo11.DDS_TP_Integrador.GestoresNotificaciones.*;
import Grupo11.DDS_TP_Integrador.Intereses.*;
import Grupo11.DDS_TP_Integrador.GestoresIncidentes.*;

import java.util.ArrayList;
import java.util.List;

public class Persona {
  private List<Miembro> membresias;
  private List<Interes> intereses;
  private String nombre;
  private Localizacion ubicacionActual;
  private GestorNotificacionesPersona gestorNotificaciones;
  private GestorIncidentesRecargado gestorIncidentesRecargado;

  public GestorNotificacionesPersona getGestorNotificaciones() {
    return this.gestorNotificaciones;
  }
  public Persona(String nombre, MedioComunicacion medio){
    super();
    this.intereses = new ArrayList<Interes>();
    this.membresias = new ArrayList<Miembro>();
    this.nombre = nombre;
    this.gestorNotificaciones = new GestorNotificacionesPersona(medio);
  }

}


