package Grupo11.DDS_TP_Integrador.Requests;

public class SubirCsvOrganismosRequest {
    private String nombre_organismo_control;
    private String mail_organismo_control;

    public void setNombreOrganismo(String nombre_organismo_control) {
        this.nombre_organismo_control = nombre_organismo_control;
    }
    public void setMailOrganismo(String nombre_organismo_control) {
        this.mail_organismo_control = mail_organismo_control;
    }
    public String getNombreOrganismo() {return nombre_organismo_control;
    }
    public String getMailOrganismo() {
        return mail_organismo_control;
    }
}
