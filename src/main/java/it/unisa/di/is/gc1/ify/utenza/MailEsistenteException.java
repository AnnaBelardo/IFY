package it.unisa.di.is.gc1.ify.utenza;

/**
 * Eccezione lanciata quando il controllo sull'email di un utente fallisce perché questo è già
 * presente nel sistema.
 * @author Giacomo Izzo, Alessia Natale
 */
public class MailEsistenteException extends Exception {

  private static final long serialVersionUID = 6746818670147635153L;
  
  /** Stringa che definisce il messaggio di default utilizzato nell'eccezione. */
  private static final String messaggioDefault = "Email già presente";
  
  /**
   * Costruisce un'eccezione che ha come messaggio {@link #messaggioDefault}.
   */
  public MailEsistenteException() {
    super(messaggioDefault);
  }
  
  /**
   * Costruisce un'eccezione che ha come messaggio la stringa specificata come parametro.
   * 
   * @param messaggio Stringa che rappresenta il messaggio da mostrare
   */
  public MailEsistenteException(String messaggio) {
    super(messaggio);
  }
  
}
