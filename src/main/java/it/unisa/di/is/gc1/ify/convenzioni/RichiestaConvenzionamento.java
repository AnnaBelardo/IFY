package it.unisa.di.is.gc1.ify.convenzioni;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Classe che modella i singoli dati di una richiesta di convenzionamento
 * @author Carmine Ferrara
 */
public class RichiestaConvenzionamento {
	
	
	/**costruttore vuoto utile per il set dei dati con i setter
	 * 
	 */
	public RichiestaConvenzionamento() {
		super();
	}
	
	/**costruttore con parametri utile per i casi di test
	 * 
	 * @param id
	 * @param stato
	 * @param azienda
	 */
	public RichiestaConvenzionamento(long id, String stato, Azienda azienda) {
		super();
		this.id = id;
		this.stato = stato;
		this.azienda = azienda;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	private long id;
	private String stato;
	@OneToOne(cascade = CascadeType.ALL)
	private Azienda azienda;
	
	/**
	 * Costante che rappresenta lo stato "in attesa" di una richiesta di convenzionamento.
	 * Una richiesta si trova in questo stato quando non è ancora stata valutata.
	 */
	public static final String IN_ATTESA = "in attesa";

	/**
	 * Costante che rappresenta lo stato "accettata" di una richiesta di convenzionamento.
	 * Una richiesta si trova in questo stato quando è stata accettata dal
	 * responsabile ufficio tirocini.
	 */
	public static final String ACCETTATA = "accettata";

	/**
	 * Costante che rappresenta lo stato "rifiutata" di una richiesta di convenzionamento.
	 * Una richiesta si trova in questo stato quando è stata rifiutata dal
	 * responsabile ufficio tirocini.
	 */
	public static final String RIFIUTATA = "rifiutata";
}
