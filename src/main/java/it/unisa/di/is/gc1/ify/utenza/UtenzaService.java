package it.unisa.di.is.gc1.ify.utenza;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unisa.di.is.gc1.ify.Studente.StudenteRepository;



/**
 * 
 * Classe che defisce operazioni che permettono di realizzare la logica di business comune a
 * tutti gli utenti del sistema
 * 
 * @see UtenteRegistrato
 * @see UtenteRegistratoRepository
 */
@Service
public class UtenzaService {

	@Autowired
	private UtenteRepository utenteRepository;
	
	@Autowired
	private StudenteRepository studenteRepository;
	
	  /**
	   * Controlla che l'username di un utente sia specificato e che rispetti il formato prestabilito.
	   * Controlla inolte che tale username non sia già presente nel sistema.
	   * 
	   * @param username Stringa che rappresenta l'username da controllare
	   * 
	   * @return username La stringa che rappresenta l'username da controllare bonificata
	   * 
	   * @throws MailNonValidaException se l'username non è specificato oppure se non rispetta il
	   *         formato {@link UtenteRegistrato#USERNAME_PATTERN}
	   * 
	   * @throws MailEsistenteException se l'username specificato è già presente nel sistema
	   */
	  public String validaMail(String email)
	         throws MailNonValidaException, MailEsistenteException {
	    if (email == null) {
	      throw new MailNonValidaException();
	    } else {
	    	email = email.trim();
	      
	      if (!email.matches(Utente.NOME_PATTERN)) {
	        throw new MailNonValidaException();
	      } else if (utenteRepository.existsByEmail(email)) {
	        throw new MailEsistenteException();
	      } else {
	        return email;
	      }
	    }
	  }
	  
	  /**
	   * Permette di ottenerel'utente autenticato nel sistema
	   * 
	   * @return l'utente autenticato nel sistema, <b>null</b> se non vi è alcun utente autenticato
	   */
	  public Utente getUtenteAutenticato() {
		  // Ottieni l'username dell'utente autenticato e restituisci null se non è presente alcun utente
		  // in sessione
		  String email = (AutenticazioneHolder.getUtente());
		  if (email == null) {
			  return null;
		  }
		  
		  Utente utente;
		  
		  // Controlla se l'username è associato ad uno studente
		  utente = utenteRepository.findByEmail(email);
		  if(utente != null) {
			  return utente;
		  }
		  
		  return null;
	  }

	  /**
	   * Permette di specificare l'utente autenticato nel sistema, tramite username, in una variabile
	   * visibile a livello di thread così da condividere l'informazione con tutti gli altri livelli.
	   * Questo metodo può essere utilizzato per iniettare automaticamente l'utente nel thread associato
	   * alla richiesta a partire dall'attributo di sessione del server.
	   * 
	   * @param username Username dell'utente che si vuole autenticare nel sistema
	   */
	  public void setUtenteAutenticato(String email) {
		   // Se username è null, rimuovi la variabile di thread per prevenire memory leak
		  if(email == null) {
			  AutenticazioneHolder.setUtente(null);
			  return;
		  }
		  
		  if(utenteRepository.existsByEmail(email)) {
			  AutenticazioneHolder.setUtente(email);
		  }
	  }
	  
	  /**
	   * Permette l'autenticazione di un utente nel sistema.
	   * 
	   * @param username Stringa che rappresenta l'username dell'utente
	   * 
	   * @param password Stringa che rappresenta la password dell'utente
	   * 
	   * @throws CredenzialiNonValideException se la coppia (username, password) non è presente nel
	   *         sistema
	   *         
	   * @throws RichiestaConvenzionamentoInAttesaException se l'utente che tenta di accedere è un
	   *         delegato aziendale che rappresenta un'azienda la cui richiesta di convenzionamento non
	   *         è ancora stata gestita
	   *         
	   * @throws RichiestaConvenzionamentoRifiutataException se l'utente che tenta di accedere è un
	   *         delegato aziendale che rappresenta un'azienda la cui richiesta di convenzionamento non
	   *         è stata rifiutata
	   *         
	   * @throws RichiestaIscrizioneInAttesaException se l'utente che tenta di accedere è uno studente
	   *         la cui richiesta d'iscrizione non è ancora stata gestita
	   *         
	   * @throws RichiestaIscrizioneRifiutataException se l'utente che tenta di accedere è uno studente
	   *         la cui richiesta d'iscrizione è stata rifiutata
	   */
	  public void login(String email, String password)
	         throws CredenzialiNonValideException {		  
	    Utente utente;
	    
	    // Controlla se le credenziali corrispondono a quelle di uno studente e, nel caso, controlla
	    // che la richiesta d'iscrizione associatagli sia stata accettata
	    utente = utenteRepository.findByEmailAndPassword(email, password);
	    if (utente != null) {
	      AutenticazioneHolder.setUtente(email);
	      return;
	    }
	    
	    throw new CredenzialiNonValideException();
	  }
	  
	  /**
	   * Permette la rimozione dell'utente dalla sessione.
	   */
	  public void logout() { 
	    AutenticazioneHolder.setUtente(null);
	  }
}
