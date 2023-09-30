package CalculoRanking;

import CalculoRanking.Calculo.CalculoRanking;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class CalculoRankingApplication {
	@Autowired
	CalculoRanking calculoRanking;

	public static void main(String[] args) {
		SpringApplication.run(CalculoRankingApplication.class, args);
	}

	private static Logger logger = LoggerFactory.getLogger(CalculoRankingApplication.class);
	/*
	//@Scheduled(cron = "59 23 * * SUN") este es el que va
	@Scheduled(fixedRate = 2000L)
	public void job(){
		calculoRanking.calcularRankingSemanal(2);
		System.out.println("Se genero el ranking semanal");
	}*/

}
