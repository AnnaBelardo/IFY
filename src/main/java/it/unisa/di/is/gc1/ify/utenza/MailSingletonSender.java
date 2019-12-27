package it.unisa.di.is.gc1.ify.utenza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import it.unisa.di.is.gc1.ify.Studente.RichiestaIscrizione;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * Classe singleton che permette di inviare una email informativa all'utente 
 * quando si è verificato un cambiamento di stato.
 * 
 * @author Alessia Natale, Benedetta Coccaro
 */

@Component
@Scope("singleton")
public class MailSingletonSender  {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	/**
	 * Metodo che permette di inviare una email 
	 * @param object Object che rappresenta l'oggetto coinvolto ai cambiamenti
	 * @param destinatario String che rappresenta l'email del destinatario
	 */
	public void sendEmail(Object object, String destinatario) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(destinatario);

        msg.setSubject("Info piattaforma IFY");
        String message = message(object);
        msg.setText(message);

        javaMailSender.send(msg);

    }
	
	/**
	 * Metodo che ritorna la stringa contenente il messaggio informativo
	 * destinato all'utente
	 * @param obj Object che rappresenta l'oggetto coinvolto ai cambiamenti
	 * @return String contenente il messaggio
	 */
	private String message(Object obj) {
		if(obj instanceof RichiestaIscrizione) {
			RichiestaIscrizione richiestaIscrizione = (RichiestaIscrizione) obj;
			String stato = richiestaIscrizione.getStato();
			String nome = richiestaIscrizione.getStudente().getNome();
			String cognome = richiestaIscrizione.getStudente().getCognome();
			if(stato == RichiestaIscrizione.ACCETTATA)
				return "Gentile " + nome + "" + cognome + " la informiamo che la sua richiesta di iscrizione alla piattaforma IFY è stata "+ 
				stato + ". Cordiali saluti, l'Ufficio Tirocini.";
			else if(stato == RichiestaIscrizione.RIFIUTATA)
				return "Gentile " + nome + "" + cognome + "la informiamo che la sua richiesta di iscrizione alla piattaforma IFY è stata "+ 
				stato + ". La invitiamo a riprovare. Cordiali saluti, l'Ufficio Tirocini";
		}
		return "";
	}

}
