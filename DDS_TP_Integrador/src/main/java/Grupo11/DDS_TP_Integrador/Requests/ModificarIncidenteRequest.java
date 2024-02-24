package Grupo11.DDS_TP_Integrador.Requests;

import Grupo11.DDS_TP_Integrador.Establecimientos.Establecimiento;

public class ModificarIncidenteRequest {

        private Long idIncidente;

        private String description;

        private String establecimiento;

        private String prestacion;

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

        public String getEstablecimiento() {return establecimiento;}

        public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

        public String getPrestacion() {return prestacion;}

        public void setPrestacion(String prestacion) {
            this.prestacion = prestacion;
        }


}
