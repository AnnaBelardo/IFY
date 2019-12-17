package it.unisa.di.is.gc1.ify.Studente;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * 
 * @author Geremia Cavezza
 *
 * Classe che modella una richiesta di iscrizione
 */

@Entity
public class RichiestaIscrizione {
	
	public RichiestaIscrizione() {
		
	}
	
	
	
	public RichiestaIscrizione(String stato, Studente studente) {
		this.stato = stato;
		this.studente = studente;
	}

	public long getId() {
		return id;
	}

	public String getStato() {
		return stato;
	}
	
	public void setStato(String stato) {
		this.stato = stato;
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
	private String stato;
	@OneToOne(cascade = CascadeType.ALL)
	private Studente studente;
	
		/**
	    * Costante che rappresenta lo stato "in attesa" di una richiesta di iscrizione.
		* Una richiesta si trova in questo stato quando non è ancora stata valutata.
		*/
		public static final String IN_ATTESA = "in attesa";
		
		/**
		* Costante che rappresenta lo stato "accettata" di una richiesta di iscrizione.
		* Una richiesta si trova in questo stato quando è stata accettata dal responsabile ufficio tirocini.
		*/
		public static final String ACCETTATA = "accettata";
	
		/**
		* Costante che rappresenta lo stato "rifiutata" di una richiesta di iscrizione.
		* Una richiesta si trova in questo stato quando è stata rifiutata dal responsabile ufficio tirocini.
		*/
		public static final String RIFIUTATA = "rifiutata";
}
