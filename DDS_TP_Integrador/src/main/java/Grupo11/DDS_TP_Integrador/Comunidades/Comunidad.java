package Grupo11.DDS_TP_Integrador.Comunidades;
import Grupo11.DDS_TP_Integrador.Incidentes.IncidenteProvider;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import Grupo11.DDS_TP_Integrador.Notificadores.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import static Grupo11.DDS_TP_Integrador.Notificadores.TipoNotificacion.NUEVO_INCIDENTE;
import static Grupo11.DDS_TP_Integrador.Notificadores.TipoNotificacion.SUGERENCIA;

import java.util.List;

@Entity(name = "comunidades")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comunidad{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_comunidad")
    private Long idComunidad;

    @Column(name="nombre_comunidad")
    private String nombre;

    @Column(name="descripcion_comunidad")
    private String descripcionComunidad;

    @ManyToMany
    @JoinTable(name = "comunidad_x_incidente",
            joinColumns = @JoinColumn(name = "id_comunidad"),
            inverseJoinColumns = @JoinColumn(name = "id_incidente"))
    private List<Incidente> incidentesReportados;


    @OneToMany(mappedBy = "comunidad", cascade= CascadeType.ALL)
    private List<Miembro> miembros;


//    @Autowired
//    @Transient
//    private IncidenteProvider incidenteProvider;
//    @Autowired
//    @Transient
//    private Notificador notificadorComunidad;




}
