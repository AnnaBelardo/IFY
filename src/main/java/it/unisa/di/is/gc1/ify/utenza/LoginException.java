package it.unisa.di.is.gc1.ify.utenza;

public class LoginException extends Exception {
	
	private static final long serialVersionUID = 493877814951499959L;
	
	/** Stringa che definisce il messaggio di default utilizzato nell'eccezione. */
	private static final String MESSAGGIO_DEFAULT = "Eccezione durante il login.";

	/**
	 * Genera un'eccezione che riporta come messaggio il messaggio di default:
	 * {@link #MESSAGGIO_DEFAULT}.
	 */
	public LoginException() {
		super(MESSAGGIO_DEFAULT);
	}

	/**
	 * Genera un'eccezione che riporta come messaggio, un messaggio passato come
	 * parametro
	 * 
	 * @param messaggio Stringa che rappresenta il messaggio da mostrare
	 *               nell'output dell'eccezione
	 */
	public LoginException(String messaggio) {
		super(messaggio);
	}

}
