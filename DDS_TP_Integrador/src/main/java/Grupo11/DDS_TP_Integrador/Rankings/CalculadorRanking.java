package Grupo11.DDS_TP_Integrador.Rankings;

import Grupo11.DDS_TP_Integrador.Entidades.Entidad;
import Grupo11.DDS_TP_Integrador.Incidentes.RepoIncidentes;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class CalculadorRanking {
    @Autowired
    protected RepoIncidentes repoIncidentes;

    public abstract List<Entidad> calcularRanking(List<Entidad> entidades);
}
