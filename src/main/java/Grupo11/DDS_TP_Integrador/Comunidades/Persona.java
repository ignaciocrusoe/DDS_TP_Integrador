package Grupo11.DDS_TP_Integrador.Comunidades;
import Grupo11.DDS_TP_Integrador.Georef.Localizaciones.Localizacion;
import Grupo11.DDS_TP_Integrador.GestoresNotificaciones.*;
import Grupo11.DDS_TP_Integrador.Intereses.*;
import Grupo11.DDS_TP_Integrador.GestoresIncidentes.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="personas")
public class Persona {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id_persona")
  private Long idPersona;
  private String nombre;

  @OneToMany(mappedBy = "personaMiembro", cascade=CascadeType.ALL)
  private List<Miembro> membresias;

  @ManyToMany
  @JoinColumn(name="id_persona")
  private List<Interes> intereses;

  @Transient
  private Localizacion ubicacionActual;
  @Transient
  private GestorNotificacionesPersona gestorNotificaciones;
  @Transient
  private GestorIncidentesRecargado gestorIncidentesRecargado;

  public Persona() {
    membresias = new ArrayList<Miembro>();
    intereses = new ArrayList<Interes>();
  }

  public Persona(Long idPersona, String nombre, List<Miembro> membresias, List<Interes> intereses, Localizacion ubicacionActual, GestorNotificacionesPersona gestorNotificaciones, GestorIncidentesRecargado gestorIncidentesRecargado) {
    this.idPersona = idPersona;
    this.nombre = nombre;
    this.membresias = membresias;
    this.intereses = intereses;
    this.ubicacionActual = ubicacionActual;
    this.gestorNotificaciones = gestorNotificaciones;
    this.gestorIncidentesRecargado = gestorIncidentesRecargado;
  }

  public Long getIdPersona() {
    return idPersona;
  }

  public void setIdPersona(Long idPersona) {
    this.idPersona = idPersona;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public List<Miembro> getMembresias() {
    return membresias;
  }

  public void setMembresias(List<Miembro> membresias) {
    this.membresias = membresias;
  }

  public List<Interes> getIntereses() {
    return intereses;
  }

  public void setIntereses(List<Interes> intereses) {
    this.intereses = intereses;
  }

  public Localizacion getUbicacionActual() {
    return ubicacionActual;
  }

  public void setUbicacionActual(Localizacion ubicacionActual) {
    this.ubicacionActual = ubicacionActual;
  }

  public GestorNotificacionesPersona getGestorNotificaciones() {
    return gestorNotificaciones;
  }

  public void setGestorNotificaciones(GestorNotificacionesPersona gestorNotificaciones) {
    this.gestorNotificaciones = gestorNotificaciones;
  }

  public GestorIncidentesRecargado getGestorIncidentesRecargado() {
    return gestorIncidentesRecargado;
  }

  public void setGestorIncidentesRecargado(GestorIncidentesRecargado gestorIncidentesRecargado) {
    this.gestorIncidentesRecargado = gestorIncidentesRecargado;
  }
}


