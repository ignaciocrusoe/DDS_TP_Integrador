package Grupo11.DDS_TP_Integrador.Comunidades;
import Grupo11.DDS_TP_Integrador.Entidades.Entidad;
import Grupo11.DDS_TP_Integrador.Localizaciones.Localizacion;
import Grupo11.DDS_TP_Integrador.GestoresNotificaciones.*;
import Grupo11.DDS_TP_Integrador.GestoresIncidentes.*;
import Grupo11.DDS_TP_Integrador.Notificadores.Notificacion;
import Grupo11.DDS_TP_Integrador.Sessions.LoginEvent;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
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
  private List<LocalDateTime> horarios;

  @Column(name="telefono")
  private Integer telefono;

  @Column(name="mail")
  private String mail;

  @OneToOne
  @JoinColumn(name = "medio")
  private MedioComunicacion medioComunicacion;

  @OneToMany(mappedBy = "persona")
  private List<Notificacion> listaNotificaciones;

  @OneToMany(mappedBy = "persona", cascade=CascadeType.ALL)
  @Column(name="miembro")
  private List<Miembro> membresias;

  @ManyToMany(mappedBy = "suscriptores")
  private List<Entidad> entidadesSuscriptas;

  @Autowired
  @Transient
  private GestorNotificacionesPersona gestorNotificaciones;
  @Autowired
  @Transient
  private GestorIncidentesPersona gestorIncidentesPersona;

  @OneToMany(mappedBy = "persona")
  private List<LoginEvent> loginEventList;

  //metodos utilitarios

  public Persona() {
    horarios = new ArrayList<>();
    entidadesSuscriptas = new ArrayList<>();
    listaNotificaciones = new ArrayList<>();
  }

  public Persona(Long id_persona, String nombre, List<LocalDateTime> horarios, Integer telefono, String mail, MedioComunicacion medioComunicacion, List<Notificacion> listaNotificaciones, List<Miembro> membresias, List<Entidad> entidadesSuscriptas, List<LoginEvent> loginEventList) {
    this.id_persona = id_persona;
    this.nombre = nombre;
    this.horarios = horarios;
    this.telefono = telefono;
    this.mail = mail;
    this.medioComunicacion = medioComunicacion;
    this.listaNotificaciones = listaNotificaciones;
    this.membresias = membresias;
    this.entidadesSuscriptas = entidadesSuscriptas;
    this.loginEventList = loginEventList;
  }

  public List<LoginEvent> getLoginEventList() {
    return loginEventList;
  }

  public void setLoginEventList(List<LoginEvent> loginEventList) {
    this.loginEventList = loginEventList;
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

  public List<LocalDateTime> getHorarios() {
    return horarios;
  }

  public void setHorarios(List<LocalDateTime> horarios) {
    this.horarios = horarios;
  }

  public Integer getTelefono() {
    return telefono;
  }

  public void setTelefono(Integer telefono) {
    this.telefono = telefono;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public MedioComunicacion getMedioComunicacion() {
    return medioComunicacion;
  }

  public void setMedioComunicacion(MedioComunicacion medioComunicacion) {
    this.medioComunicacion = medioComunicacion;
  }

  public List<Notificacion> getListaNotificaciones() {
    return listaNotificaciones;
  }

  public void setListaNotificaciones(List<Notificacion> listaNotificaciones) {
    this.listaNotificaciones = listaNotificaciones;
  }

  public List<Miembro> getMembresias() {
    return membresias;
  }

  public void setMembresias(List<Miembro> membresias) {
    this.membresias = membresias;
  }

  public List<Entidad> getEntidadesSuscriptas() {
    return entidadesSuscriptas;
  }

  public void setEntidadesSuscriptas(List<Entidad> entidadesSuscriptas) {
    this.entidadesSuscriptas = entidadesSuscriptas;
  }
}


