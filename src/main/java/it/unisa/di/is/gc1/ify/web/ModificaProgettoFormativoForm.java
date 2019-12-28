package it.unisa.di.is.gc1.ify.web;

/**
 * Oggetto utilizzato per mappare i campi di un form di un progetto formativo. Questo oggetto
 * viene passato come parametro al controller dalla dispatcher servlet quando un delegato aziendale 
 * sottomette il modulo di modifica di un progetto formativo.
 * 
 * @author Benedetta Coccaro
 */

public class ModificaProgettoFormativoForm {

	public ModificaProgettoFormativoForm() {
		
	}
	
	
	public ModificaProgettoFormativoForm(String descrizione, String conoscenze, String maxPartecipanti) {
		super();
		this.descrizione = descrizione;
		this.conoscenze = conoscenze;
		this.maxPartecipanti = maxPartecipanti;
	}

	


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public String getConoscenze() {
		return conoscenze;
	}


	public void setConoscenze(String conoscenze) {
		this.conoscenze = conoscenze;
	}


	public String getMaxPartecipanti() {
		return maxPartecipanti;
	}


	public void setMaxPartecipanti(String maxPartecipanti) {
		this.maxPartecipanti = maxPartecipanti;
	}



	private String descrizione;
	private String conoscenze;
	private String maxPartecipanti;
	
	
	
	
}
