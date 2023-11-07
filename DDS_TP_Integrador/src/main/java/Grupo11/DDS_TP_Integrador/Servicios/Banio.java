package Grupo11.DDS_TP_Integrador.Servicios;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Banio")
public class Banio extends Prestacion {

}
