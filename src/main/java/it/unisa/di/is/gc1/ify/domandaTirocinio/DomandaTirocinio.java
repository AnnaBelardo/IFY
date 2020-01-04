package it.unisa.di.is.gc1.ify.domandaTirocinio;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import it.unisa.di.is.gc1.ify.Studente.Studente;
import it.unisa.di.is.gc1.ify.convenzioni.Azienda;
import it.unisa.di.is.gc1.ify.progettoFormativo.ProgettoFormativo;

/**
 * 
 * @author Geremia Cavezza
 *
 * Classe che modella una domanda di tirocinio
 */

@Entity
public class DomandaTirocinio {
	
	public DomandaTirocinio() {
		
	}
	
	public DomandaTirocinio(long id, String conoscenze, String motivazioni, LocalDate dataInizio, LocalDate dataFine,
			int cfu, String stato, ProgettoFormativo progettoFormativo, Azienda azienda, Studente studente) {
		super();
		this.id = id;
		this.conoscenze = conoscenze;
		this.motivazioni = motivazioni;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.cfu = cfu;
		this.stato = stato;
		this.progettoFormativo = progettoFormativo;
		this.azienda = azienda;
		this.studente = studente;
	}
	
	public long getId() {
		return id;
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
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}

	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public ProgettoFormativo getProgettoFormativo() {
		return progettoFormativo;
	}

	public void setProgettoFormativo(ProgettoFormativo progettoFormativo) {
		this.progettoFormativo = progettoFormativo;
	}

	public Azienda getAzienda() {
		return azienda;
	}

	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}

	public Studente getStudente() {
		return studente;
	}

	public void setStudente(Studente studente) {
		this.studente = studente;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String conoscenze;
	private String motivazioni;
	private LocalDate dataInizio;
	private LocalDate dataFine;
	private int cfu;
	private String stato;
	@ManyToOne
	private ProgettoFormativo progettoFormativo;	
	@ManyToOne
	private Azienda azienda;
	@ManyToOne
	private Studente studente;
	
	/**
	 * Costante che rappresenta lo stato "in attesa" di una domanda di tirocinio.
	 * Una domanda si trova in questo stato quando non è ancora stata valutata.
	 */
	public static final String IN_ATTESA = "in attesa";

	/**
	 * Costante che rappresenta lo stato "accettata" di una domanda di tirocinio.
	 * Una domanda si trova in questo stato quando è stata accettata dal delegato aziendale.
	 */
	public static final String ACCETTATA = "accettata";

	/**
	 * Costante che rappresenta lo stato "rifiutata" di una domanda di tirocinio.
	 * Una domanda si trova in questo stato quando è stata rifiutata dal delegato aziendale.
	 */
	public static final String RIFIUTATA = "rifiutata";
	
	/**
	 * Costante che rappresenta lo stato "approvata" di una domanda di tirocinio.
	 * Una domanda si trova in questo stato quando è stata approvata dal responsabile ufficio tirocini.
	 */
	public static final String APPROVATA = "approvata";

	/**
	 * Costante che rappresenta lo stato "respinta" di una domanda di tirocinio.
	 * Una domanda si trova in questo stato quando è stata respinta dal responsabile ufficio tirocini.
	 */
	public static final String RESPINTA = "respinta";	
		
	/**
	 * Costante che definisce la minima lunghezza del campo conoscenze.
	 */	
	public static final int MIN_LUNGHEZZA_CONOSCENZE = 1;
	
	/**
	 * Costante che definisce la massima lunghezza del campo conoscenze.
	 */
	public static final int MAX_LUNGHEZZA_CONOSCENZE  = 200;
	
	/**
	 * Costante che definisce la minima lunghezza del campo motivazioni.
	 */	
	public static final int MIN_LUNGHEZZA_MOTIVAZIONI = 1;
	
	/**
	 * Costante che definisce la massima lunghezza del campo motivazioni.
	 */
	public static final int MAX_LUNGHEZZA_MOTIVAZIONI  = 300;
	
	/** Valore che definisce la minima data di inizio accettabile. */
	public static final LocalDate MIN_DATE_INIZIO = LocalDate.now();

	/** Valore che definisce la minima data di fine accettabile. */
	public static final LocalDate MIN_DATE_FINE = MIN_DATE_INIZIO;
	
	/**
	 * Costante che definisce il minimo numero di cfu.
	 */	
	public static final int MIN_CFU = 6;
	
	/**
	 * Costante che definisce il massimo numero di cfu.	 */
	public static final int MAX_CFU  = 12;
}
