package Grupo11.DDS_TP_Integrador.Requests;

public class SubirCsvEntidadesRequest {
    private String categoria;
    private String nombre_entidad;
    private Long organismo_de_control;
    private Long prestador;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre_entidad() {
        return nombre_entidad;
    }

    public void setNombre_entidad(String nombre_entidad) {
        this.nombre_entidad = nombre_entidad;
    }

    public Long getOrganismo_de_control() {
        return organismo_de_control;
    }

    public void setOrganismo_de_control(Long organismo_de_control) {
        this.organismo_de_control = organismo_de_control;
    }

    public Long getPrestador() {
        return prestador;
    }

    public void setPrestador(Long prestador) {
        this.prestador = prestador;
    }
}
