package Grupo11.DDS_TP_Integrador.Georef.Localizaciones;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name = "municipios")
@PrimaryKeyJoinColumn(name = "id_municipio")
public class Municipio extends Localizacion{

}
