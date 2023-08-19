package Grupo11.DDS_TP_Integrador;

import Grupo11.DDS_TP_Integrador.Comunidades.Persona;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication //quitar commandLinerRunner (hace que se ejecute por consola)
public class DdsTpIntegradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DdsTpIntegradorApplication.class, args);
	}

}
/*public class DdsTpIntegradorApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(DdsTpIntegradorApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(DdsTpIntegradorApplication.class, args);
	}

	@Override
	public void run(String... args) {

	}

}*/
