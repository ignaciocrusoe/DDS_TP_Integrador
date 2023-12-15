package Grupo11.DDS_TP_Integrador.Repositories;


import Grupo11.DDS_TP_Integrador.Comunidades.IntervaloHorario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntervaloHorarioRepository extends JpaRepository<IntervaloHorario,Long> {



}
