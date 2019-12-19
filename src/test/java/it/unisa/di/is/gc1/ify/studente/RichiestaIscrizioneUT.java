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
	 * Verifica lunghezza minima del nome
	 */
	@Test
	public void tc_gu_1_1() {

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
	public void tc_gu_1_2() {

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
	public void tc_gu_1_3() {

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
	 * verifica lunghezza minima cognome
	 */
	@Test
	public void tc_gu_1_4() {

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
	public void tc_gu_1_5() {

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
	public void tc_gu_1_6() {

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

	/**verifica lunghezza minima indirizzo
	 * 
	 */
	@Test
	public void tc_gu_1_7() {

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
	public void tc_gu_1_8() {

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
	public void tc_gu_1_9() {

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
	 * verifica lunghezza minima telefono
	 */
	@Test
	public void tc_gu_1_10() {

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
	public void tc_gu_1_11() {

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
	public void tc_gu_1_12() {

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
	 * verifica correttezza data di nascita
	 */
	@Test
	public void tc_gu_1_13() {

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
	 * verifica lunghezza matricola
	 */
	@Test
	public void tc_gu_1_14() {

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
	public void tc_gu_1_15() {

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
	 * verifica carattere sesso
	 */
	@Test
	public void tc_gu_1_16() {

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
	 *  verifica lunghezza minima email
	 */
	@Test
	public void tc_gu_1_17() {

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
	public void tc_gu_1_18() {

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
	public void tc_gu_1_19() {

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
	 * verifica se la mail sia già presente nel db
	 */
	@Test
	public void tc_gu_1_20() {

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
	 * verifica lunghezza minima password
	 */
	@Test
	public void tc_gu_1_21() {

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
	public void tc_gu_1_22() {

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
	public void tc_gu_1_23() {

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
	 * verifica lunghezza minima conferma password
	 */
	@Test
	public void tc_gu_1_24() {

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
	public void tc_gu_1_25() {

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
	public void tc_gu_1_26() {

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
	public void tc_gu_1_27() {

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
	public void tc_gu_1_28() {

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
	public void tc_gu_1_29() {

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
}
