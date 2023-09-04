package Grupo11.DDS_TP_Integrador.Georef.Localizaciones;
import Grupo11.DDS_TP_Integrador.Establecimientos.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;
import Grupo11.DDS_TP_Integrador.Intereses.*;
import jakarta.persistence.*;

@Entity(name = "localizaciones")
@PrimaryKeyJoinColumn(name = "id_localizacion")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Localizacion extends Interes{


}

