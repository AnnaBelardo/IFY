package it.unisa.di.is.gc1.ify.studente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import it.unisa.di.is.gc1.ify.Studente.RichiestaIscrizione;
import it.unisa.di.is.gc1.ify.Studente.RichiestaIscrizioneService;
import it.unisa.di.is.gc1.ify.Studente.Studente;

/**
 * Classe di test d'integrazione RichiestaIscrizioneRepository - (StudenteRepository - Richiesta iscrizione repository 
 * UtenteRepository 
 * @author Carmine Ferrara - Giacomo Izzo -  Geremia Cavezza
 */

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback
public class ServiceRichiestaIscrizioneRepositoriesIT {
	
	
	@Autowired
	private RichiestaIscrizioneService richiestaIscrizioneService;
	
	
	
	private Studente studente;
	private RichiestaIscrizione richiestaIscrizione;
	
	@Test
	public void salvaRichiestaIscrizione() {
		
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
		
		richiestaIscrizione = richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		
		
		assertNotNull(richiestaIscrizione);
		
	}
	
	@Test
	public void accettaRichiestaIscrizione() {
		
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
		
		richiestaIscrizione = richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		richiestaIscrizione = richiestaIscrizioneService.accettaRichiestaIscrizione(richiestaIscrizione.getId());
		
		assertEquals(RichiestaIscrizione.ACCETTATA, richiestaIscrizione.getStato());
		
	}
	
	@Test
	public void rifiutaRichiestaIscrizione() {
		
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
		
		richiestaIscrizione = richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		richiestaIscrizione = richiestaIscrizioneService.rifiutaRichiestaIscrizione(richiestaIscrizione.getId());
		
		assertEquals(RichiestaIscrizione.RIFIUTATA, richiestaIscrizione.getStato());
		
	}
}
