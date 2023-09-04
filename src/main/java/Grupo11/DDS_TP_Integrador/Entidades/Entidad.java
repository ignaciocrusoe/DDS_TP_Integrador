package Grupo11.DDS_TP_Integrador.Entidades;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Collections;

import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Rankings.*;
import Grupo11.DDS_TP_Integrador.Rankings.*;
import Grupo11.DDS_TP_Integrador.Establecimientos.*;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import Grupo11.DDS_TP_Integrador.GestoresIncidentes.*;
import Grupo11.DDS_TP_Integrador.Intereses.*;
import Grupo11.DDS_TP_Integrador.Notificadores.*;
import Grupo11.DDS_TP_Integrador.Servicios.*;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity(name = "entidades")
@PrimaryKeyJoinColumn(name = "id_entidad")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Entidad extends Interes {
    @Transient
    protected RepoIncidentes repoIncidentes;
    @Transient
    protected GestorRankings gestorRankings;
    @OneToMany(mappedBy = "entidad")
    protected List<Incidente> incidentes_reportados;
    @ManyToOne
    @JoinColumn(name = "prestador")
    protected Prestador prestador;
    @ManyToOne
    @JoinColumn(name = "organismoControl")
    protected OrganismoControl organismoControl;
    @ManyToMany(mappedBy = "entidadesPromedioCierreIncidentes")
    private List<InformeSemanal> informesSemanlesPorPromedio;
    @ManyToMany(mappedBy = "entidadesMayorCantidadIncidentes")
    private List<InformeSemanal> informesSemanlesPorMayor;

    @OneToMany(mappedBy = "entidad")
    protected List<InformeSemanal> informesSemanales;

    public void agregarInforme(InformeSemanal informe ){
        informesSemanales.add((informe));
    }


    public Entidad() {
    }

    public Entidad(List<Incidente> incidentes_reportados, Prestador prestador, OrganismoControl organismoControl, List<InformeSemanal> informesSemanales) {
        this.incidentes_reportados = incidentes_reportados;
        this.prestador = prestador;
        this.organismoControl = organismoControl;
        this.informesSemanales = informesSemanales;
    }

    public List<InformeSemanal> getInformesSemanlesPorPromedio() {
        return informesSemanlesPorPromedio;
    }

    public void setInformesSemanlesPorPromedio(List<InformeSemanal> informesSemanlesPorPromedio) {
        this.informesSemanlesPorPromedio = informesSemanlesPorPromedio;
    }

    public List<InformeSemanal> getInformesSemanlesPorMayor() {
        return informesSemanlesPorMayor;
    }

    public void setInformesSemanlesPorMayor(List<InformeSemanal> informesSemanlesPorMayor) {
        this.informesSemanlesPorMayor = informesSemanlesPorMayor;
    }

    public RepoIncidentes getRepoIncidentes() {
        return repoIncidentes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRepoIncidentes(RepoIncidentes repoIncidentes) {
        this.repoIncidentes = repoIncidentes;
    }

    public GestorRankings getGestorRankings() {
        return gestorRankings;
    }

    public void setGestorRankings(GestorRankings gestorRankings) {
        this.gestorRankings = gestorRankings;
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

    public List<InformeSemanal> getInformesSemanales() {
        return informesSemanales;
    }

    public void setInformesSemanales(List<InformeSemanal> informesSemanales) {
        this.informesSemanales = informesSemanales;
    }
}
