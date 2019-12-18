package it.unisa.di.is.gc1.ify.web;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import it.unisa.di.is.gc1.ify.Studente.RichiestaIscrizioneNonValidaException;
import it.unisa.di.is.gc1.ify.Studente.RichiestaIscrizioneService;

/**
 * Classe che definisce un validatore per {@link StudenteForm} tramite i servizi offerti da 
 * {@link RichiestaIscrizioneService}. Il controllo effettuato riguarda la validità dei campi
 * definiti nell'entità Studente. 
 * 
 * @see StudenteForm 
 * @see RichiestaIscrizioneService
 * 
 * @author Giusy Castaldo, Alessia Natale
 *
 */
@Component
public class StudenteFormValidator implements Validator {

	@Autowired
	private RichiestaIscrizioneService richiestaIscrizioneService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return StudenteForm.class.isAssignableFrom(clazz);
	}
	
	/**
	 * Effettua la validazione dell'oggetto target riportando gli errori nell'oggetto errors.
	 * 
	 * @param target Oggetto da validare
	 * @param errors Oggetto in cui salvare l'esito della validazione
	 */
	@Override
	public void validate(Object target, Errors errors) {
		StudenteForm form = (StudenteForm) target;
		try {
			richiestaIscrizioneService.validaRichiestaIscrizione(form);
		} catch (RichiestaIscrizioneNonValidaException e ) {
			errors.reject("richiestaIscrizione",e.getMessage());
		}
		
	}

}
