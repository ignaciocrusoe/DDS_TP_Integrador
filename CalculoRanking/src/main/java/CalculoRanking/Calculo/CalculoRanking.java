package CalculoRanking.Calculo;

import java.time.Duration;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import CalculoRanking.Entidades.*;
import CalculoRanking.Incidentes.*;
import CalculoRanking.Rankings.RankingMayorImpacto;
import CalculoRanking.Repositories.EntidadRepository;
import CalculoRanking.Repositories.RankingMayorImpactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculoRanking {
    @Autowired
    private EntidadRepository entidadRepo;
    @Autowired
    private RankingMayorImpactoRepository rankingRepo;

    // ESTO CALCULA EL IMPACTO
    public int calcularImpacto(Entidad entidad, int cnf){
        int tResolucion = 0;
        int cNoResueltos = 0;
        if(entidad.getIncidentes_reportados() == null){
            return 0;
        }
        for(Incidente incidente : entidad.getIncidentes_reportados()){
            if(!incidente.getEstado()){
                tResolucion += Duration.between(incidente.getCierre(), incidente.getApertura()).toDays();
            }
            else{
                cNoResueltos++;
            }
        }
        return tResolucion + cNoResueltos * cnf;
    }

    //ESTO ORDENA LAS ENTIDADES SEGUN EL IMPACTO (CALCULA EL RANKING)
    public List<Entidad> calcularRanking(List<Entidad> entidades, int cnf) {
        Collections.sort(entidades, new Comparator<Entidad>() {
            @Override
            public int compare(Entidad entidad1, Entidad entidad2) {
                return calcularImpacto(entidad1, cnf) - calcularImpacto(entidad2, cnf);
            }
        });
        Collections.reverse(entidades);
        return entidades;
    }

    // ESTO OBTIENE TODAS LAS ENTIDADES DE LA BASE DE DATOS
    public List<Entidad> obtenerEntidades(){
        return entidadRepo.findAll();
    }

    //ESTO SE EJECUTA EN EL SCHEDULER
    //el cnf se tiene que establecer desde la aplicacion (asumamos que es un 2)
    public void calcularRankingSemanal(int cnf){
        RankingMayorImpacto nuevoRanking = new RankingMayorImpacto();
        nuevoRanking.setEntidades  (  calcularRanking (this.obtenerEntidades(), 2) );
        rankingRepo.save((nuevoRanking));
    }



}
