package Grupo11.DDS_TP_Integrador.Comunidades;
import Grupo11.DDS_TP_Integrador.GestoresNotificaciones.*;
import Grupo11.DDS_TP_Integrador.Incidentes.RepoIncidentes;
import Grupo11.DDS_TP_Integrador.Intereses.*;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import Grupo11.DDS_TP_Integrador.Notificadores.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


//todo : estos métodos me parece que deben ir en Incidente directamente:
// +actualizarIncidenteReportado(Incidente) SI
// +cerrarIncidenteReportado(Incidente) SI
//todo: se pueden agregar intereses o se intancia la comunidad con una lista fija? ni idea

public class Comunidad{
    private List<Miembro> miembros;
    private List<Interes> interesesComunes;
    private RepoIncidentes repoIncidentes;
    private NotificadorComunidad newsletter;
    private GestorCercania gestorCercania;

    public Comunidad(Double radioCercaniaIncidentes){
        this.miembros = new LinkedList<Miembro>();
        this.interesesComunes = new LinkedList<Interes>();
        this.repoIncidentes = new RepoIncidentes();
        this.newsletter = new NotificadorComunidad();
        this.gestorCercania = new GestorCercania(this, radioCercaniaIncidentes);
    }
    public RepoIncidentes getRepoIncidentes() {
        return repoIncidentes;
    }
    public List<Miembro> getMiembros() {
        return miembros;
    }
    private void notificarNuevoIncidenteAMiembros(Incidente nuevoIncidente){
        newsletter.notificarGestores(nuevoIncidente);
    }

    public void sugerirActualizarIncidente(List<Miembro> miembrosCerca,Incidente incidente){
        // es el notify() del observer al GestorCercania

        // genera una lista de sus gestores de notificaciones para mandarsela al gestor de la comunidad
        List<GestorNotificacionesPersona> gestoresNotisMiembros = (List<GestorNotificacionesPersona>) miembrosCerca.stream().map(miembro -> miembro.getPersona().getGestorNotificaciones());

        newsletter.notificarCercaniaIncidente(gestoresNotisMiembros, incidente);

    }


}
