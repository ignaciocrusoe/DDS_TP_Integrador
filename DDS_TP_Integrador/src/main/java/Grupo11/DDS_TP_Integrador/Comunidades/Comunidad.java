package Grupo11.DDS_TP_Integrador.Comunidades;
import Grupo11.DDS_TP_Integrador.Incidentes.IncidenteProvider;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import Grupo11.DDS_TP_Integrador.Notificadores.*;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import static Grupo11.DDS_TP_Integrador.Notificadores.TipoNotificacion.NUEVO_INCIDENTE;
import static Grupo11.DDS_TP_Integrador.Notificadores.TipoNotificacion.SUGERENCIA;

import java.util.List;

@Entity(name = "comunidades")
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
            joinColumns = @JoinColumn(name = "id_incidente"),
            inverseJoinColumns = @JoinColumn(name = "id_comunidad"))
    private List<Incidente> incidentesReportados;
    @OneToMany(mappedBy = "comunidad", cascade= CascadeType.ALL)
    @Column(name="miembro")
    private List<Miembro> miembros;


    @Autowired
    @Transient
    private IncidenteProvider incidenteProvider;
    @Autowired
    @Transient
    private Notificador notificadorComunidad;

    private void notificarNuevoIncidenteAcomunidad_miembro(Incidente nuevoIncidente){
        notificadorComunidad.notificarPersonas( this.getPersonasMiembras(), new Notificacion(nuevoIncidente, NUEVO_INCIDENTE));
    }
    public void sugerirActualizarIncidente(List<Miembro> comunidad_miembroCerca,Incidente nuevoIncidente){

        List<Persona> personas_cerca = comunidad_miembroCerca.stream().map(miembro -> miembro.getPersona()).toList();
        notificadorComunidad.notificarPersonas( personas_cerca, new Notificacion(nuevoIncidente, SUGERENCIA));

    }
    public List<Persona> getPersonasMiembras(){
        return miembros.stream().map(miembro -> miembro.getPersona()).toList();
    }












    //metodos utilitarios


    public Comunidad() {
    }

    public Comunidad(Long idComunidad, String nombre, String descripcionComunidad, List<Incidente> incidentesReportados, List<Miembro> miembros, IncidenteProvider incidenteProvider, Notificador notificadorComunidad) {
        this.idComunidad = idComunidad;
        this.nombre = nombre;
        this.descripcionComunidad = descripcionComunidad;
        this.incidentesReportados = incidentesReportados;
        this.miembros = miembros;
        this.incidenteProvider = incidenteProvider;
        this.notificadorComunidad = notificadorComunidad;
    }

    public Long getIdComunidad() {
        return idComunidad;
    }

    public void setIdComunidad(Long idComunidad) {
        this.idComunidad = idComunidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Incidente> getIncidentesReportados() {
        return incidentesReportados;
    }

    public void setIncidentesReportados(List<Incidente> incidentesReportados) {
        this.incidentesReportados = incidentesReportados;
    }

    public List<Miembro> getMiembros() {
        return miembros;
    }

    public void setMiembros(List<Miembro> miembros) {
        this.miembros = miembros;
    }

}
