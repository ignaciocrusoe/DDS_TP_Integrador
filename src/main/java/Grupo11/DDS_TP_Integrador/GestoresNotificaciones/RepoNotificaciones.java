package Grupo11.DDS_TP_Integrador.GestoresNotificaciones;

import jakarta.persistence.*;

import java.util.List;
import java.util.function.Predicate;
@Entity
public class RepoNotificaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_repoNotificaciones")
    private Long id_repoNotificaciones;

    @OneToMany(mappedBy = "repo_notificaciones")
    private List<Notificacion> listaNotificaciones;


    public RepoNotificaciones(Long id_repoNotificaciones, List<Notificacion> listaNotificaciones) {
        this.id_repoNotificaciones = id_repoNotificaciones;
        this.listaNotificaciones = listaNotificaciones;
    }

    public RepoNotificaciones() {
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

    public Long getId_repoNotificaciones() {
        return id_repoNotificaciones;
    }

    public void setId_repoNotificaciones(Long id_repoNotificaciones) {
        this.id_repoNotificaciones = id_repoNotificaciones;
    }

    public List<Notificacion> getListaNotificaciones() {
        return listaNotificaciones;
    }

    public void setListaNotificaciones(List<Notificacion> listaNotificaciones) {
        this.listaNotificaciones = listaNotificaciones;
    }
}
