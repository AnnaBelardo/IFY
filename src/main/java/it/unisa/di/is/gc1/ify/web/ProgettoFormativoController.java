package it.unisa.di.is.gc1.ify.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.unisa.di.is.gc1.ify.Studente.OperazioneNonAutorizzataException;
import it.unisa.di.is.gc1.ify.Studente.RichiestaIscrizione;
import it.unisa.di.is.gc1.ify.convenzioni.DelegatoAziendale;
import it.unisa.di.is.gc1.ify.progettoFormativo.ProgettoFormativo;
import it.unisa.di.is.gc1.ify.progettoFormativo.ProgettoFormativoService;
import it.unisa.di.is.gc1.ify.responsabileUfficioTirocini.ResponsabileUfficioTirocini;
import it.unisa.di.is.gc1.ify.utenza.Utente;
import it.unisa.di.is.gc1.ify.utenza.UtenzaService;

/**
 * Controller per la gestione dei progetti formativi
 * 
 * @author Simone Civale Carmine Ferrara
 *
 */

@Controller
public class ProgettoFormativoController {
	
	@Autowired
	UtenzaService utenzaService;
	
	@Autowired
	ProgettoFormativoService progettoFormativoService;
	
	/**
	 * Metodo per inserire un nuovo progetto formativo
	 * 
	 * @param model
	 * @return String stringa che rapprestenta la pagina da visualizzare
	 */
	@RequestMapping(value = "/nuovoProgettoFormativo", method = RequestMethod.GET)
	public String nuovoProgettoFormativo(Model model) {
		Utente utente = utenzaService.getUtenteAutenticato();

		if (utente instanceof DelegatoAziendale) {			

			return "inserimentoProgettoFormativo";
		} else
			return "/";
	}
	
	/**
	 * Metodo per archiviare un progetto formativo attivo
	 * 
	 * @param model
	 * @param id
	 * @return String stringa che rappresenta la pagina da visualizzare
	 */
	@RequestMapping(value = "/archiviaProgettoFormativo", method = RequestMethod.POST)
	public String archiviaProgettoFormativo(@RequestParam("idProgettoFormativo") long id, Model model, RedirectAttributes redirectAttribute) {

		ProgettoFormativo progettoFormativo;
		try {
			progettoFormativo = progettoFormativoService.riattivazioneProgettoFormativo(id);
			model.addAttribute("progettoFormativoArchiviato", progettoFormativo);
		} catch (OperazioneNonAutorizzataException e) {
			System.out.println(e.getMessage());
			
			return "redirect:/";
		}
		
		redirectAttribute.addFlashAttribute("message", "Il progetto formativo " + progettoFormativo.getNome() + 
				" è stato archiviato con successo");
		return "redirect:/visualizzaProgettiFormativiAttivi";
	}
	
	/**
	 * Metodo per riattivare un progetto formativo archiviato
	 * 
	 * @param model
	 * @param id
	 * @return String stringa che rappresenta la pagina da visualizzare
	 */
	@RequestMapping(value = "/riattivaProgettoFormativo", method = RequestMethod.POST)
	public String riattivaProgettoFormativo(@RequestParam("idProgettoFormativo") long id, Model model, RedirectAttributes redirectAttribute) {

		ProgettoFormativo progettoFormativo;
		try {
			progettoFormativo = progettoFormativoService.riattivazioneProgettoFormativo(id);
			model.addAttribute("progettoFormativoRiattivato", progettoFormativo);
		} catch (OperazioneNonAutorizzataException e) {
			System.out.println(e.getMessage());
			
			return "redirect:/";
		}
		
		redirectAttribute.addFlashAttribute("message", "Il progetto formativo " + progettoFormativo.getNome() + 
				" è stato riattivato con successo");
		return "redirect:/visualizzaProgettiFormativiArchiviati";
	}
	
	/**
	 * Metodo per visualizzare la lista dei progetti formativi attivi
	 * 
	 * @param model
	 * @return String stringa che rapprestenta la pagina da visualizzare
	 */
	@RequestMapping(value = "/progettiFormativiAttivi", method = RequestMethod.GET)
	public String visualizzaProgettiFormativiAttivi(Model model) {
		Utente utente = utenzaService.getUtenteAutenticato();

		if (utente instanceof DelegatoAziendale) {

			try {
				DelegatoAziendale delegatoAziendale=(DelegatoAziendale) utente;
				List<ProgettoFormativo> progettiFormativi = progettoFormativoService.visualizzaProgettiFormativiAttiviByAzienda(delegatoAziendale.getAzienda().getpIva());
				model.addAttribute("progettiFormativiAttivi", progettiFormativi);
			} catch (OperazioneNonAutorizzataException e) {
				System.out.println(e.getMessage());
				return "redirect:/";
			}

			return "visualizzaProgettiFormativiAttivi";
		} else
			return "/";
	}
	
	/**
	 * Metodo per visualizzare la lista dei progetti formativi archiviati
	 * 
	 * @param model
	 * @return String stringa che rapprestenta la pagina da visualizzare
	 */
	@RequestMapping(value = "/progettiFormativiArchiviati", method = RequestMethod.GET)
	public String visualizzaProgettiFormativiArchiviati(Model model) {
		Utente utente = utenzaService.getUtenteAutenticato();

		if (utente instanceof DelegatoAziendale) {

			try {
				DelegatoAziendale delegatoAziendale=(DelegatoAziendale) utente;
				List<ProgettoFormativo> progettiFormativi = progettoFormativoService.visualizzaProgettiFormativiArchiviatiByAzienda(delegatoAziendale.getAzienda().getpIva());
				model.addAttribute("progettiFormativiArchiviati", progettiFormativi);
			} catch (OperazioneNonAutorizzataException e) {
				System.out.println(e.getMessage());
				return "redirect:/";
			}

			return "visualizzaProgettiFormativiArchiviati";
		} else
			return "/";
	}
	
}
