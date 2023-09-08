package Grupo11.DDS_TP_Integrador.Notificadores;

import jakarta.persistence.*;

import java.util.List;
import java.util.function.Predicate;
public class RepoNotificaciones {

    public List<Notificacion> getNotificacionSegunEstado(List<Notificacion> listaNotificaciones, TipoNotificacion tipo){
        Predicate<Notificacion> mismoTipo = (n) -> n.getTipo() == tipo;
        return listaNotificaciones.stream().filter(mismoTipo).toList();
    }



}
