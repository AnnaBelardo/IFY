package it.unisa.di.is.gc1.ify.Studente;


/**
 * Eccezione generata in caso di parametri non validi
 * durante il controllo di una richiesta d'iscrizione
 * @author Giacomo Izzo Carmine Ferrara
 */
public class RichiestaIscrizioneNonValidaException extends Exception {

	private static final long serialVersionUID = 2441773366582183446L;
	

	  /** Stringa che definisce il messaggio di default utilizzato nell'eccezione. */
	  private static final String messaggioDefault = "Richiesta d'iscrizione non valida";
	  
	  /**
	   * Genera un'eccezione che riporta come messaggio il messaggio di default: {@link #messaggioDefault}.
	   */
	  public RichiestaIscrizioneNonValidaException() {
	    super(messaggioDefault);
	  }
	  
	  /**
	   * Genera un'eccezione che riporta come messaggio, un messaggio passato come parametro
	   * 
	   * @param String messaggio Stringa che rappresenta il messaggio da mostrare nell'output dell'eccezione
	   */
	  public RichiestaIscrizioneNonValidaException(String messaggio) {
	    super(messaggio);
	  }
}
