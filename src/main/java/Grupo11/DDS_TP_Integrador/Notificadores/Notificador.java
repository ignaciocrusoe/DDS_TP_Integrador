package Grupo11.DDS_TP_Integrador.Notificadores;
import Grupo11.DDS_TP_Integrador.GestoresNotificaciones.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;

import java.util.LinkedList;
import java.util.List;

public class Notificador{
    public void notificarPersonas(List<Persona> personas, Notificacion notificacion){
        for (Persona persona:personas
        ) {
            persona.getNotificaciones().add(notificacion);
        }
    }

}

