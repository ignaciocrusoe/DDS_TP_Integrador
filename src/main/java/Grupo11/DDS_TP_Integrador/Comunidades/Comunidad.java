package Grupo11.DDS_TP_Integrador.Comunidades;
import Grupo11.DDS_TP_Integrador.GestoresNotificaciones.*;
import Grupo11.DDS_TP_Integrador.Incidentes.RepoIncidentes;
import Grupo11.DDS_TP_Integrador.Intereses.*;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import Grupo11.DDS_TP_Integrador.Notificadores.*;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import static Grupo11.DDS_TP_Integrador.GestoresNotificaciones.TipoNotificacion.NUEVO_INCIDENTE;
import static Grupo11.DDS_TP_Integrador.GestoresNotificaciones.TipoNotificacion.SUGERENCIA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;




//todo : estos métodos me parece que deben ir en Incidente directamente:
// +actualizarIncidenteReportado(Incidente) SI
// +cerrarIncidenteReportado(Incidente) SI
//todo: se pueden agregar intereses o se intancia la comunidad con una lista fija? ni idea
@Entity(name = "comunidades")
public class Comunidad{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_comunidad")
    private Long id_comunidad;
    @OneToMany(mappedBy = "comunidad_miembro", cascade= CascadeType.ALL)
    @Column(name="miembro")
    private List<Miembro> miembros;
    @ManyToMany
    @JoinTable(name = "comunidad x persona",
            joinColumns = @JoinColumn(name = "id_interes"),
            inverseJoinColumns = @JoinColumn(name = "id_comunidad"))
    private List<Interes> intereses_comunidad;

    @Transient
    private RepoIncidentes repoIncidentes;
    @Autowired
    @Transient
    private NotificadorComunidad notificadorComunidad;
    @Autowired
    @Transient
    private GestorCercania gestorCercania;

    public Comunidad(Double radioCercaniaIncidentes){
        this.miembros = new LinkedList<Miembro>();
        this.intereses_comunidad = new LinkedList<Interes>();
        this.repoIncidentes = new RepoIncidentes();
        this.notificadorComunidad = new NotificadorComunidad();
        this.gestorCercania = new GestorCercania(this, radioCercaniaIncidentes);
    }
    public RepoIncidentes getRepoIncidentes() {
        return repoIncidentes;
    }
    private void notificarNuevoIncidenteAcomunidad_miembro(Incidente nuevoIncidente){
        //notificadorComunidad.setNotificacion(new Notificacion(nuevoIncidente, NUEVO_INCIDENTE));
        notificadorComunidad.notificarPersonas( this.getPersonasMiembras(), new Notificacion(nuevoIncidente, NUEVO_INCIDENTE));
    }
    public void sugerirActualizarIncidente(List<Miembro> comunidad_miembroCerca,Incidente nuevoIncidente){

        // genera una lista de sus gestores de notificaciones para mandarsela al gestor de la comunidad
        List<Persona> personas_cerca = comunidad_miembroCerca.stream().map(miembro -> miembro.getpersona_miembro()).toList();

        //notificadorComunidad.setNotificacion(new Notificacion(nuevoIncidente, SUGERENCIA));

        notificadorComunidad.notificarPersonas( this.getPersonasMiembras(), new Notificacion(nuevoIncidente, SUGERENCIA));

    }

    public List<Persona> getPersonasMiembras(){
        return miembros.stream().map(miembro -> miembro.getpersona_miembro()).toList();
    }

    public Long getId_comunidad() {
        return id_comunidad;
    }

    public void setId_comunidad(Long id_comunidad) {
        this.id_comunidad = id_comunidad;
    }

    public List<Miembro> getMiembros() {
        return miembros;
    }

    public void setMiembros(List<Miembro> miembros) {
        this.miembros = miembros;
    }

    public List<Interes> getIntereses_comunidad() {
        return intereses_comunidad;
    }

    public void setIntereses_comunidad(List<Interes> intereses_comunidad) {
        this.intereses_comunidad = intereses_comunidad;
    }

    public void setRepoIncidentes(RepoIncidentes repoIncidentes) {
        this.repoIncidentes = repoIncidentes;
    }

    public NotificadorComunidad getNotificadorComunidad() {
        return notificadorComunidad;
    }

    public void setNotificadorComunidad(NotificadorComunidad notificadorComunidad) {
        this.notificadorComunidad = notificadorComunidad;
    }

    public GestorCercania getGestorCercania() {
        return gestorCercania;
    }

    public void setGestorCercania(GestorCercania gestorCercania) {
        this.gestorCercania = gestorCercania;
    }
}
