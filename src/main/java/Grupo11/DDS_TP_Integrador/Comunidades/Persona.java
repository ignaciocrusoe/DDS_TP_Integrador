package Grupo11.DDS_TP_Integrador.Comunidades;
import Grupo11.DDS_TP_Integrador.Georef.Localizaciones.Localizacion;
import Grupo11.DDS_TP_Integrador.GestoresNotificaciones.*;
import Grupo11.DDS_TP_Integrador.Incidentes.Incidente;
import Grupo11.DDS_TP_Integrador.Intereses.*;
import Grupo11.DDS_TP_Integrador.GestoresIncidentes.*;
import Grupo11.DDS_TP_Integrador.Notificadores.Notificacion;
import Grupo11.DDS_TP_Integrador.Notificadores.RepoNotificaciones;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name="personas")
public class Persona {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id_persona")
  private Long id_persona;
  @Column(name="nombre_persona")
  private String nombre;

  @Column(name="horarios")
  private List<LocalDate> horarios;
  @Transient
  @Column(name="medio")
  private MedioComunicacion medioComunicacion;

  @Transient //todo hay que ver como almacenar la localizacion
  private Localizacion ubicacionActual;

  @OneToMany(mappedBy = "persona")
  private List<Notificacion> listaNotificaciones;

  @OneToMany(mappedBy = "persona", cascade=CascadeType.ALL)
  @Column(name="miembro")
  private List<Miembro> membresias;
  @ManyToMany
  @JoinTable(name = "interes x persona",
          joinColumns = @JoinColumn(name = "id_interes"),
          inverseJoinColumns = @JoinColumn(name = "id_persona"))
  private List<Interes> intereses_persona;

  @Autowired
  @Transient
  private GestorNotificacionesPersona gestorNotificaciones;
  @Autowired
  @Transient
  private GestorIncidentesRecargado gestorIncidentesRecargado;


  //metodos utilitarios

  public Persona() {
    membresias = new ArrayList<Miembro>();
    intereses_persona = new ArrayList<Interes>();
  }

  public Persona(Long id_persona, String nombre, List<Miembro> membresias, List<Interes> intereses, Localizacion ubicacionActual, GestorNotificacionesPersona gestorNotificaciones, GestorIncidentesRecargado gestorIncidentesRecargado) {
    this.id_persona = id_persona;
    this.nombre = nombre;
    this.membresias = membresias;
    this.intereses_persona = intereses;
    this.ubicacionActual = ubicacionActual;
    this.gestorNotificaciones = gestorNotificaciones;
    this.gestorIncidentesRecargado = gestorIncidentesRecargado;
  }

  public Long getId_persona() {
    return id_persona;
  }

  public void setId_persona(Long id_persona) {
    this.id_persona = id_persona;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public List<LocalDate> getHorarios() {
    return horarios;
  }

  public void setHorarios(List<LocalDate> horarios) {
    this.horarios = horarios;
  }

  public MedioComunicacion getMedioComunicacion() {
    return medioComunicacion;
  }

  public void setMedioComunicacion(MedioComunicacion medioComunicacion) {
    this.medioComunicacion = medioComunicacion;
  }

  public Localizacion getUbicacionActual() {
    return ubicacionActual;
  }

  public void setUbicacionActual(Localizacion ubicacionActual) {
    this.ubicacionActual = ubicacionActual;
  }

  public List<Notificacion> getNotificaciones() {
    return listaNotificaciones;
  }
  public void setNotificaciones(List<Notificacion> notificaciones) {
    this.listaNotificaciones = notificaciones;
  }

  public List<Miembro> getMembresias() {
    return membresias;
  }

  public void setMembresias(List<Miembro> membresias) {
    this.membresias = membresias;
  }

  public List<Interes> getIntereses_persona() {
    return intereses_persona;
  }

  public void setIntereses_persona(List<Interes> intereses_persona) {
    this.intereses_persona = intereses_persona;
  }
}


