package CalculoRanking;

import org.slf4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class CalculoRankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculoRankingApplication.class, args);
	}

	private static Logger logger = LoggerFactory.getLogger(CalculoRankingApplication.class);
	@Scheduled(fixedRate = 2000L)
	public void job(){
		//aca se llamaría el metodo que extrae entidades de la base de datos, calcula el ranking y lo almacena
		logger.info("la fecha es: " + new Date());
	}

}
