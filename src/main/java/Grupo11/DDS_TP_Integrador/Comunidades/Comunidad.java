package Grupo11.DDS_TP_Integrador.Comunidades;
import Grupo11.DDS_TP_Integrador.Incidentes.RepoIncidentes;
import Grupo11.DDS_TP_Integrador.Intereses.*;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import Grupo11.DDS_TP_Integrador.Notificadores.*;
import Grupo11.DDS_TP_Integrador.Rankings.RankingMayorImpacto;
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
    private Long id_comunidad;

    @Column(name="nombre_comunidad")
    private String nombre;

    @ManyToMany
    @JoinTable(name = "comunidad x incidente",
            joinColumns = @JoinColumn(name = "id_incidente"),
            inverseJoinColumns = @JoinColumn(name = "id_comunidad"))
    private List<Incidente> incidentesReportados;
    @OneToMany(mappedBy = "comunidad", cascade= CascadeType.ALL)
    @Column(name="miembro")
    private List<Miembro> miembros;
    @ManyToMany
    @JoinTable(name = "comunidad x interes",
            joinColumns = @JoinColumn(name = "id_interes"),
            inverseJoinColumns = @JoinColumn(name = "id_comunidad"))
    private List<Interes> intereses_comunidad;

    @ManyToOne
    @JoinColumn(name = "rankingMayorImpacto")
    private RankingMayorImpacto rankingMayorImpacto;

    @Autowired
    @Transient
    private RepoIncidentes repoIncidentes;
    @Autowired
    @Transient
    private Notificador notificadorComunidad;
    @Autowired
    @Transient
    private GestorCercania gestorCercania;


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

    public Comunidad(Long id_comunidad, String nombre, List<Incidente> incidentesReportados, List<Miembro> miembros, List<Interes> intereses_comunidad, RankingMayorImpacto rankingMayorImpacto) {
        this.id_comunidad = id_comunidad;
        this.nombre = nombre;
        this.incidentesReportados = incidentesReportados;
        this.miembros = miembros;
        this.intereses_comunidad = intereses_comunidad;
        this.rankingMayorImpacto = rankingMayorImpacto;
    }

    public Long getId_comunidad() {
        return id_comunidad;
    }

    public void setId_comunidad(Long id_comunidad) {
        this.id_comunidad = id_comunidad;
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

    public List<Interes> getIntereses_comunidad() {
        return intereses_comunidad;
    }

    public void setIntereses_comunidad(List<Interes> intereses_comunidad) {
        this.intereses_comunidad = intereses_comunidad;
    }

    public RankingMayorImpacto getRankingMayorImpacto() {
        return rankingMayorImpacto;
    }

    public void setRankingMayorImpacto(RankingMayorImpacto rankingMayorImpacto) {
        this.rankingMayorImpacto = rankingMayorImpacto;
    }
}
