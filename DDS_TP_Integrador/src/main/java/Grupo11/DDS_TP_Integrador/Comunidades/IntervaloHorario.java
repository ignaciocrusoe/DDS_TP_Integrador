package Grupo11.DDS_TP_Integrador.Comunidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name="intervaloHorario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class IntervaloHorario {


    @Id
    @Column(name = "interv_segundos")
    private Long segundos;

    @Override
    public String toString() {
        return segundos.toString();
    }

    @Override
    public boolean equals(Object o) {

        IntervaloHorario that = (IntervaloHorario) o;
        return this.getSegundos()==that.getSegundos();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSegundos());
    }


}
