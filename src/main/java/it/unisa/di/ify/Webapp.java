package it.unisa.di.ify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe per l'avvio dell'applicazione, necessaria a Spring per un avvio
 * diretto tramite tecnologia Springboot, evitando così il deploy su server
 * esterno in fase di sviluppo
 *
 * @author Carmine Ferrara
 */

@SpringBootApplication
@EnableAutoConfiguration
public class Webapp {
	
	/**
	 * Metodo necessario a Springboot per l'avvio dell'applicazione, 
	 * e per l'avvio del progetto da archivio war su un server esterno
	 */
	public static void main(String[] args) {
		SpringApplication.run(Webapp.class, args);
	}
}
