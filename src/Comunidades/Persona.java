package Comunidades;
import Intereses.Interes;
import Incidentes.Incidente;
import Localizaciones.Localizacion;
import GestoresIncidentes.GestorIncidentesRecargado;
import GestoresNotificaciones.GestorNotificacionesPersona;
public class Persona {
  bool esAfectado;
  private List<Miembro> membresias;
  private List<Interes> intereses;
  string nombre;
  Localizacion ubicacionActual;

  public Persona(bool esAfectado, string nombre, Localizacion ubicacionActual){
    super();
    this.esAfectado = esAfectado;
    this.intereses = new ArrayList<>();
    this.membresias = new ArrayList<>();
    this.nombre = nombre;
    this.ubicacionActual = ubicacionActual;
  }

  public void cambiarRol(bool esAfectado){
    this.esAfectado = esAfectado;
  }
}


