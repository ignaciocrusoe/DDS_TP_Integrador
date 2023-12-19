package Grupo11.DDS_TP_Integrador.Requests;


public class SubirCsvOrganismosRequest {
    private String nombreOrganismoControl;
    private String mailOrganismoControl;

    public String getNombreOrganismoControl() {
        return nombreOrganismoControl;
    }

    public void setNombreOrganismoControl(String nombreOrganismoControl) {
        this.nombreOrganismoControl = nombreOrganismoControl;
    }

    public String getMailOrganismoControl() {
        return mailOrganismoControl;
    }

    public void setMailOrganismoControl(String mailOrganismoControl) {
        this.mailOrganismoControl = mailOrganismoControl;
    }
}