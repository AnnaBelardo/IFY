package it.unisa.di.ify;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import it.unisa.di.ify.Webapp;

/**
 * Classe per il caricamento delle configurazioni per il deploy dell'applicazione
 * e tramite build war su server esterni.
 * @author Carmine Ferrara
 */
public class ProgramInitializer extends SpringBootServletInitializer{
	 @Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(Webapp.class);
	  }
}
