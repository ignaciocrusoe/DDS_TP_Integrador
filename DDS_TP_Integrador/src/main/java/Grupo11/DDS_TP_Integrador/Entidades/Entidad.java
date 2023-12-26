package Grupo11.DDS_TP_Integrador.Entidades;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
    protected List<Incidente> incidentesReportados;
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


    public Entidad() {
    }

    public Entidad(Long id_entidad, String nombre_entidad, List<Incidente> incidentes_reportados, Prestador prestador, OrganismoControl organismoControl, List<Persona> suscriptores, List<RankingMasIncidentes> rankingMasIncidentes, List<RankingPromedioCierre> rankingPromedioCierre, List<RankingMayorImpacto> rankingMayorImpacto, List<Establecimiento> establecimientos) {
        this.id_entidad = id_entidad;
        this.nombre_entidad = nombre_entidad;
        this.incidentesReportados = incidentes_reportados;
        this.prestador = prestador;
        this.organismoControl = organismoControl;
        this.suscriptores = suscriptores;
        this.rankingMasIncidentes = rankingMasIncidentes;
        this.rankingPromedioCierre = rankingPromedioCierre;
        this.rankingMayorImpacto = rankingMayorImpacto;
        this.establecimientos = establecimientos;
    }


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

    public List<Incidente> getIncidentesReportados() {
        return incidentesReportados;
    }

    public List<Incidente> getIncidentes_reportados_abierto_en_semana(LocalDateTime inicioDeSemana, LocalDateTime finDeSemana) {
        return this.getIncidentesReportados().stream()
                .filter(incidente ->
                incidente.getEstado() && // Verificar si está abierto
                        incidente.getApertura().isAfter(inicioDeSemana) && // Verificar si es después del inicio de la semana
                        incidente.getApertura().isBefore(finDeSemana) // Verificar si es antes del fin de la semana
        )
                .collect(Collectors.toList());

    }

    public List<Incidente> getIncidentes_reportados_en_semana(LocalDateTime inicioDeSemana, LocalDateTime finDeSemana) {
        return this.getIncidentesReportados().stream()
                .filter(incidente ->
                                incidente.getApertura().isAfter(inicioDeSemana) && // Verificar si es después del inicio de la semana
                                incidente.getApertura().isBefore(finDeSemana) // Verificar si es antes del fin de la semana
                )
                .collect(Collectors.toList());

    }

    public void setIncidentes_reportados(List<Incidente> incidentes_reportados) {
        this.incidentesReportados = incidentes_reportados;
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

    public int getImpacto(int cnf){
        int impacto = 0;
        int sumatoriaTiempoResolucion = 0;
        int incidentesNoResueltos = getIncidentesReportados().stream().filter(obj -> !obj.getEstado()).collect(Collectors.toList()).size();
        for(Incidente incidente : getIncidentesReportados()){
            sumatoriaTiempoResolucion += incidente.duracion();
        }
        if(getIncidentesReportados().size() == 0)
        {
            return 0;
        }
        impacto = sumatoriaTiempoResolucion + incidentesNoResueltos * cnf;
        return impacto;
    }

    public int getTiempoPromedio(){
        long sumatoria=0;
        for (Incidente incidente: getIncidentesReportados()) {
            sumatoria+=incidente.duracion();

        }
        if(getIncidentesReportados().size() == 0)
        {
            return 1;
        }
        return (int) (sumatoria/getIncidentesReportados().size());
    }
}