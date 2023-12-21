package CalculoRanking.Rankings;

import CalculoRanking.Entidades.Entidad;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class CalculadorRanking {

    public abstract List<Entidad> calcularRanking(List<Entidad> entidades);
}
