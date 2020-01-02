package it.unisa.di.is.gc1.ify.web;


/**
 * Oggetto utilizzato per mappare i campi di un form di azienda e delegato. Questo oggetto
 * viene passato come parametro al controller dalla dispatcher servlet quando un utente 
 * sottomette il modulo di convenzionamento.
 * 
 * @author Geremia Cavezza
 */

public class ConvenzioneForm {
	
	public ConvenzioneForm() {
		
	}

	public ConvenzioneForm(String nome, String cognome, String indirizzo, String sesso, String ruolo, String email,
			String password, String confermaPassword, String condizioniDelegato, String ragioneSociale, String sede,
			String pIva, String settore, String descrizione, String condizioniAzienda) {
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.sesso = sesso;
		this.ruolo = ruolo;
		this.email = email;
		this.password = password;
		this.confermaPassword = confermaPassword;
		this.condizioniDelegato = condizioniDelegato;
		this.ragioneSociale = ragioneSociale;
		this.sede = sede;
		this.pIva = pIva;
		this.settore = settore;
		this.descrizione = descrizione;
		this.condizioniAzienda = condizioniAzienda;
	}	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfermaPassword() {
		return confermaPassword;
	}
	public void setConfermaPassword(String confermaPassword) {
		this.confermaPassword = confermaPassword;
	}
	public String getCondizioniDelegato() {
		return condizioniDelegato;
	}
	public void setCondizioniDelegato(String condizioniDelegato) {
		this.condizioniDelegato = condizioniDelegato;
	}
	public String getRagioneSociale() {
		return ragioneSociale;
	}
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public String getpIva() {
		return pIva;
	}
	public void setpIva(String pIva) {
		this.pIva = pIva;
	}
	public String getSettore() {
		return settore;
	}
	public void setSettore(String settore) {
		this.settore = settore;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getCondizioniAzienda() {
		return condizioniAzienda;
	}
	public void setCondizioniAzienda(String condizioniAzienda) {
		this.condizioniAzienda = condizioniAzienda;
	}

	private String nome;
	private String cognome;
	private String indirizzo;
	private String sesso;
	private String ruolo;
	private String email;
	private String password;
	private String confermaPassword;
	private String condizioniDelegato;
	
	private String ragioneSociale;
	private String sede;
	private String pIva;
	private String settore;
	private String descrizione;
	private String condizioniAzienda;
}
