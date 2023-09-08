package Grupo11.DDS_TP_Integrador.Georef.Localizaciones;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name = "provincias")
@PrimaryKeyJoinColumn(name = "id_provincia")
public class Provincia extends Localizacion{

}
