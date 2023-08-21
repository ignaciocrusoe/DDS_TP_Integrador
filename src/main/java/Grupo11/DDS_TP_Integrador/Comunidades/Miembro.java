package Grupo11.DDS_TP_Integrador.Comunidades;

import Grupo11.DDS_TP_Integrador.Localizaciones.*;

public class Miembro {

    final private Comunidad comunidadMiembro;
    final private Persona personaMiembro;
    private Rol rolEnComunidad;
    private TipoUsuario tipoUsuario;

    public Miembro(Persona persona, Comunidad comunidadMiembro, Rol rol, TipoUsuario tipo){
        this.personaMiembro=persona;
        this.comunidadMiembro=comunidadMiembro;
        this.rolEnComunidad=rol;
        this.tipoUsuario=tipo;
    }
    public void setTipoUsuario(TipoUsuario tipo){
        this.tipoUsuario=tipo;
    }

    public void setRol(Rol rol){
        this.rolEnComunidad=rol;
    }

    public Comunidad getComunidad(){
        return this.comunidadMiembro;
    }

    public Persona getPersona(){
        return this.personaMiembro;
    }

}
