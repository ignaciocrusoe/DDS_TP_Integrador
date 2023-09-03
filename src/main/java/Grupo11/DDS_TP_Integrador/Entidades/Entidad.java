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
public class Entidad extends Interes {

    @Column(name="nombre_entidad")
    protected String nombre;
    @Autowired
    @Transient
    private RepoIncidentes repoIncidentes;
    @Autowired
    @Transient
    private GestorRankings gestorRankings;
    @OneToMany(mappedBy = "entidad")
    protected List<Incidente> incidentes_reportados;

    @Transient
    protected InformeSemanal informeSemanal;

    public void recibirInforme(){
        this.informeSemanal = gestorRankings.getInformeSemanal();
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

    public InformeSemanal getInformeSemanal() {
        return informeSemanal;
    }

    public void setInformeSemanal(InformeSemanal informeSemanal) {
        this.informeSemanal = informeSemanal;
    }
}
