package it.unisa.di.is.gc1.ify.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



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
	public String visualizzaLibri(Model model) {
		
		return "homepage";
	  }
}
