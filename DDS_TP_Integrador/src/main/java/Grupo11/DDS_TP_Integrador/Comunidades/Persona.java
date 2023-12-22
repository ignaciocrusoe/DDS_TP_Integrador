package Grupo11.DDS_TP_Integrador.Comunidades;
import Grupo11.DDS_TP_Integrador.Entidades.Entidad;
import Grupo11.DDS_TP_Integrador.GestoresNotificaciones.*;
import Grupo11.DDS_TP_Integrador.GestoresIncidentes.*;
import Grupo11.DDS_TP_Integrador.Notificadores.Notificacion;
import Grupo11.DDS_TP_Integrador.Repositories.IntervaloHorarioRepository;
import Grupo11.DDS_TP_Integrador.Sessions.LoginEvent;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name="personas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {



  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id_persona")
  private Long idPersona;
  @Column(name="nombre_persona")
  private String nombre;

  @Column(name="apellido_persona")
  private String apellido;

  @ManyToMany
  @JoinColumn(name="persona_intervalo_notis")
  private List<IntervaloHorario> horarios;

  @ManyToOne
  @JoinColumn(name="persona_seleccion_intervalo_notis")
  private IntervaloHorario intervaloSeleccionado;

  @Column(name="telefono")
  private Integer telefono;

  @Column(name="mail")
  private String mail;

  @ManyToOne
  @JoinColumn(name = "medio")
  private MedioComunicacion medioComunicacion;

  @OneToMany(mappedBy = "persona")
  @JsonManagedReference
  private List<Notificacion> listaNotificaciones;

  @OneToMany(mappedBy = "persona", cascade=CascadeType.ALL)
  @Column(name="miembro")
  @JsonManagedReference
  private List<Miembro> membresias;

    public void setMedioComunicacion(MedioComunicacion medio) {
    }

  @ManyToMany(mappedBy = "suscriptores")
  @JsonManagedReference
  private List<Entidad> entidadesSuscriptas;

  //@Autowired
  @Transient
  private GestorNotificacionesPersona gestorNotificaciones = new GestorNotificacionesPersona();
//  @Autowired
//  private GestorIncidentesPersona gestorIncidentesPersona;

  @OneToMany(mappedBy = "persona")
  private List<LoginEvent> loginEventList;


  //metodos utilitarios


}


