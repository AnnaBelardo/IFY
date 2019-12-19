package it.unisa.di.is.gc1.ify.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.unisa.di.is.gc1.ify.Studente.RichiestaIscrizioneService;
import it.unisa.di.is.gc1.ify.Studente.Studente;

/**
 * 
 * @author Giusy Castaldo Alessia Natale
 *
 */
@Controller
public class StudenteController {
	
	@Autowired
	private RichiestaIscrizioneService richiestaIscrizioneService;
	
	@Autowired
	private StudenteFormValidator studenteFormValidator;
	
	@RequestMapping(value = "/richiestaIscrizione", method = RequestMethod.POST)
	public String invioRichiestaIscrizione(@ModelAttribute("studenteForm") StudenteForm studenteForm,
			BindingResult result, RedirectAttributes redirectAttribute, Model model) {
		
		studenteFormValidator.validate(studenteForm, result);
		if(result.hasErrors()) {
			//se ci sono errori il metodo controller setta tutti i parametri 
			
			redirectAttribute.addFlashAttribute("studenteForm", studenteForm);
			
			for(ObjectError x: result.getGlobalErrors()) {
				redirectAttribute.addFlashAttribute(x.getCode(), x.getDefaultMessage());
				System.out.println(x.getCode());
			}
			
			return "redirect:/prova";
		}
		
		Studente studente = new Studente();
		studente.setNome(studenteForm.getNome());
		studente.setCognome(studenteForm.getCognome());
		studente.setIndirizzo(studenteForm.getIndirizzo());
		studente.setTelefono(studenteForm.getTelefono());
		studente.setDataNascita(studenteForm.getDataNascita());
		studente.setSesso(studenteForm.getSesso());
		studente.setMatricola(studenteForm.getMatricola());
		studente.setEmail(studenteForm.getEmail());
		studente.setPassword(studenteForm.getPassword());
		
		try {
			richiestaIscrizioneService.salvaRichiestaIscrizione(studente);
		} catch (Exception e) {
			return "redirect:/";
		}
		
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/prova", method = RequestMethod.GET)
	public String prova(Model model) {

		return "/RichiestaIscrizione";
	}
	
}