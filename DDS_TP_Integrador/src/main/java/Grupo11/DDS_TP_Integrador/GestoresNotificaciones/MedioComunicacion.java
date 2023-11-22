package Grupo11.DDS_TP_Integrador.GestoresNotificaciones;
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
    private String nombreMedio;

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

    public String getNombreMedio() {
        return nombreMedio;
    }

    public void setNombreMedio(String nombreMedio) {
        this.nombreMedio = nombreMedio;
    }
}

