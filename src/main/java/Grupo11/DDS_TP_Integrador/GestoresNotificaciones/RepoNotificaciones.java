package Grupo11.DDS_TP_Integrador.GestoresNotificaciones;

import java.util.List;
import java.util.function.Predicate;

public class RepoNotificaciones {
    private List<Notificacion> listaNotificaciones;
    public List<Notificacion> getListaNotificaciones() {
        return listaNotificaciones;
    }
    public void addNotificacion(Notificacion Notificacion){
        listaNotificaciones.add(Notificacion);
    }

    public List<Notificacion> getNotificacionSegunEstado(TipoNotificacion tipo){
        Predicate<Notificacion> mismoTipo = (n) -> n.getTipo() == tipo;
        return listaNotificaciones.stream().filter(mismoTipo).toList();
    }

    public void removeNotificacion(Notificacion notificacion){
        listaNotificaciones.remove(notificacion);
    }
}
