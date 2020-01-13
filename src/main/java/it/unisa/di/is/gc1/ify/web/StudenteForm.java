package it.unisa.di.is.gc1.ify.web;

import java.time.LocalDate;

/**
 * Oggetto utilizzato per mappare i campi di un form di uno studente. Questo oggetto
 * viene passato come parametro al controller dalla dispatcher servlet quando un utente 
 * sottomette il modulo di registrazione.
 * 
 * @author Giusy Castaldo, Alessia Natale
 */
public class StudenteForm {
	
	public StudenteForm() {
		
	}
	
	
	
	public StudenteForm(String nome, String cognome, String indirizzo, String telefono, String dataNascita,
			String sesso, String matricola, String email, String password, String confermaPsw, String condizioni) {
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.dataNascita = dataNascita;
		this.sesso = sesso;
		this.matricola = matricola;
		this.email = email.toLowerCase();
		this.password = password;
		this.confermaPsw = confermaPsw;
		this.condizioni = condizioni;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public LocalDate getDataNascita() {
		if(this.dataNascita.equals("")) return null;
		
		LocalDate tmp = LocalDate.parse(this.dataNascita);
		return tmp;
	}
	
	
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public String getEmail() {
		return email.toLowerCase();
	}
	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfermaPsw() {
		return confermaPsw;
	}
	public void setConfermaPsw(String confermaPsw) {
		this.confermaPsw = confermaPsw;
	}
	public String getCondizioni() {
		return condizioni;
	}
	public void setCondizioni(String condizioni) {
		this.condizioni = condizioni;
	}
	

	private String nome;
	private String cognome;
	private String indirizzo;
	private String telefono;
	private String dataNascita;
	private String sesso;
	private String matricola;
	private String email;
	private String password;
	private String confermaPsw;
	private String condizioni;
}



