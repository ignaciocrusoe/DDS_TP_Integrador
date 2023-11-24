package Grupo11.DDS_TP_Integrador.Requests;

public class SubirCsvEntidadesRequest {
    private String categoria;
    private String nombre_entidad;
    private Long organismo_de_control;
    private Long prestador;

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public void setNombreEntidad(String nombreEntidad) {
        this.nombre_entidad = nombreEntidad;
    }
    public void setOrganismoDeControl(Long organismo_de_control) {
        this.organismo_de_control = organismo_de_control;
    }
    public void setPrestador(Long prestador) {
        this.prestador = prestador;
    }

    public String getCategoria() {
        return categoria;
    }
    public String getNombreEntidad() {
        return nombre_entidad;
    }
    public Long getOrganismoDeControl() {
        return organismo_de_control;
    }
    public Long getPrestador() {
        return prestador;
    }
}
