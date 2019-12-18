package it.unisa.di.is.gc1.ify.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



/**
 * Controller per la gestione dell'utenza
 * @author Carmine Ferrara
 */
@Controller
public class UtenzaController {
	
	/**
	 * Metodo per la visualizzazione dell'homepage
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String visualizzaHome(Model model) {
		
		return "homepage";
	  }
	
	
}
