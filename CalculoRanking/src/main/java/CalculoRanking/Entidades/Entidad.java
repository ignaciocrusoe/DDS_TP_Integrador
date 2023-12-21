package CalculoRanking.Entidades;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import CalculoRanking.Rankings.*;
import CalculoRanking.Incidentes.*;
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

    @OneToMany(mappedBy = "entidad")
    @JsonIgnore
    protected List<RankingMayorImpacto> rankingMayorImpacto;

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

    public Entidad(Long id_entidad, String nombre_entidad, List<Incidente> incidentes_reportados, List<RankingMayorImpacto> rankingMayorImpacto) {
        this.id_entidad = id_entidad;
        this.nombre_entidad = nombre_entidad;
        this.incidentes_reportados = incidentes_reportados;
        this.rankingMayorImpacto = rankingMayorImpacto;
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

    public List<Incidente> getIncidentes_reportados_abierto_en_semana(LocalDateTime inicioDeSemana, LocalDateTime finDeSemana) {
        return this.getIncidentes_reportados().stream()
                .filter(incidente ->
                        incidente.getEstado() && // Verificar si está abierto
                                incidente.getApertura().isAfter(inicioDeSemana) && // Verificar si es después del inicio de la semana
                                incidente.getApertura().isBefore(finDeSemana) // Verificar si es antes del fin de la semana
                )
                .collect(Collectors.toList());

    }

    public void setIncidentes_reportados(List<Incidente> incidentes_reportados) {
        this.incidentes_reportados = incidentes_reportados;
    }

    public List<RankingMayorImpacto> getRankingMayorImpacto() {
        return rankingMayorImpacto;
    }

    public void setRankingMayorImpacto(List<RankingMayorImpacto> rankingMayorImpacto) {
        this.rankingMayorImpacto = rankingMayorImpacto;
    }

}