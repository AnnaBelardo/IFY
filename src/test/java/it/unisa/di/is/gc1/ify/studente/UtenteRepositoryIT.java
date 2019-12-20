
package it.unisa.di.is.gc1.ify.studente;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import it.unisa.di.is.gc1.ify.Studente.Studente;
import it.unisa.di.is.gc1.ify.Studente.StudenteRepository;
import it.unisa.di.is.gc1.ify.utenza.Utente;
import it.unisa.di.is.gc1.ify.utenza.UtenteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@Rollback
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UtenteRepositoryIT{

	@Autowired
	private StudenteRepository studenteRepository;
	
	@Autowired
	private UtenteRepository utenteRepository;

	private Studente studente;

	/**
	 * Salva un utente su database prima dell'esecuzione di ogni singolo
	 * test.
	 */
	@Before
	public void salvaUtente() {		
		// Crea un utente
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

		studente = studenteRepository.save(studente);		  
		studenteRepository.flush();
	}
	
	/**
	 * Testa l'interazione con il database per determinare se la ricerca di un
	 * utente tramite email e password avvenga correttamente.
	 * 
	 * @test {Utente#findByEmailAndPassword(String, String)}
	 * 
	 * @result Il test Ã¨ superato se la ricerca della coppia email e password
	 * dell' utente utilizzato per il test ha successo
	 */
	
	@Test
	public void testFindByEmailAndPassword() {
		Studente studente1 = new Studente();
		
		studente1 = (Studente)utenteRepository.findByEmailAndPassword(studente.getEmail(), studente.getPassword());
		assertThat(studente1, is(equalTo(studente)));
		//tearDown();		
	}

	/**
	 * Testa l'interazione con il database per determinare se la ricerca di un
	 * utente tramite email avvenga correttamente.
	 * 
	 * @test {@link boolean#existsByEmail(String)}
	 * 
	 * @result Il test Ã¨ superato se la ricerca della email dell' utente
	 * utilizzato per il test ha successo
	 */
	
	  @Test
	  public void existsByEmail() {
	    // Controlla che un utente sia registrato su database ricercandolo per matricola
		  boolean studenteEsistente = utenteRepository.existsByEmail(studente.getEmail());
	      assertThat(studenteEsistente, is(true));
	      //tearDown();	
	   }
		
	  public void tearDown() {	
		  studenteRepository.delete(studente);
	  }

}