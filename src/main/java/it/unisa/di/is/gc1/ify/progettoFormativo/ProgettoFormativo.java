package it.unisa.di.is.gc1.ify.progettoFormativo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import it.unisa.di.is.gc1.ify.convenzioni.Azienda;

/**
 * Classe che modella i singoli dati di un progetto formativo aziendale
 * @author Carmine Ferrara
 */
@Entity
public class ProgettoFormativo {
	
	/**costruttore vuoto utile per il set dei dati con i setter
	 * 
	 */
	public ProgettoFormativo() {
		super();
	}
	
	/**costruttore con parametri utile per i casi di test
	 * 
	 * @param nome
	 * @param descrizione
	 * @param ambito
	 * @param attivita
	 * @param conoscenze
	 * @param max_partecipanti
	 * @param data_compilazione
	 * @param stato
	 * @param azienda
	 */
	public ProgettoFormativo(String nome, String descrizione, String ambito, String attivita, String conoscenze,
			int max_partecipanti, LocalDate data_compilazione, String stato, Azienda azienda) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
		this.ambito = ambito;
		this.attivita = attivita;
		this.conoscenze = conoscenze;
		this.max_partecipanti = max_partecipanti;
		this.data_compilazione = data_compilazione;
		this.stato = stato;
		this.azienda = azienda;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getMax_partecipanti() {
		return max_partecipanti;
	}

	public void setMax_partecipanti(int max_partecipanti) {
		this.max_partecipanti = max_partecipanti;
	}

	public LocalDate getData_compilazione() {
		return data_compilazione;
	}

	public void setData_compilazione(LocalDate data_compilazione) {
		this.data_compilazione = data_compilazione;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Azienda getAzienda() {
		return azienda;
	}

	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}


	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String descrizione;
	private String ambito;
	private String attivita;
	private String conoscenze;
	private int max_partecipanti;
	private LocalDate data_compilazione;
	private String stato;
	@ManyToOne
	private Azienda azienda;
	
	
	/**
	 * Costante che rappresenta lo stato "attivo" di un progetto formativo aziendale.
	 * Un progetto formativo si trova in questo stato al momento della creazione
	 * oppure può essere riportato in tale stato a discrezione dell'azienda.
	 */
	public static final String ATTIVO = "attivo";

	/**
	 * Costante che rappresenta lo stato "archiviato" di un progetto formativo aziendale.
	 * Un progetto formativo si trova in questo stato quando è stato archiviato dall'azienda.
	 */
	public static final String ARCHIVIATO = "archiviato";
	
	/** Espressione regolare che definisce il formato del campo nome del progetto formativo. */
	public static final String NOME_PATTERN = "^[A-Z a-z 0-9 àèéìòù ‘,-:]{2,255}$";
	  
	
	/** Espressione regolare che definisce il formato del campo ambito del progetto formativo. */
	public static final String AMBITO_PATTERN = "^[A-Z a-z 0-9 àèéìòù ‘,-:]{2,255}$";
	
	
	/** Espressione regolare che definisce il formato del campo max_partecipanti del progetto formativo. */
	public static final String MAX_PARTECIPANTI_PATTERN = "^[0-9]{1,3}$";
	
	/**
	 * Costante che definisce la minima lunghezza dei campi nome, ambito del progetto formativo.
	 */
	public static final int MIN_LUNGHEZZA_CAMPO = 2;

	/**
	 * Costante che definisce la massima lunghezza dei campo nome, ambido del progetto formativo.
	 */
	public static final int MAX_LUNGHEZZA_CAMPO = 255;
	
	/**
	 * Costante che definisce la minima lunghezza del campo descrizione del progetto formativo.
	 */
	public static final int MIN_LUNGHEZZA_DESCRIZIONE = 2;

	/**
	 * Costante che definisce la massima lunghezza del campo descrizione del progetto formativo.
	 */
	public static final int MAX_LUNGHEZZA_DESCRIZIONE = 800;
	
	
	/**
	 * Costante che definisce la minima lunghezza del campo attività del progetto formativo.
	 */
	public static final int MIN_LUNGHEZZA_ATTIVITA = 2;

	/**
	 * Costante che definisce la massima lunghezza del campo attivita del progetto formativo.
	 */
	public static final int MAX_LUNGHEZZA_ATTIVITA = 500;

	/**
	 * Costante che definisce la minima lunghezza del campo conoscenze del progetto formativo.
	 */
	public static final int MIN_LUNGHEZZA_CONOSCENZE = 2;

	/**
	 * Costante che definisce la massima lunghezza del campo conoscenze del progetto formativo.
	 */
	public static final int MAX_LUNGHEZZA_CONOSCENZE = 500;
	
	/**
	 * Costante che definisce il valore minimo del campo max_partecipanti del progetto formativo.
	 */
	public static final int MIN_VAL_MAX_PARTECIPANTI = 1;
	
	/**
	 * Costante che definisce il valore massimo del campo max_partecipanti del progetto formativo.
	 */
	public static final int MAX_VAL_MAX_PARTECIPANTI = 999;
}
