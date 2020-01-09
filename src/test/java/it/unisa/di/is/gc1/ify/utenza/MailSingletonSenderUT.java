package it.unisa.di.is.gc1.ify.utenza;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import it.unisa.di.is.gc1.ify.Studente.RichiestaIscrizione;
import it.unisa.di.is.gc1.ify.Studente.Studente;

/**
 * Test di unità per la classe MailSingletonSender ; tipologia di test: whitebox
 * metodologia: branch coverage.  
 * @author Giacomo Izzo
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MailSingletonSenderUT {

	
	@Mock 
	private JavaMailSender javaMailSender;
	@InjectMocks
	private MailSingletonSender mailSender;
	
	@Captor 
	ArgumentCaptor<String> captor;
	
	@Mock
	private RichiestaIscrizione richiesta;
	
	@Mock
	private Studente studente;

	/**
	 * Testa il caso in cui l'oggetto passato al metodo sendEmal non sia un 
	 * istanza di RichiestaIscrizione.
	 * 
	 * @test {@link MailSingletonSender#sendMail(Object,String)}
	 * 
	 * @result Il test e superato se la ricerca delle matricole deglis studenti
	 *         presenti nella lista utilizzata per il test ha successo
	 */
	@Test
	public void message_Not_Instance() {
		String destinatario = "m.rossi@studenti.unisa.it";
		Object object = new Object(); 
		
		mailSender.sendEmail(object, destinatario);
		verify(javaMailSender, times(1)).send(any(SimpleMailMessage.class));
	
	}
	
	/**
	 * Testa il caso in cui la richiesta sia stata accettata.
	 * 
	 * @test {@link MailSingletonSender#sendMail(Object,String)}
	 * 
	 * @result Il test e superato se la ricerca delle matricole deglis studenti
	 *         presenti nella lista utilizzata per il test ha successo
	 */
	@Test
	public void message_Acettata() {
	
		String destinatario = "m.rossi@studenti.unisa.it"; 
		
		when(richiesta.getStato()).thenReturn(RichiestaIscrizione.ACCETTATA);
		when(richiesta.getStudente()).thenReturn(studente);
		when(studente.getNome()).thenReturn("Mario");
		when(studente.getCognome()).thenReturn("Rossi");
		
		mailSender.sendEmail(richiesta, destinatario);
		verify(javaMailSender, times(1)).send(any(SimpleMailMessage.class));

	
	}
	
	/**
	 * Testa il caso in cui la richiesta sia stata rifiutata.
	 * 
	 * @test {@link MailSingletonSender#sendMail(Object,String)}
	 * 
	 * @result Il test e superato se la ricerca delle matricole deglis studenti
	 *         presenti nella lista utilizzata per il test ha successo
	 */
	@Test
	public void message_Rifiutata() {
		
		String destinatario = "m.rossi@studenti.unisa.it"; 
		
		when(richiesta.getStato()).thenReturn(RichiestaIscrizione.RIFIUTATA);
		when(richiesta.getStudente()).thenReturn(studente);
		when(studente.getNome()).thenReturn("Mario");
		when(studente.getCognome()).thenReturn("Rossi");
		
		mailSender.sendEmail(richiesta, destinatario);
		verify(javaMailSender, times(1)).send(any(SimpleMailMessage.class));

	
	} 
	
}
