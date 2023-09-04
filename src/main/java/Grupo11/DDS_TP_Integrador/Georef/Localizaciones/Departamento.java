package Grupo11.DDS_TP_Integrador.Georef.Localizaciones;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name = "departamentos")
@PrimaryKeyJoinColumn(name = "id_departamento")
public class Departamento extends Localizacion {

}
