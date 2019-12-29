package it.unisa.di.is.gc1.ify.utenza;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * 
 * @author Geremia Cavezza
 *
 * Classe astratta che modella un utente generico registrato
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Utente {
	
	public Utente() {
		
	}
	
	
	
	public Utente(String nome, String cognome, String sesso, String email, String indirizzo, String password) {
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.email = email;
		this.indirizzo = indirizzo;
		this.password = password;
	}



	public long getId() {
		return id;
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
	
	public String getSesso() {
		return sesso;
	}
	
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	protected String nome;
	protected String cognome;
	protected String sesso;
	@Column(unique=true)
	protected String email;
	protected String indirizzo;
	protected String password;
	
	  /** Espressione regolare che definisce il formato del campo nome. */
	  public static final String NOME_PATTERN = "^[a-z A-Zàéèìòù]{2,255}$";
	  
	  /** Espressione regolare che definisce il formato del campo cognome. */
	  public static final String COGNOME_PATTERN = "^[a-z A-Zàéèìòù]{2,255}$";
	  
	  /** Costante che rappresenta il genere maschile per l'utente. */
	  public static final String SESSO_PATTERN = "^[MF]{1}$";
	  
	 
	  /** Espressione regolare che definisce il formato del campo email. */
	  public static final String EMAIL_PATTERN = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/"
	                                           + "=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f"
	                                           + "\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x"
	                                           + "0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-"
	                                           + "9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25["
	                                           + "0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2"
	                                           + "[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\"
	                                           + "x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]"
	                                           + "|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
	  
	  /** Espressione regolare che definisce il formato del campo indirizzo. */
	  public static final String INDIRIZZO_PATTERN = "^[a-z A-Z 0-9 àéèìòù ',.-]{2,255}$";
	  
	  /** Espressione regolare che definisce il formato del campo password. */
	  public static final String PASSWORD_PATTERN = "^(?=([^\\s])*[0-9])(?=([^\\s])*[a-zA-Z])([^\\s]){8,24}$";
	  
	  /** Costante che definisce la minima lunghezza dei campi nome, cognome , indirizzo. */
	  public static final int MIN_LUNGHEZZA_CAMPO = 2;
	  
	  /** Costante che definisce la massima lunghezza dei campi nome, cognome e indirizzo. */
	  public static final int MAX_LUNGHEZZA_CAMPO = 255;
	  
	  /** Costante che definisce la massima lunghezza del campo mail. */
	  public static final int MAX_LUNGHEZZA_MAIL = 256;
	  
	  /** Costante che definisce la minima lunghezza dei campo password. */
	  public static final int MIN_LUNGHEZZA_PASSWORD = 8;
	  
	  /** Costante che definisce la massima lunghezza dei campo password. */
	  public static final int MAX_LUNGHEZZA_PASSWORD = 24;
	  
	 
}
