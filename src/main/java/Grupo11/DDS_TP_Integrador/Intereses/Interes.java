package Grupo11.DDS_TP_Integrador.Intereses;

import jakarta.persistence.*;

@Entity
@Table(name="intereses")
public class Interes{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_interes")
    private Long idInteres;

    //por ahora para probar
    private String nombreInteres;
}