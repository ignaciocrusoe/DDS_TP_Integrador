package Grupo11.DDS_TP_Integrador.Entidades;
import java.util.List;

import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Rankings.*;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import Grupo11.DDS_TP_Integrador.Intereses.*;
import Grupo11.DDS_TP_Integrador.Notificadores.*;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity(name = "entidades")
@PrimaryKeyJoinColumn(name = "id_entidad")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Entidad extends Interes {

    @OneToMany(mappedBy = "entidad")
    protected List<Incidente> incidentes_reportados;
    @ManyToOne
    @JoinColumn(name = "prestador")
    protected Prestador prestador;
    @ManyToOne
    @JoinColumn(name = "organismoControl")
    protected OrganismoControl organismoControl;

    @ManyToMany
    @JoinTable(name = "entidad x persona",
            joinColumns = @JoinColumn(name = "id_entidad"),
            inverseJoinColumns = @JoinColumn(name = "id_persona"))
    protected List<Persona> suscriptores;

    @OneToMany(mappedBy = "entidad")
    protected List<RankingMasIncidentes> rankingMasIncidentes;

    @OneToMany(mappedBy = "entidad")
    protected List<RankingPromedioCierre> rankingPromedioCierre;

    @OneToMany(mappedBy = "entidad")
    protected List<RankingMayorImpacto> rankingMayorImpacto;

    @Autowired
    @Transient
    protected RepoIncidentes repoIncidentes;
    @Autowired
    @Transient
    protected GestorRankings gestorRankings;
    @Autowired
    @Transient
    protected Notificador notificador;





    //metodos utilitarios


    public Entidad() {
    }

    public Entidad(List<Incidente> incidentes_reportados, Prestador prestador, OrganismoControl organismoControl, List<Persona> suscriptores, List<RankingMasIncidentes> rankingMasIncidentes, List<RankingPromedioCierre> rankingPromedioCierre, List<RankingMayorImpacto> rankingMayorImpacto, RepoIncidentes repoIncidentes, GestorRankings gestorRankings, Notificador notificador) {
        this.incidentes_reportados = incidentes_reportados;
        this.prestador = prestador;
        this.organismoControl = organismoControl;
        this.suscriptores = suscriptores;
        this.rankingMasIncidentes = rankingMasIncidentes;
        this.rankingPromedioCierre = rankingPromedioCierre;
        this.rankingMayorImpacto = rankingMayorImpacto;
        this.repoIncidentes = repoIncidentes;
        this.gestorRankings = gestorRankings;
        this.notificador = notificador;
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

    public List<RankingPromedioCierre> getRankingPromedioCierreIncidente() {
        return rankingPromedioCierre;
    }

    public void setRankingPromedioCierreIncidente(List<RankingPromedioCierre> rankingPromedioCierre) {
        this.rankingPromedioCierre = rankingPromedioCierre;
    }

    public List<RankingMayorImpacto> getRankingMayorImpacto() {
        return rankingMayorImpacto;
    }

    public void setRankingMayorImpacto(List<RankingMayorImpacto> rankingMayorImpacto) {
        this.rankingMayorImpacto = rankingMayorImpacto;
    }
}