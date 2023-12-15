package Grupo11.DDS_TP_Integrador.Comunidades;

//import Grupo11.DDS_TP_Integrador.Localizaciones.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="membresias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Miembro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_miembro")
    private Long idMiembro;

    @Column(name="nombre_comunidad")
    private String nombre;

    @ManyToOne
    @JoinColumn(name="comunidad")
    private Comunidad comunidad;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "persona")
    private Persona persona;

    @Enumerated(EnumType.STRING)
    @Column(name="rol_comunidad")
    private Rol rolEnComunidad;

    @Enumerated(EnumType.STRING)
    @Column(name="rol_usuario")
    private TipoUsuario tipoUsuario;


}
