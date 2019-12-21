package it.unisa.di.is.gc1.ify.responsabileUfficioTirocini;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import it.unisa.di.is.gc1.ify.utenza.Utente;

/**
 * Classe che modella i dati del Responsabile Ufficio Tirocini.
 * @author Simone Civale 
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class ResponsabileUfficioTirocini extends Utente {
	
	/**
	 * Costruttore che crea un oggeto Responsabile Ufficio Tirocini vuoto, 
	 * che verrà popolato con i metodi setters.
	 */
	public ResponsabileUfficioTirocini() {
		super();
	}
	
	/**
	 * Costruttore di un responsabile ufficio tirocini con parametri utile nei casi di test.
	 * @param nome è il nome del responsabile ufficio tirocini.
	 * @param cognome è il cognome del responsabile ufficio tirocini.
	 * @param sesso è il sesso del responsabile ufficio tirocini.
	 * @param email è l'email del responsabile ufficio tirocini.
	 * @param indirizzo è l'indirizzo del responsabile ufficio tirocini.
	 * @param password è la password del responsabile ufficio tirocini.
	 * @param ruolo è il ruolo che ricopre il responsabile ufficio tirocini.
	 */
	public ResponsabileUfficioTirocini(String nome, String cognome, String sesso, String email, String indirizzo, String password, String ruolo) {
		super(nome, cognome, sesso, email, indirizzo, password);
	}
	
	/**
	 * Metodo che ritorna il ruolo del responsabile ufficio tirocini.
	 * @return il ruolo del responsabile ufficio tirocini.
	 */
	public String getRuolo() {
		return ruolo;
	}
	
	/**
	 * Metodo che setta il ruolo del responsabile ufficio tirocini.
	 * @param ruolo è il ruolo del responsabile ufficio tirocini.
	 */
	public void setRuolo(String ruolo) {
		this.ruolo=ruolo;
	}
	
	String ruolo;
	
	/**
	 * Espressione regolare che definisce il formato del campo ruolo.
	 */
	public static final String RUOLO_PATTERN = "^[a-z A-Z àéèìòù]{2,255}$";
	
	/**
	 * Costante che definisce la minima lunghezza del campo ruolo.
	 */
	public static final int MIN_LUNGHEZZA_RUOLO = 2;
	
	/**
	 * Costante che definisce la massima lunghezza del campo ruolo.
	 */
	public static final int MAX_LUNGHEZZA_RUOLO= 255;

}
