package Grupo11.DDS_TP_Integrador.Notificadores;
import Grupo11.DDS_TP_Integrador.GestoresNotificaciones.*;
import Grupo11.DDS_TP_Integrador.Comunidades.*;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service
public class Notificador{
    public void notificarPersonas(List<Miembro> miembros, Notificacion notificacion){
        for (Miembro miembro: miembros
        ) {
            miembro.getPersona().getListaNotificaciones().add(notificacion);
        }
    }

}

