package it.unisa.di.is.gc1.ify.Studente;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unisa.di.is.gc1.ify.utenza.UtenteRepository;

/**
 * La classe fornisce i metodi per la logica di business delle richieste d'iscrizione
 * 
 * @author Carmine Ferrara Giacomo Izzo
 */

@Service
public class RichiestaIscrizioneService {
	@Autowired
	private StudenteRepository studenteRepository;

	@Autowired
	private UtenteRepository utenteRepository;

	@Autowired
	private RichiestaIscrizioneRepository richiestaIscrizioneRepository;
	
	/**
	 * Il metodo fornisce la funzionalità di salvataggio di uno studente con la relativa
	 * richiesta d'iscrizione posta in stato di attesa
	 * @param studente
	 * 
	 * @return Richiesta Iscrizione richiestaIscrizione
	 * @pre studente != null
	 * @post richiestaIscrizione != null
	 */
	@Transactional(rollbackFor = Exception.class)
	public RichiestaIscrizione salvaRichiestaIscrizione(Studente studente) {
		RichiestaIscrizione richiestaIscrizione = new RichiestaIscrizione(RichiestaIscrizione.IN_ATTESA, studente);
		System.out.println(studente.getCognome());
	
		studente = studenteRepository.save(studente);
		richiestaIscrizione = richiestaIscrizioneRepository.save(richiestaIscrizione);

		return richiestaIscrizione;
	}
	
	
	/**
	 * Il metodo fornisce la funzionalità di accettazione di una richiesta d'iscrizione
	 * 
	 * 
	 * @param idRichiesta
	 * @return Richiesta d'iscrizione richiesta d'iscrizione
	 */
	@Transactional(rollbackFor = Exception.class)
	public RichiestaIscrizione accettaRichiestaIscrizione(Long idRichiesta) {
		RichiestaIscrizione richiestaIscrizione = richiestaIscrizioneRepository.findById(idRichiesta);

		richiestaIscrizione.setStato(RichiestaIscrizione.ACCETTATA);
		richiestaIscrizione = richiestaIscrizioneRepository.save(richiestaIscrizione);

		return richiestaIscrizione;
	}
	
	
	/**
	 * Il metodo fornisce la funzionalità di rifiuto di una richiesta d'iscrizione
	 * 
	 * 
	 * @param idRichiesta
	 * @return Richiesta d'iscrizione richiesta d'iscrizione
	 */
	@Transactional(rollbackFor = Exception.class)
	public RichiestaIscrizione rifiutaRichiestaIscrizione(Long idRichiesta) {
		RichiestaIscrizione richiestaIscrizione = richiestaIscrizioneRepository.findById(idRichiesta);

		richiestaIscrizione.setStato(RichiestaIscrizione.RIFIUTATA);
		richiestaIscrizione = richiestaIscrizioneRepository.save(richiestaIscrizione);

		return richiestaIscrizione;
	}

	
	/**
	 * Il metodo fornisce la funzionalità di validazione lato server per una generica richiesta d'iscrizione
	 * 
	 * @param studente
	 * @return true se i dati inviati sono validi
	 * @throws RichiestaIscrizioneNonValidaException
	 */
	public boolean validaRichiestaIscrizione(Studente studente) throws RichiestaIscrizioneNonValidaException {
		validaNome(studente.getNome());
		validaCognome(studente.getCognome());
		validaIndirizzo(studente.getIndirizzo());
		validaTelefono(studente.getTelefono());
		validaDataNascita(studente.getDataNascita());
		validaMatricola(studente.getMatricola());
		validaSesso(studente.getSesso());
		validaEmail(studente.getEmail());
		validaPassword(studente.getPassword());

		return true;
	}
	
	/**
	 * Il metodo fornisce i controlli di validazione del parametro nome di un generico studente
	 * @param nome
	 * @return nome
	 * @throws RichiestaIscrizioneNonValidaException
	 */
	private String validaNome(String nome) throws RichiestaIscrizioneNonValidaException {
		if (nome == null)
			throw new RichiestaIscrizioneNonValidaException("Il campo nome non può essere nullo.");

		if (nome.length() < 2)
			throw new RichiestaIscrizioneNonValidaException("Il campo nome deve contenere almeno 2 caratteri.");

		if (nome.length() > 255)
			throw new RichiestaIscrizioneNonValidaException("Il campo nome deve contenere al massimo 255 caratteri.");

		if (!nome.matches(Studente.NOME_PATTERN))
			throw new RichiestaIscrizioneNonValidaException(
					"Il campo nome deve contenere soltanto caratteri alfabetici o spazi.");
		return nome;
	}
	
	/**
	 * Il metodo fornisce i controlli di validazione del parametro cognome di un generico studente
	 * @param cognome
	 * @return cognome
	 * @throws RichiestaIscrizioneNonValidaException
	 */
	private String validaCognome(String cognome) throws RichiestaIscrizioneNonValidaException {
		if (cognome == null)
			throw new RichiestaIscrizioneNonValidaException("Il campo cognome non può essere nullo.");

		if (cognome.length() < 2)
			throw new RichiestaIscrizioneNonValidaException("Il campo cognome deve contenere almeno 2 caratteri.");

		if (cognome.length() > 255)
			throw new RichiestaIscrizioneNonValidaException(
					"Il campo cognome deve contenere al massimo 255 caratteri.");

		if (!cognome.matches(Studente.COGNOME_PATTERN))
			throw new RichiestaIscrizioneNonValidaException(
					"Il campo cognome deve contenere soltanto caratteri alfabetici o spazi.");
		return cognome;
	}

	/**
	 * Il metodo fornisce i controlli di validazione del parametro indirizzo di un generico studente
	 * @param indirizzo
	 * @return indirizzo
	 * @throws RichiestaIscrizioneNonValidaException
	 */
	private String validaIndirizzo(String indirizzo) throws RichiestaIscrizioneNonValidaException {
		if (indirizzo == null)
			throw new RichiestaIscrizioneNonValidaException("Il campo indirizzo non può essere nullo.");

		if (indirizzo.length() < 2)
			throw new RichiestaIscrizioneNonValidaException("Il campo indirizzo deve contenere almeno 2 caratteri.");

		if (indirizzo.length() > 255)
			throw new RichiestaIscrizioneNonValidaException(
					"Il campo indirizzo deve contenere al massimo 255 caratteri.");

		if (!indirizzo.matches(Studente.INDIRIZZO_PATTERN))
			throw new RichiestaIscrizioneNonValidaException(
					"Il campo indirizzo deve contenere soltanto caratteri alfanumerici e segni di punteggiatura.");
		return indirizzo;
	}

	/**
	 * Il metodo fornisce i controlli di validazione del parametro telefono di un generico studente
	 * @param telefono
	 * @return telefono
	 * @throws RichiestaIscrizioneNonValidaException
	 */
	private String validaTelefono(String telefono) throws RichiestaIscrizioneNonValidaException {
		if (telefono == null)
			throw new RichiestaIscrizioneNonValidaException("Il campo telefono non può essere nullo.");

		if (telefono.length() < 10)
			throw new RichiestaIscrizioneNonValidaException("Il campo telefono deve contenere almeno 10 caratteri.");

		if (telefono.length() > 11)
			throw new RichiestaIscrizioneNonValidaException(
					"Il campo telefono deve contenere al massimo 11 caratteri.");

		if (!telefono.matches(Studente.TELEFONO_PATTERN))
			throw new RichiestaIscrizioneNonValidaException(
					"Il campo telefono deve contenere soltanto caratteri numerici, al più le prime tre cifre possono"
							+ "essere separate da un trattino.");
		return telefono;
	}

	/**
	 * Il metodo fornisce i controlli di validazione del parametro data di nascita di un generico studente
	 * @param data di nascita
	 * @return data di nascita
	 * @throws RichiestaIscrizioneNonValidaException
	 */
	private LocalDate validaDataNascita(LocalDate dataNascita) throws RichiestaIscrizioneNonValidaException {
		if (dataNascita == null)
			throw new RichiestaIscrizioneNonValidaException("Il campo data di nascita non può essere nullo.");

		if (dataNascita.isBefore(Studente.MIN_DATE) || dataNascita.isAfter(Studente.MAX_DATE))
			throw new RichiestaIscrizioneNonValidaException("La data di nascita non rientra nel range consento "
					+ Studente.MIN_DATE.getDayOfMonth() + "/" + Studente.MIN_DATE.getMonthValue() + "/"
					+ Studente.MIN_DATE.getYear() + " - " + Studente.MAX_DATE.getDayOfMonth() + "/"
					+ Studente.MAX_DATE.getMonthValue() + "/" + Studente.MAX_DATE.getYear() + ".");

		return dataNascita;
	}

	/**
	 * Il metodo fornisce i controlli di validazione del parametro matricola di un generico studente
	 * @param matricola
	 * @return matricola
	 * @throws RichiestaIscrizioneNonValidaException
	 */
	private String validaMatricola(String matricola) throws RichiestaIscrizioneNonValidaException {
		if (matricola == null)
			throw new RichiestaIscrizioneNonValidaException("Il campo matricola non può essere nullo.");

		if (matricola.length() != 10)
			throw new RichiestaIscrizioneNonValidaException("Il campo matricola deve contenere 10 caratteri.");

		if (!matricola.matches(Studente.MATRICOLA_PATTERN))
			throw new RichiestaIscrizioneNonValidaException(
					"Il campo matricola deve contenere solo caratteri numerici.");
		return matricola;
	}

	/**
	 * Il metodo fornisce i controlli di validazione del parametro sesso di un generico studente
	 * @param sesso
	 * @return sesso
	 * @throws RichiestaIscrizioneNonValidaException
	 */
	private String validaSesso(String sesso) throws RichiestaIscrizioneNonValidaException {
		if (sesso == null)
			throw new RichiestaIscrizioneNonValidaException("Il campo sesso non può essere nullo.");

		if (!sesso.matches(Studente.SESSO_PATTERN))
			throw new RichiestaIscrizioneNonValidaException(
					"Il campo sesso deve essere valorizzato con un solo carattere tra M o F.");
		return sesso;
	}

	/**
	 * Il metodo fornisce i controlli di validazione del parametro email di un generico studente
	 * @param email
	 * @return email
	 * @throws RichiestaIscrizioneNonValidaException
	 */
	private String validaEmail(String email) throws RichiestaIscrizioneNonValidaException {
		if (email == null)
			throw new RichiestaIscrizioneNonValidaException("Il campo e-mail non può essere nullo.");

		if (email.length() < 2)
			throw new RichiestaIscrizioneNonValidaException("Il campo e-mail deve contenere almeno 2 caratteri.");

		if (email.length() > 256)
			throw new RichiestaIscrizioneNonValidaException("Il campo e-mail deve contenere al massimo 255 caratteri.");

		if (!email.matches(Studente.EMAIL_STUDENTE_PATTERN))
			throw new RichiestaIscrizioneNonValidaException("Il campo e-mail non rispetta il formato stabilito.");

		if (utenteRepository.existsByEmail(email))
			throw new RichiestaIscrizioneNonValidaException("l'e-mail inserita è già presente.");

		return email;
	}

	/**
	 * Il metodo fornisce i controlli di validazione del parametro password di un generico studente
	 * @param password
	 * @return password
	 * @throws RichiestaIscrizioneNonValidaException
	 */
	private String validaPassword(String password) throws RichiestaIscrizioneNonValidaException {
		if (password == null)
			throw new RichiestaIscrizioneNonValidaException("Il campo password non può essere nullo.");

		if (password.length() < 8)
			throw new RichiestaIscrizioneNonValidaException("Il campo password deve contenere almeno 8 caratteri.");

		if (password.length() > 24)
			throw new RichiestaIscrizioneNonValidaException(
					"Il campo password deve contenere al massimo 24 caratteri.");

		if (!password.matches(Studente.PASSWORD_PATTERN))
			throw new RichiestaIscrizioneNonValidaException("Il campo password deve contenere almeno un"
					+ "un numero, almeno una lettera e non deve contenere spazi.");
		return password;
	}

}
