package it.unisa.di.is.gc1.ify.utenza;

/**
 * Eccezione lanciata quando il controllo sull'email di un utente fallisce perché questo non
 * rispetta il pattern oppure è nullo.
 * @author Giacomo Izzo, Alessia Natale
 */
public class MailNonValidaException extends Exception {

  private static final long serialVersionUID = -8870973825876004160L;
  
  /** Stringa che definisce il messaggio di default utilizzato nell'eccezione. */
  private static final String messaggioDefault = "Email non valida";
  
  /**
   * Costruisce un'eccezione che ha come messaggio {@link #messaggioDefault}.
   */
  public MailNonValidaException() {
    super(messaggioDefault);
  }
  
  /**
   * Costruisce un'eccezione che ha come messaggio la stringa specificata come parametro.
   * 
   * @param messaggio Stringa che rappresenta il messaggio da mostrare
   */
  public MailNonValidaException(String messaggio) {
    super(messaggio);
  }
  
}
