package Grupo11.DDS_TP_Integrador.GestoresNotificaciones;
import Grupo11.DDS_TP_Integrador.Incidentes.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Notificadores.*;
import Grupo11.DDS_TP_Integrador.Notificadores.*;
import jakarta.persistence.*;

@Entity(name = "mediosComunicacion")
@Inheritance(strategy = InheritanceType.JOINED)
public class MedioComunicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_medio")
    private Long id_medio;
    @Column(name="nombre_medio")
    private String nombre_medio;

    public void notificar(){

    }

}

