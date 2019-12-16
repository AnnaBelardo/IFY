package it.unisa.di.is.gc1.ify.domandaTirocinio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import it.unisa.di.is.gc1.ify.Studente.Studente;

/**
 * 
 * @author Geremia Cavezza
 *
 * Classe che modella una domanda di tirocinio
 */

@Entity
public class DomandaTirocinio {
	public DomandaTirocinio() {
		
	}
	
	public long getId() {
		return id;
	}
	
	public Studente getStudente() {
		return studente;
	}

	public void setStudente(Studente studente) {
		this.studente = studente;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	private Studente studente;
}
