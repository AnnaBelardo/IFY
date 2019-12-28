package it.unisa.di.is.gc1.ify.web;

/**
 * Oggetto utilizzato per mappare i campi di un form di un progetto formativo. Questo oggetto
 * viene passato come parametro al controller dalla dispatcher servlet quando un delegato aziendale 
 * sottomette il modulo di inserimento di un progetto formativo.
 * 
 * @author Benedetta Coccaro
 */

public class InserimentoProgettoFormativoForm {

	public InserimentoProgettoFormativoForm() {
		
	}
	
	
	public InserimentoProgettoFormativoForm(String nome, String descrizione, String ambito, String attivita,
			String conoscenze, String maxPartecipanti) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
		this.ambito = ambito;
		this.attivita = attivita;
		this.conoscenze = conoscenze;
		this.maxPartecipanti = maxPartecipanti;
	}

	

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public String getAmbito() {
		return ambito;
	}


	public void setAmbito(String ambito) {
		this.ambito = ambito;
	}


	public String getAttivita() {
		return attivita;
	}


	public void setAttivita(String attivita) {
		this.attivita = attivita;
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


	

	private String nome;
	private String descrizione;
	private String ambito;
	private String attivita;
	private String conoscenze;
	private String maxPartecipanti;
	
	
	
	
}
