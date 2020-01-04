package it.unisa.di.is.gc1.ify.web;

import java.time.LocalDate;

/**
 * Oggetto utilizzato per mappare i campi di un form di una domanda di tirocinio. Questo oggetto
 * viene passato come parametro al controller dalla dispatcher servlet quando un utente 
 * sottomette il modulo d'invio di una domanda di tirocinio.
 * 
 * @author Benedetta Coccaro
 */

public class DomandaTirocinioForm {
	
	public DomandaTirocinioForm() {
		
	}
	
	public DomandaTirocinioForm(String conoscenze, String motivazioni, String dataInizio, String dataFine,
			String numeroCFU, String condizioni) {
		super();
		this.conoscenze = conoscenze;
		this.motivazioni = motivazioni;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.numeroCFU = numeroCFU;
		this.condizioni = condizioni;
	}
	
	
	
	public String getConoscenze() {
		return conoscenze;
	}

	public void setConoscenze(String conoscenze) {
		this.conoscenze = conoscenze;
	}

	public String getMotivazioni() {
		return motivazioni;
	}

	public void setMotivazioni(String motivazioni) {
		this.motivazioni = motivazioni;
	}
	
	public LocalDate getDataInizio() {
		if(this.dataInizio.equals("")) return null;
		
		LocalDate tmp = LocalDate.parse(this.dataInizio);
		return tmp;
	}
	
	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}
	
	public LocalDate getDataFine() {
		if(this.dataFine.equals("")) return null;
		
		LocalDate tmp = LocalDate.parse(this.dataFine);
		return tmp;
	}
	
	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}

	public String getNumeroCFU() {
		return numeroCFU;
	}

	public void setNumeroCFU(String numeroCFU) {
		this.numeroCFU = numeroCFU;
	}

	public String getCondizioni() {
		return condizioni;
	}

	public void setCondizioni(String condizioni) {
		this.condizioni = condizioni;
	}
	
	
	private String conoscenze;
	private String motivazioni;
	private String dataInizio;
	private String dataFine;
	private String numeroCFU;
	private String condizioni;
	
	
	
}
