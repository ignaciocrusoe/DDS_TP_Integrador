package Grupo11.DDS_TP_Integrador.Requests;

public class ModificarIncidenteRequest {

        private Long idIncidente;

        private String description;

        public Long getIdIncidente() {
            return idIncidente;
        }

        public void setIdIncidente(Long idIncidente) {
            this.idIncidente = idIncidente;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

}
