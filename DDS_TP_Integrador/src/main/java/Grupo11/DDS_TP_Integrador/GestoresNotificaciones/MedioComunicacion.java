package Grupo11.DDS_TP_Integrador.GestoresNotificaciones;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Notificadores.*;
import Grupo11.DDS_TP_Integrador.Notificadores.*;
import jakarta.persistence.*;

@Entity(name = "medios_comunicacion")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "categoria", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("MedioComunicacion")
public class MedioComunicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_medio")
    private Long id_medio;
    @Column(name="nombre_medio")
    private String nombre_medio;

    public void notificar(){

    }

    public MedioComunicacion() {
    }

    public Long getId_medio() {
        return id_medio;
    }

    public void setId_medio(Long id_medio) {
        this.id_medio = id_medio;
    }

    public String getNombre_medio() {
        return nombre_medio;
    }

    public void setNombre_medio(String nombre_medio) {
        this.nombre_medio = nombre_medio;
    }
}

