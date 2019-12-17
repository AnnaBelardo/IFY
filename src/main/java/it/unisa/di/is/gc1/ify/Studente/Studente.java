package it.unisa.di.is.gc1.ify.Studente;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import it.unisa.di.is.gc1.ify.domandaTirocinio.DomandaTirocinio;
import it.unisa.di.is.gc1.ify.utenza.Utente;

/**
 * 
 * @author Geremia Cavezza
 *
 * Classe che modella uno studente
 */

@Entity
public class Studente extends Utente{
	
	/**
	 * Costruisce un oggetto Studente vuoto che deve essere popolato con i metodi setters.
	 */
	public Studente() {
		this.domandeTirocinio = new ArrayList<DomandaTirocinio>();
	}
	
	
	
	
	public Studente(String nome, String cognome, String sesso, String email, String indirizzo, String password, String matricola, LocalDate dataNascita, String telefono) {
		super(nome,  cognome,  sesso,  email,  indirizzo,  password);
		this.matricola = matricola;
		this.dataNascita = dataNascita;
		this.telefono = telefono;
		this.domandeTirocinio = new ArrayList<DomandaTirocinio>();
	}




	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<DomandaTirocinio> getDomandeTirocinio() {
		return domandeTirocinio;
	}

	public void setDomandeTirocinio(List<DomandaTirocinio> domandeTirocinio) {
		this.domandeTirocinio = domandeTirocinio;
	}
	
	@Column(unique=true)
	private String matricola;
	private LocalDate dataNascita;
	private String telefono;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "studente")
	private List<DomandaTirocinio> domandeTirocinio;
	
	  /** Espressione regolare che definisce il formato del campo matricola. */
	  public static final String MATRICOLA_PATTERN = "^[0-9]{10}$";
	  
	  /** Espressione regolare che definisce il formato del campo telefono. */
	  public static final String TELEFONO_PATTERN = "^[0-9]{3}[\\-]?[0-9]{7}$";
	 	  
	 /**Espressione regolare che definisce il formato del campo Email Studente*/
	  public static final String EMAIL_STUDENTE_PATTERN = "^([a-z].[a-z]+[1-9]?[0-9]*)@studenti.unisa.it$";
	  
	  /** Valore che definisce la minima data di nascita accettabile. */
	  public static final LocalDate MIN_DATE = LocalDate.of(1900, Month.JANUARY, 1);
	  
	  /** Valore che definisce la massima data di nascita accettabile. */
	  public static final LocalDate MAX_DATE = LocalDate.now().minusYears(19L);
}
