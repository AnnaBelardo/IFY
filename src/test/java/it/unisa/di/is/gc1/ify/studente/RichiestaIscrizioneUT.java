package it.unisa.di.is.gc1.ify.studente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import it.unisa.di.is.gc1.ify.Studente.RichiestaIscrizione;
import it.unisa.di.is.gc1.ify.Studente.RichiestaIscrizioneNonValidaException;
import it.unisa.di.is.gc1.ify.Studente.RichiestaIscrizioneRepository;
import it.unisa.di.is.gc1.ify.Studente.RichiestaIscrizioneService;
import it.unisa.di.is.gc1.ify.Studente.Studente;
import it.unisa.di.is.gc1.ify.Studente.StudenteRepository;
import it.unisa.di.is.gc1.ify.utenza.UtenteRepository;
import it.unisa.di.is.gc1.ify.web.StudenteController;

@RunWith(MockitoJUnitRunner.class)
/**
 * classe di test di unità per la richiesta di iscrizione
 * @author Giusy Castaldo, Giacomo Izzo
 *
 */
public class RichiestaIscrizioneUT {

	@Mock
	StudenteRepository studenteRepository;
	@Mock
	RichiestaIscrizioneRepository richiestaIscrizioneRepository;
	@Mock
	StudenteController studenteController;
	@Mock
	UtenteRepository utenteRepository;

	@InjectMocks
	RichiestaIscrizioneService richiestaIscrizioneService;


	/** 
	 * Verifica che il campo nome non sia null
	 */
	@Test
	public void ValidaNome_Null() {

		String nome =null;
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo nome non può essere nullo.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}
	
	/**
	 * verifica la lunghezza minima del campo nome
	 */
	@Test
	public void ValidaNome_Min_Lunghezza() {

		String nome = "";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo nome deve contenere almeno 2 caratteri.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica lunghezza massima del nome
	 */
	@Test
	public void ValidaNome_Max_Lunghezza() {

		String nome = "MarioAndreaaaaaaaaaaaaaaaaaaaaa" + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo nome deve contenere al massimo 255 caratteri.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica formato del nome
	 */
	@Test
	public void ValdiaNome_Formato() {

		String nome = "Mario97";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo nome deve contenere soltanto caratteri alfabetici o spazi.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica che il campo cognome non sia null
	 */
	@Test
	public void ValidaCognome_Null() {

		String nome = "Mario";
		String cognome = null;
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo cognome non può essere nullo.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica lunghezza minima cognome
	 */
	@Test
	public void ValidaCognome_Min_Lunghezza() {

		String nome = "Mario";
		String cognome = "";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo cognome deve contenere almeno 2 caratteri.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica lunghezza massima cognome
	 */
	@Test
	public void validaCognome_Max_Lunghezza() {

		String nome = "Mario";
		String cognome = "Rossiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo cognome deve contenere al massimo 255 caratteri.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica formato cognome
	 */
	@Test
	public void validaCognome_Formato() {

		String nome = "Mario";
		String cognome = "Rossi97";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo cognome deve contenere soltanto caratteri alfabetici o spazi.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);
			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica che il campo indirizzo non sia null
	 */
	@Test
	public void ValidaIndirizzo_Null() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = null;
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo indirizzo non può essere nullo.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}
	
	/**verifica lunghezza minima indirizzo
	 * 
	 */
	@Test
	public void validaIndirizzo_Min_Lunghezza() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo indirizzo deve contenere almeno 2 caratteri.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica lunghezza massima indirizzo
	 */
	@Test
	public void validaIndirizzo_Max_Lunghezza() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Romaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo indirizzo deve contenere al massimo 255 caratteri.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica formato indirizzo
	 */
	@Test
	public void validaIndirizzo_Formato() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma#Antonio 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo indirizzo deve contenere soltanto caratteri alfanumerici e segni di punteggiatura.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica che il campo telefono non sia null
	 */
	@Test
	public void validaTelefono_Null() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = null;
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo telefono non può essere nullo.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}
	
	/**
	 * verifica lunghezza minima telefono
	 */
	@Test
	public void validaTelefono_Min_Lunghezza() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-35";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo telefono deve contenere almeno 10 caratteri.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica lunghezza massima telefono
	 */
	@Test
	public void validaTelefono_Max_Lunghezza() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-35444445446469";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo telefono deve contenere al massimo 11 caratteri.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica formato telefono
	 */
	@Test
	public void validaTelefono_Formato() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3BB4541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo telefono deve contenere soltanto caratteri numerici, al più le prime tre cifre possono essere separate da un trattino.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica che il campo data di nascita non sia null
	 */
	@Test
	public void validaDataNascita_Null() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = null;
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo data di nascita non può essere nullo.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}
	/**
	 * verifica correttezza data di nascita
	 */
	@Test
	public void validaDataNascita_SottoRange() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1800-12-01");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "La data di nascita non rientra nel range consento " + Studente.MIN_DATE.getDayOfMonth()
				+ "/" + Studente.MIN_DATE.getMonthValue() + "/" + Studente.MIN_DATE.getYear() + " - "
				+ Studente.MAX_DATE.getDayOfMonth() + "/" + Studente.MAX_DATE.getMonthValue() + "/"
				+ Studente.MAX_DATE.getYear() + ".";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}
	
	/**
	 * verifica correttezza data di nascita
	 */
	@Test
	public void validaDataNascita_SopraRange() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.now().minusYears(10L);
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "La data di nascita non rientra nel range consento " + Studente.MIN_DATE.getDayOfMonth()
				+ "/" + Studente.MIN_DATE.getMonthValue() + "/" + Studente.MIN_DATE.getYear() + " - "
				+ Studente.MAX_DATE.getDayOfMonth() + "/" + Studente.MAX_DATE.getMonthValue() + "/"
				+ Studente.MAX_DATE.getYear() + ".";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica che il campo matricola non sia null
	 */
	@Test
	public void validaMatricola_Null() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = null;
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo matricola non può essere nullo.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}
	/**
	 * verifica lunghezza matricola
	 */
	@Test
	public void validaMatricola_Lunghezza() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo matricola deve contenere 10 caratteri.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica formato matricola
	 */
	@Test
	public void validaMatricola_Formato() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "A512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo matricola deve contenere solo caratteri numerici.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica che il campo sesso non sia null
	 */
	@Test
	public void validaSesso_Null() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = null;
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo sesso non può essere nullo.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}
	/**
	 * verifica carattere sesso
	 */
	@Test
	public void validaSesso_Formato() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "A";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo sesso deve essere valorizzato con un solo carattere tra M o F.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 *  verifica che il campo email non sia null 
	 */
	@Test
	public void validaEmail_Null() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = null;
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo e-mail non può essere nullo.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}
	/**
	 *  verifica lunghezza minima email
	 */
	@Test
	public void validaEmail_Min_Lunghezza() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo e-mail deve contenere almeno 2 caratteri.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica lunghezza massima email
	 */
	@Test
	public void validaEmail_Max_Lunghezza() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo e-mail deve contenere al massimo 256 caratteri.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica formato email
	 */
	@Test
	public void validaEmail_Formato() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.r*ossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo e-mail non rispetta il formato stabilito.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica se la email sia già presente nel db
	 */
	@Test
	public void validaEmail_Esistenza() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "p.bianchi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(true);

		final String message = "l'e-mail inserita è già presente.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica che il campo password non sia null
	 */
	@Test
	public void validaPassword_Null() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = null;
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo password non può essere nullo.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}
	/**
	 * verifica lunghezza minima password
	 */
	@Test
	public void validaPassword_Min_Lughezza() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Pw#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo password deve contenere almeno 8 caratteri.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica lunghezza massima password
	 */
	@Test
	public void validaPassword_Max_Lughezza() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "PasswordPasswordPassword#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo password deve contenere al massimo 24 caratteri.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica formato password
	 */
	@Test
	public void validaPassword_Formato() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Pass   word#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo password deve contenere almeno"
				+ "un numero, almeno una lettera e non deve contenere spazi.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica che il campo conferma password non sia null
	 */
	@Test
	public void validaConfermaPassword_Null() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = null;
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo conferma password non può essere nullo.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}
	/**
	 * verifica lunghezza minima conferma password
	 */
	@Test
	public void validaConfermaPassword_Min_Lunghezza() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Pw#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo password e il campo conferma password non corrispondono.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica lunghezza massima conferma password
	 */
	@Test
	public void validaConfermaPassword_Max_Lunghezza() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "PasswordPasswordPassword#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo password e il campo conferma password non corrispondono.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica formato conferma password
	 */
	@Test
	public void validaConfermaPassword_Formato() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Pass  word#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo password e il campo conferma password non corrispondono.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica corrispondenza password e conferma password
	 */
	@Test
	public void validaConfermaPassword_Corrispondenza() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Passwordd#1";
		String condizioni = "on";

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "Il campo password e il campo conferma password non corrispondono.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * verifica accettazione condizioni privacy
	 */
	@Test
	public void verificaCondizioni() {

		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = null;

		when(utenteRepository.existsByEmail(email)).thenReturn(false);

		final String message = "È obbligatorio accettare le condizioni sulla privacy.";

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (RichiestaIscrizioneNonValidaException exception) {
			assertEquals(message, exception.getMessage());
		}
	}

	/**
	 * caso di successo
	 */
	@Test
	public void salvaRichiestaIscrizione() {
	
		String nome = "Mario";
		String cognome = "Rossi";
		String indirizzo = "Via Roma 4 84080 Salerno SA";
		String telefono = "333-3544541";
		LocalDate dataNascita = LocalDate.parse("1997-12-24");
		String matricola = "0512105144";
		String sesso = "M";
		String email = "m.rossi@studenti.unisa.it";
		String password = "Password#1";
		String confermaPassword = "Password#1";
		String condizioni = "on";
		
		
		
		when(utenteRepository.existsByEmail(email)).thenReturn(false);
		

		try {
			richiestaIscrizioneService.validaNome(nome);
			richiestaIscrizioneService.validaCognome(cognome);
			richiestaIscrizioneService.validaIndirizzo(indirizzo);
			richiestaIscrizioneService.validaTelefono(telefono);
			richiestaIscrizioneService.validaDataNascita(dataNascita);
			richiestaIscrizioneService.validaMatricola(matricola);
			richiestaIscrizioneService.validaSesso(sesso);
			richiestaIscrizioneService.validaEmail(email);
			richiestaIscrizioneService.validaPassword(password);
			richiestaIscrizioneService.validaConfermaPassword(password, confermaPassword);
			richiestaIscrizioneService.validaCondizioni(condizioni);

			Studente studente = new Studente(nome, cognome, indirizzo, telefono, email, matricola, sesso, dataNascita,
					password);
			
			
			when(richiestaIscrizioneRepository.save(any(RichiestaIscrizione.class))).thenReturn(null);
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
			
			//verifica che il metodo save del mock venga invocato almeno una volta
			verify(richiestaIscrizioneRepository, times(1)).save(any(RichiestaIscrizione.class)); 
			
		} catch (RichiestaIscrizioneNonValidaException exception) {
			exception.printStackTrace();

		}
	}

	/**
	 * verifica correttezza metodo accettaRichiestaIscrizione
	 */
	@Test
	public void accettaRichiestaIscrizione() {
		RichiestaIscrizione richiestaiscrizione= new RichiestaIscrizione();
		when(richiestaIscrizioneRepository.findById(12L)).thenReturn(richiestaiscrizione);
		when(richiestaIscrizioneRepository.save(richiestaiscrizione)).thenReturn(richiestaiscrizione);
		richiestaIscrizioneService.accettaRichiestaIscrizione(12L);
		verify(richiestaIscrizioneRepository, times(1)).save(any(RichiestaIscrizione.class)); 
}

	/**
	 * verifica correttezza metodo rifiutaRichiestaIscrizione
	 */
	@Test
	public void rifiutaRichiestaIscrizione() {
		RichiestaIscrizione richiestaiscrizione= new RichiestaIscrizione();
		when(richiestaIscrizioneRepository.findById(10L)).thenReturn(richiestaiscrizione);
		when(richiestaIscrizioneRepository.save(richiestaiscrizione)).thenReturn(richiestaiscrizione);
		richiestaIscrizioneService.rifiutaRichiestaIscrizione(10L);
		verify(richiestaIscrizioneRepository, times(1)).save(any(RichiestaIscrizione.class)); 
}

}