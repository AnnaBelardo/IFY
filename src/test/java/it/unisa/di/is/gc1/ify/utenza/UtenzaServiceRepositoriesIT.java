package it.unisa.di.is.gc1.ify.utenza;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import it.unisa.di.is.gc1.ify.Studente.Studente;

/**
* Classe di test d'integrazione UtenzaService: testa l'integrazione delle componenti
* UtenzaService, UtenteRepository e AutenticazioneHolder.
*
* @author Geremia Cavezza , Giacomo Izzo
*/

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback
public class UtenzaServiceRepositoriesIT {
	
	@Autowired
	private UtenzaService utenzaService;
	
	@Autowired
	private UtenteRepository utenteRepository;	
	
	private Studente studente;
	private Utente utente;
	
	/**
	 * Testa il metodo validaMail() , nel caso in cui la mail passata sia null.
	 * 
	 * @test {@link UtenzaService#validaMail(String)}
	 * 
	 * @result Il test e superato se l'eccezione generata dal metodo è la
	 * stessa prevista dall'oracolo.
	 */
	@Test
	public void validaMail_Null() {
		
		final String message = "Email non valida";

		try {
			utenzaService.validaMail(null);
		} catch (MailNonValidaException | MailEsistenteException e) {
			assertEquals(message, e.getMessage());
		}
	}
	
	/**
	 * Testa il metodo validaMail() , nel caso in cui la mail passata 
	 * non rispetti il pattern consentito.
	 * 
	 * @test {@link UtenzaService#validaMail(String)}
	 * 
	 * @result Il test e superato se l'eccezione generata dal metodo è la
	 * stessa prevista dall'oracolo.
	 */
	@Test
	public void validaMail_NoPattern() {
		
		final String message = "Email non valida";

		try {
			utenzaService.validaMail("mr@gmail");
		} catch (MailNonValidaException | MailEsistenteException e) {
			assertEquals(message, e.getMessage());
		}
	}
	
	/**
	 * Testa il metodo validaMail() , nel caso in cui la mail passata 
	 * sia già presente nel database.
	 * 
	 * @test {@link UtenzaService#validaMail(String)}
	 * 
	 * @result Il test e superato se l'eccezione generata dal metodo è la
	 * stessa prevista dall'oracolo.
	 */
	@Test
	public void validaMail_Exists() {
		
		final String message = "Email già presente";
		
		studente = new Studente();
		
		studente.setNome("Mario");
		studente.setCognome("Rossi");
		studente.setDataNascita(LocalDate.of(1997, 12, 24));
		studente.setEmail("m.rossi@studenti.unisa.it");
		studente.setIndirizzo("Via Roma 4 84080 Salerno SA");
		studente.setMatricola("0512105144");
		studente.setTelefono("333-3544541");
		studente.setSesso("M");
		studente.setPassword("Password#1");
		
		try {
			utenzaService.validaMail(studente.getEmail());
		} catch (MailNonValidaException | MailEsistenteException e) {
			assertEquals(message, e.getMessage());
		}
	}
	
	/**
	 * Testa il metodo validaMail() , nel caso in cui la mail passata 
	 * sia corretta.
	 * 
	 * @test {@link UtenzaService#validaMail(String)}
	 * 
	 * @result Il test e superato se l'eccezione generata dal metodo è la
	 * stessa prevista dall'oracolo.
	 */
	@Test
	public void validaMail_Successo() {
		
		studente = new Studente();
		
		studente.setNome("Mario");
		studente.setCognome("Rossi");
		studente.setDataNascita(LocalDate.of(1997, 12, 24));
		studente.setEmail("m.rossi@studenti.unisa.it");
		studente.setIndirizzo("Via Roma 4 84080 Salerno SA");
		studente.setMatricola("0512105144");
		studente.setTelefono("333-3544541");
		studente.setSesso("M");
		studente.setPassword("Password#1");
		
		utente = utenteRepository.save(studente);
		
		String email=null;
		try {
			email = utenzaService.validaMail(utente.getEmail());
		} catch (MailNonValidaException | MailEsistenteException e) {
			e.printStackTrace();
		}
		assertEquals(email, studente.getEmail());
	}

	/**
	 * Testa il metodo getUtenteAutenticato() , nel caso in cui non ci sia 
	 * nessun utente autenticato. .
	 * 
	 * @test {@link UtenzaService#getUtenteAutenticato()}
	 * 
	 * @result Il test e superato se l'oggetto restituito dal metodo è lo stesso
	 * di quello che si usa per il test.
	 */
	@Test
	public void getUtenteAutenticato_Null() {
		
		AutenticazioneHolder.setUtente(null);
		
		assertEquals(utenzaService.getUtenteAutenticato(), null);
	}
	
	/**
	 * Testa il metodo getUtenteAutenticato() , nel caso in cui l'utente non esista nel
	 * database.
	 * 
	 * @test {@link UtenzaService#getUtenteAutenticato()}
	 * 
	 * @result Il test e superato se l'oggetto restituito dal metodo è lo stesso
	 * di quello che si usa per il test.
	 */
	@Test
	public void getUtenteAutenticato_NotExists() {
		
		studente = new Studente();
		
		studente.setNome("Mario");
		studente.setCognome("Rossi");
		studente.setDataNascita(LocalDate.of(1997, 12, 24));
		studente.setEmail("m.rossi@studenti.unisa.it");
		studente.setIndirizzo("Via Roma 4 84080 Salerno SA");
		studente.setMatricola("0512105144");
		studente.setTelefono("333-3544541");
		studente.setSesso("M");
		studente.setPassword("Password#1");
		
		utenteRepository.delete(studente);
		
		AutenticazioneHolder.setUtente(studente.getEmail());
		
		assertEquals(utenzaService.getUtenteAutenticato(), null);		
	}
	
	/**
	 * Testa il metodo getUtenteAutenticato() , nel caso in cui esista un utente 
	 * autenticato.
	 * 
	 * @test {@link UtenzaService#getUtenteAutenticato()}
	 * 
	 * @result Il test e superato se l'oggetto restituito dal metodo è lo stesso
	 * di quello che si usa per il test.
	 */
	@Test
	public void getUtenteAutenticato_Successo() {
		
		studente = new Studente();
		
		studente.setNome("Mario");
		studente.setCognome("Rossi");
		studente.setDataNascita(LocalDate.of(1997, 12, 24));
		studente.setEmail("m.rossi@studenti.unisa.it");
		studente.setIndirizzo("Via Roma 4 84080 Salerno SA");
		studente.setMatricola("0512105144");
		studente.setTelefono("333-3544541");
		studente.setSesso("M");
		studente.setPassword("Password#1");
	
		AutenticazioneHolder.setUtente(studente.getEmail());
		utenteRepository.save(studente);
		
		assertThat(studente, is(equalTo(utenzaService.getUtenteAutenticato())));

	}
	
	/**
	 * Testa il metodo setUtenteAutenticato() , nel caso in cui venga settato un 
	 * utente null.
	 * 
	 * @test {@link UtenzaService#setUtenteAutenticato(String)}
	 * 
	 * @result Il test e superato se l'oggetto restituito dal metodo è lo stesso
	 * di quello che si usa per il test.
	 */
	@Test
	public void setUtenteAutenticato_Null() {
		utenzaService.setUtenteAutenticato(null);
		assertEquals(AutenticazioneHolder.getUtente(), null);
	}

	/**
	 * Testa il metodo setUtenteAutenticato() , nel caso in cui venga settato un 
	 * utente non esistente nel database.
	 * 
	 * @test {@link UtenzaService#setUtenteAutenticato(String)}
	 * 
	 * @result Il test e superato se l'oggetto restituito dal metodo è lo stesso
	 * di quello che si usa per il test.
	 */
	@Test
	public void setUtenteAutenticato_NotExists() {
		
		studente = new Studente();
		
		studente.setNome("Mario");
		studente.setCognome("Rossi");
		studente.setDataNascita(LocalDate.of(1997, 12, 24));
		studente.setEmail("m.rossi@studenti.unisa.it");
		studente.setIndirizzo("Via Roma 4 84080 Salerno SA");
		studente.setMatricola("0512105144");
		studente.setTelefono("333-3544541");
		studente.setSesso("M");
		studente.setPassword("Password#1");

		utenzaService.setUtenteAutenticato(studente.getEmail());
		assertEquals(utenzaService.getUtenteAutenticato(), null);
	}
	
	/**
	 * Testa il metodo setUtenteAutenticato() , nel caso in cui l'utente settato 
	 * esiste ed è correttamente autenticato.
	 * 
	 * @test {@link UtenzaService#setUtenteAutenticato(String)}
	 * 
	 * @result Il test e superato se l'oggetto restituito dal metodo è lo stesso
	 * di quello che si usa per il test.
	 */
	@Test
	public void setUtenteAutenticato_Exists() {
		
		studente = new Studente();
		
		studente.setNome("Mario");
		studente.setCognome("Rossi");
		studente.setDataNascita(LocalDate.of(1997, 12, 24));
		studente.setEmail("m.rossi@studenti.unisa.it");
		studente.setIndirizzo("Via Roma 4 84080 Salerno SA");
		studente.setMatricola("0512105144");
		studente.setTelefono("333-3544541");
		studente.setSesso("M");
		studente.setPassword("Password#1");
		
		utente = utenteRepository.save(studente);
		
		AutenticazioneHolder.setUtente(null);
		utenzaService.setUtenteAutenticato(utente.getEmail());
		assertEquals(AutenticazioneHolder.getUtente(), utente.getEmail());
	}

	/**
	 * Testa il metodo login() , nel caso in cui il login non vada a buon fine.
	 * 
	 * @test {@link UtenzaService#login(String,String)}
	 * 
	 * @result Il test e superato se l'eccezione generata dal metodo è la stessa 
	 * prevista dall'oracolo.
	 */
	@Test
	public void login_Fail() {	
		
		studente = new Studente();
		
		studente.setNome("Mario");
		studente.setCognome("Rossi");
		studente.setDataNascita(LocalDate.of(1997, 12, 24));
		studente.setEmail("m.rossi@studenti.unisa.it");
		studente.setIndirizzo("Via Roma 4 84080 Salerno SA");
		studente.setMatricola("0512105144");
		studente.setTelefono("333-3544541");
		studente.setSesso("M");
		studente.setPassword("Password#1");
		
		utenteRepository.delete(studente);

		final String message = "Credenziali non valide";	
		
		try {
			utenzaService.login(studente.getEmail(), studente.getPassword());
		} catch (CredenzialiNonValideException e) {
			assertEquals(message, e.getMessage());
		}
		
	}

	/**
	 * Testa il metodo login() , nel caso in cui il login vada a buon fine.
	 * 
	 * @test {@link UtenzaService#login(String,String)}
	 * 
	 * @result Il test e superato se il login viene effettuato con successo.
	 */
	@Test
	public void login_Successo() {
		
		studente = new Studente();
		
		studente.setNome("Mario");
		studente.setCognome("Rossi");
		studente.setDataNascita(LocalDate.of(1997, 12, 24));
		studente.setEmail("m.rossi@studenti.unisa.it");
		studente.setIndirizzo("Via Roma 4 84080 Salerno SA");
		studente.setMatricola("0512105144");
		studente.setTelefono("333-3544541");
		studente.setSesso("M");
		studente.setPassword("Password#1");
		
		utenteRepository.save(studente);
		System.out.println(utenteRepository.count());
		
		try {
			utente = utenzaService.login(studente.getEmail(), studente.getPassword());
		} catch (CredenzialiNonValideException e) {
			e.printStackTrace();
		}
		assertThat(studente, is(equalTo(utente)));
	}
	
	/**
	 * Testa il metodo logout() , nel caso in cui il logout vada a buon fine.
	 * 
	 * @test {@link UtenzaService#logout()}
	 * 
	 * @result Il test e superato se il logout è effettuato con successo.
	 */
	@Test
	public void logout() {
		
		studente = new Studente();
		
		studente.setNome("Mario");
		studente.setCognome("Rossi");
		studente.setDataNascita(LocalDate.of(1997, 12, 24));
		studente.setEmail("m.rossi@studenti.unisa.it");
		studente.setIndirizzo("Via Roma 4 84080 Salerno SA");
		studente.setMatricola("0512105144");
		studente.setTelefono("333-3544541");
		studente.setSesso("M");
		studente.setPassword("Password#1");
		
		utente = utenteRepository.save(studente);
		
		AutenticazioneHolder.setUtente(utente.getEmail());
		utenzaService.logout();
		assertEquals(AutenticazioneHolder.getUtente(), null);
	}

}
