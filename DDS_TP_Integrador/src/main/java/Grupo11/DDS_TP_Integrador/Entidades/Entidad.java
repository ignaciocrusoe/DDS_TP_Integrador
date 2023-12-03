package Grupo11.DDS_TP_Integrador.Entidades;
import java.util.List;

import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Establecimientos.Establecimiento;
import Grupo11.DDS_TP_Integrador.Rankings.*;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import Grupo11.DDS_TP_Integrador.Notificadores.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity(name = "entidades")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "categoria", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Entidad")
public class Entidad{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_entidad;

    @Column(name = "nombre_entidad")
    private String nombre_entidad;

    @OneToMany(mappedBy = "entidad")
    @JsonIgnore
    protected List<Incidente> incidentes_reportados;
    @ManyToOne
    @JoinColumn(name = "prestador")
    @JsonIgnore
    protected Prestador prestador;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "organismoControl")
    protected OrganismoControl organismoControl;

    @ManyToMany
    @JoinTable(name = "entidad_x_persona",
            joinColumns = @JoinColumn(name = "id_entidad"),
            inverseJoinColumns = @JoinColumn(name = "id_persona"))
    @JsonIgnore
    protected List<Persona> suscriptores;

    @OneToMany(mappedBy = "entidad")
    @JsonIgnore
    protected List<RankingMasIncidentes> rankingMasIncidentes;

    @OneToMany(mappedBy = "entidad")
    @JsonIgnore
    protected List<RankingPromedioCierre> rankingPromedioCierre;

    @OneToMany(mappedBy = "entidad")
    @JsonIgnore
    protected List<RankingMayorImpacto> rankingMayorImpacto;

    @OneToMany(mappedBy = "entidad")
    @JsonIgnore
    protected List<Establecimiento> establecimientos;

//    @Autowired
//    @Transient
//    protected IncidenteProvider incidenteProvider;
//    @Autowired
//    @Transient
//    protected GestorRankings gestorRankings;
//    @Autowired
//    @Transient
//    protected Notificador notificador;

    //metodos utilitarios
    public Entidad() {
    }

    public Entidad(Long id_entidad, String nombre_entidad, List<Incidente> incidentes_reportados, Prestador prestador, OrganismoControl organismoControl, List<Persona> suscriptores, List<RankingMasIncidentes> rankingMasIncidentes, List<RankingPromedioCierre> rankingPromedioCierre, List<RankingMayorImpacto> rankingMayorImpacto, List<Establecimiento> establecimientos) {
        this.id_entidad = id_entidad;
        this.nombre_entidad = nombre_entidad;
        this.incidentes_reportados = incidentes_reportados;
        this.prestador = prestador;
        this.organismoControl = organismoControl;
        this.suscriptores = suscriptores;
        this.rankingMasIncidentes = rankingMasIncidentes;
        this.rankingPromedioCierre = rankingPromedioCierre;
        this.rankingMayorImpacto = rankingMayorImpacto;
        this.establecimientos = establecimientos;
    }
//    public Entidad(List<Incidente> incidentes_reportados, Prestador prestador, OrganismoControl organismoControl, List<Persona> suscriptores, List<RankingMasIncidentes> rankingMasIncidentes, List<RankingPromedioCierre> rankingPromedioCierre, List<RankingMayorImpacto> rankingMayorImpacto, List<Establecimiento> establecimientos, IncidenteProvider incidenteProvider, GestorRankings gestorRankings, Notificador notificador) {
//        this.incidentes_reportados = incidentes_reportados;
//        this.prestador = prestador;
//        this.organismoControl = organismoControl;
//        this.suscriptores = suscriptores;
//        this.rankingMasIncidentes = rankingMasIncidentes;
//        this.rankingPromedioCierre = rankingPromedioCierre;
//        this.rankingMayorImpacto = rankingMayorImpacto;
//        this.establecimientos = establecimientos;
//        this.incidenteProvider = incidenteProvider;
//        this.gestorRankings = gestorRankings;
//        this.notificador = notificador;
//    }

    public Long getId_entidad() {
        return id_entidad;
    }

    public void setId_entidad(Long id_entidad) {
        this.id_entidad = id_entidad;
    }

    public String getNombre_entidad() {
        return nombre_entidad;
    }

    public void setNombre_entidad(String nombre_entidad) {
        this.nombre_entidad = nombre_entidad;
    }

    public List<Incidente> getIncidentes_reportados() {
        return incidentes_reportados;
    }

    public void setIncidentes_reportados(List<Incidente> incidentes_reportados) {
        this.incidentes_reportados = incidentes_reportados;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    public OrganismoControl getOrganismoControl() {
        return organismoControl;
    }

    public void setOrganismoControl(OrganismoControl organismoControl) {
        this.organismoControl = organismoControl;
    }

    public List<Persona> getSuscriptores() {
        return suscriptores;
    }

    public void setSuscriptores(List<Persona> suscriptores) {
        this.suscriptores = suscriptores;
    }

    public List<RankingMasIncidentes> getRankingMasIncidentes() {
        return rankingMasIncidentes;
    }

    public void setRankingMasIncidentes(List<RankingMasIncidentes> rankingMasIncidentes) {
        this.rankingMasIncidentes = rankingMasIncidentes;
    }

    public List<RankingPromedioCierre> getRankingPromedioCierre() {
        return rankingPromedioCierre;
    }

    public void setRankingPromedioCierre(List<RankingPromedioCierre> rankingPromedioCierre) {
        this.rankingPromedioCierre = rankingPromedioCierre;
    }

    public List<RankingMayorImpacto> getRankingMayorImpacto() {
        return rankingMayorImpacto;
    }

    public void setRankingMayorImpacto(List<RankingMayorImpacto> rankingMayorImpacto) {
        this.rankingMayorImpacto = rankingMayorImpacto;
    }

    public List<Establecimiento> getEstablecimientos() {
        return establecimientos;
    }

    public void setEstablecimientos(List<Establecimiento> establecimientos) {
        this.establecimientos = establecimientos;
    }
}