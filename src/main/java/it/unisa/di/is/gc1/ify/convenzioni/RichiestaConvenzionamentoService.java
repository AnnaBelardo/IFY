package it.unisa.di.is.gc1.ify.convenzioni;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unisa.di.is.gc1.ify.Studente.OperazioneNonAutorizzataException;
import it.unisa.di.is.gc1.ify.responsabileUfficioTirocini.ResponsabileUfficioTirocini;
import it.unisa.di.is.gc1.ify.utenza.MailSingletonSender;
import it.unisa.di.is.gc1.ify.utenza.Utente;
import it.unisa.di.is.gc1.ify.utenza.UtenteRepository;
import it.unisa.di.is.gc1.ify.utenza.UtenzaService;

/**
 * La classe fornisce i metodi per la logica di business delle richieste di convenzionamento
 * 
 * @author Alessia Natale, Giacomo Izzo
 */

@Service
public class RichiestaConvenzionamentoService {
	
	@Autowired
	private UtenteRepository utenteRepository;
	
	@Autowired
	private AziendaRepository aziendaRepository;
	
	@Autowired
	private DelegatoAziendaleRepository delegatoAziendaleRepository;
	
	@Autowired
	private RichiestaConvenzionamentoRepository richiestaConvenzionamentoRepository;
	
	@Autowired
	private UtenzaService utenzaService;
	
	@Autowired
	private MailSingletonSender mailSingletonSender;
	
	/**
	 * Il metodo fornisce la funzionalità di salvataggio di un delegato aziendale e di
	 * un'azienda con la relativa richiesta di convenzionamento posta in stato di attesa
	 * @param azienda, delegatoAziendale
	 * 
	 * @return RichiestaConvenzionamento richiestaConvenzionamento
	 * @pre azienda != null
	 * @pre delegatoAziendale != null
	 * @post richiestaConvenzionamento != null
	 */
	
	@Transactional(rollbackFor = Exception.class)
	public RichiestaConvenzionamento salvaRichiestaConvenzionamento(Azienda azienda, DelegatoAziendale delegatoAziendale) {
		RichiestaConvenzionamento richiestaConvenzionamento = new RichiestaConvenzionamento(RichiestaConvenzionamento.IN_ATTESA, azienda, delegatoAziendale);
		
		azienda = aziendaRepository.save(azienda);
		delegatoAziendale = delegatoAziendaleRepository.save(delegatoAziendale);
		richiestaConvenzionamento = richiestaConvenzionamentoRepository.save(richiestaConvenzionamento);
		
		return richiestaConvenzionamento;
	}
	
	/**
	 * Il metodo fornisce la funzionalità di accettazione di una richiesta di convenzionamento
	 * 
	 * 
	 * @param idRichiesta
	 * @return Oggetto {@link RichiestaConvenzionamento} che rappresenta la richiesta di convenzionamento.
	 */
	
	@Transactional(rollbackFor = Exception.class)
	public RichiestaConvenzionamento accettaRichiestaConvenzionamento(Long idRichiesta)
			throws OperazioneNonAutorizzataException {
		
		Utente utente = utenzaService.getUtenteAutenticato();
		
		//Solo il responsabile ufficio tirocini può accettare una richiesta di convenzionamento
		if(!(utente instanceof ResponsabileUfficioTirocini)) {
			throw new OperazioneNonAutorizzataException();
		}
		
		RichiestaConvenzionamento richiestaConvenzionamento = richiestaConvenzionamentoRepository.findById(idRichiesta);
		
		if(!richiestaConvenzionamento.getStato().equals(RichiestaConvenzionamento.IN_ATTESA)) {
			throw new OperazioneNonAutorizzataException("Impossibile accettare questa richiesta");
		}
		
		richiestaConvenzionamento.setStato(RichiestaConvenzionamento.ACCETTATA);
		richiestaConvenzionamento = richiestaConvenzionamentoRepository.save(richiestaConvenzionamento);
		
		mailSingletonSender.sendEmail(richiestaConvenzionamento, richiestaConvenzionamento.getDelegatoAziendale().getEmail());
		
		return richiestaConvenzionamento;
	}
	
	 	/** 
		 * Il metodo fornisce la funzionalità di rifiuto di una richiesta di convenzionamento
		 * 
		 * @param idRichiesta
		 * @return Oggetto {@link RichiestaConvenzionamento} che rappresenta la richiesta di convenzionamento.
		 */
		@Transactional(rollbackFor = Exception.class)
		public RichiestaConvenzionamento rifiutaRichiestaConvenzionamento(Long idRichiesta) 
				throws OperazioneNonAutorizzataException {
			
			Utente utente = utenzaService.getUtenteAutenticato();
			
			//Solo il responsabile ufficio tirocini può rifiutare una richiesta di convenzionamento
			if(!(utente instanceof ResponsabileUfficioTirocini)) {
				throw new OperazioneNonAutorizzataException();
			}
			
			RichiestaConvenzionamento richiestaConvenzionamento = richiestaConvenzionamentoRepository.findById(idRichiesta);
			
			if(!richiestaConvenzionamento.getStato().equals(RichiestaConvenzionamento.IN_ATTESA)) {
				throw new OperazioneNonAutorizzataException("Impossibile rifiutare questa richiesta");
			}
			
			richiestaConvenzionamento.setStato(RichiestaConvenzionamento.RIFIUTATA);
			richiestaConvenzionamento = richiestaConvenzionamentoRepository.save(richiestaConvenzionamento);
			
			mailSingletonSender.sendEmail(richiestaConvenzionamento, richiestaConvenzionamento.getDelegatoAziendale().getEmail());
			
			richiestaConvenzionamentoRepository.delete(richiestaConvenzionamento);
			
			return richiestaConvenzionamento;
		}
		
		/** 
		 * Il metodo fornisce la funzionalità di visualizzazione delle richieste di convenzionamento
		 * in attesa e relativi dettagli
		 * 
		 * @return Lista di {@link RichiestaConvenzionamento} che rappresenta la lista delle
		 *         richieste di convenzionamento <b>Può essere vuota</b> se nel database non
		 *         sono presenti richieste di iscrizione in attesa
		 */
		@Transactional(rollbackFor = Exception.class)
		public List<RichiestaConvenzionamento> visualizzaRichiesteConvenzionamentoDettagli() 
				throws OperazioneNonAutorizzataException {
			
			Utente utente = utenzaService.getUtenteAutenticato();
			
			//Solo il responsabile ufficio tirocini può visualizzare le richieste di convenzionamento
			if(!(utente instanceof ResponsabileUfficioTirocini)) {
				throw new OperazioneNonAutorizzataException();
			}
			
			List<RichiestaConvenzionamento> richiestaConvenzionamento = richiestaConvenzionamentoRepository.findAllByStato(RichiestaConvenzionamento.IN_ATTESA);

			return richiestaConvenzionamento;
		}
		
		
		/** 
		 * Il metodo ritorna lo stato della richiesta di convenzionamento
		 * 
		 * @param email
		 * @return String stringa che rappresenta lo stato della richiesta di convenzionamento
		 */
		@Transactional(rollbackFor = Exception.class)
		public String getStatoRichiestaByEmail(String email) {
			return richiestaConvenzionamentoRepository.findByDelegatoAziendaleEmail(email).getStato();
		}
		
		/**
		 * Il metodo fornisce i controlli di validazione del parametro nome di un generico delegato aziendale
		 * @param nome
		 * @return nome
		 * @throws RichiestaConvenzionamentoNonValidaException
		 */
		public String validaNome(String nome) throws RichiestaConvenzionamentoNonValidaException {
			
			if (nome == null)
				throw new RichiestaConvenzionamentoNonValidaException("NomeError", "Il campo nome non può essere nullo.");

			if (nome.length() < DelegatoAziendale.MIN_LUNGHEZZA_CAMPO)
				throw new RichiestaConvenzionamentoNonValidaException("NomeError", "Il campo nome deve contenere almeno 2 caratteri.");

			if (nome.length() > DelegatoAziendale.MAX_LUNGHEZZA_CAMPO)
				throw new RichiestaConvenzionamentoNonValidaException("NomeError", "Il campo nome deve contenere al massimo 255 caratteri.");

			if (!nome.matches(DelegatoAziendale.NOME_PATTERN))
				throw new RichiestaConvenzionamentoNonValidaException("NomeError", "Il campo nome deve contenere soltanto caratteri alfabetici.");
			return nome;
		}
		
		/**
		 * Il metodo fornisce i controlli di validazione del parametro cognome di un generico delegato aziendale
		 * @param cognome
		 * @return cognome
		 * @throws RichiestaConvenzionamentoNonValidaException
		 */
		public String validaCognome(String cognome) throws RichiestaConvenzionamentoNonValidaException {
			
			if (cognome == null)
				throw new RichiestaConvenzionamentoNonValidaException("CognomeError", "Il campo cognome non può essere nullo.");

			if (cognome.length() < DelegatoAziendale.MIN_LUNGHEZZA_CAMPO)
				throw new RichiestaConvenzionamentoNonValidaException("CognomeError", "Il campo nome deve contenere almeno 2 caratteri.");

			if (cognome.length() > DelegatoAziendale.MAX_LUNGHEZZA_CAMPO)
				throw new RichiestaConvenzionamentoNonValidaException("CognomeError", "Il campo nome deve contenere al massimo 255 caratteri.");

			if (!cognome.matches(DelegatoAziendale.COGNOME_PATTERN))
				throw new RichiestaConvenzionamentoNonValidaException("CognomeError", "Il campo nome deve contenere soltanto caratteri alfabetici.");
			return cognome;
		}
		
		/**
		 * Il metodo fornisce i controlli di validazione del parametro sesso di un generico delegato aziendale
		 * @param sesso
		 * @return sesso
		 * @throws RichiestaConvenzionamentoNonValidaException
		 */
		public String validaSesso(String sesso) throws RichiestaConvenzionamentoNonValidaException {
			
			if (sesso == null)
				throw new RichiestaConvenzionamentoNonValidaException("SessoError", "Effettuare una selezione per il campo Sesso.");

			if (!sesso.matches(DelegatoAziendale.SESSO_PATTERN))
				throw new RichiestaConvenzionamentoNonValidaException("SessoError", "Il campo sesso deve essere valorizzato con un solo carattere tra M o F.");
			return sesso;
		}
		
		/**
		 * Il metodo fornisce i controlli di validazione del parametro ruolo di un generico delegato aziendale
		 * @param ruolo
		 * @return ruolo
		 * @throws RichiestaConvenzionamentoNonValidaException
		 */
		public String validaRuolo(String ruolo) throws RichiestaConvenzionamentoNonValidaException {
			
			if (ruolo == null)
				throw new RichiestaConvenzionamentoNonValidaException("RuoloError", "Il campo ruolo non può essere nullo.");

			if (ruolo.length() < DelegatoAziendale.MIN_LUNGHEZZA_CAMPO)
				throw new RichiestaConvenzionamentoNonValidaException("RuoloError", "Il campo ruolo deve contenere almeno 2 caratteri.");

			if (ruolo.length() > DelegatoAziendale.MAX_LUNGHEZZA_CAMPO)
				throw new RichiestaConvenzionamentoNonValidaException("RuoloError", "Il campo ruolo deve contenere al massimo 255 caratteri.");

			if (!ruolo.matches(DelegatoAziendale.RUOLO_PATTERN))
				throw new RichiestaConvenzionamentoNonValidaException("RuoloError", "Il campo ruolo deve contenere soltanto caratteri alfabetici.");
			return ruolo;
		}
		
		/**
		 * Il metodo fornisce i controlli di validazione del parametro email di un generico delegato aziendale
		 * @param email
		 * @return email
		 * @throws RichiestaConvenzionamentoNonValidaException
		 */
		public String validaEmail(String email) throws RichiestaConvenzionamentoNonValidaException {
			
			if (email == null)
				throw new RichiestaConvenzionamentoNonValidaException("EmailError", "Il campo email non può essere nullo.");

			if (email.length() < DelegatoAziendale.MIN_LUNGHEZZA_CAMPO)
				throw new RichiestaConvenzionamentoNonValidaException("EmailError", "Il campo email deve contenere almeno 2 caratteri.");

			if (email.length() > DelegatoAziendale.MAX_LUNGHEZZA_MAIL)
				throw new RichiestaConvenzionamentoNonValidaException("EmailError", "Il campo email deve contenere al massimo 256 caratteri.");

			if (!email.matches(DelegatoAziendale.EMAIL_PATTERN))
				throw new RichiestaConvenzionamentoNonValidaException("EmailError", "Il campo email deve rispettare il formato.");
			
			if (utenteRepository.existsByEmail(email))
				throw new RichiestaConvenzionamentoNonValidaException("EmailError", "L'e-mail è già presente nel database.");
			return email;
		}
		
		/**
		 * Il metodo fornisce i controlli di validazione del parametro indirizzo di un generico delegato aziendale
		 * @param indirizzo
		 * @return indirizzo
		 * @throws RichiestaConvenzionamentoNonValidaException
		 */
		public String validaIndirizzo(String indirizzo) throws RichiestaConvenzionamentoNonValidaException {
			
			if (indirizzo == null)
				throw new RichiestaConvenzionamentoNonValidaException("IndirizzoError", "Il campo indirizzo non può essere nullo.");

			if (indirizzo.length() < DelegatoAziendale.MIN_LUNGHEZZA_CAMPO)
				throw new RichiestaConvenzionamentoNonValidaException("IndirizzoError", "Il campo indirizzo deve contenere almeno 2 caratteri.");

			if (indirizzo.length() > DelegatoAziendale.MAX_LUNGHEZZA_CAMPO)
				throw new RichiestaConvenzionamentoNonValidaException("IndirizzoError", "Il campo indirizzo deve contenere al massimo 255 caratteri.");

			if (!indirizzo.matches(DelegatoAziendale.INDIRIZZO_PATTERN))
				throw new RichiestaConvenzionamentoNonValidaException("IndirizzoError", "Il campo indirizzo deve contenere soltanto caratteri alfanumerici e di punteggiatura.");
			return indirizzo;
		}
		
		/**
		 * Il metodo fornisce i controlli di validazione del parametro password di un generico delegato aziendale
		 * @param password
		 * @return password
		 * @throws RichiestaConvenzionamentoNonValidaException
		 */
		public String validaPassword(String password) throws RichiestaConvenzionamentoNonValidaException {
			
			if (password == null)
				throw new RichiestaConvenzionamentoNonValidaException("PasswordError", "Il campo password non può essere nullo.");

			if (password.length() < DelegatoAziendale.MIN_LUNGHEZZA_PASSWORD)
				throw new RichiestaConvenzionamentoNonValidaException("PasswordError", "Il campo password deve contenere almeno 8 caratteri.");

			if (password.length() > DelegatoAziendale.MAX_LUNGHEZZA_PASSWORD)
				throw new RichiestaConvenzionamentoNonValidaException("PasswordError", "Il campo password deve contenere al massimo 24 caratteri.");

			if (!password.matches(DelegatoAziendale.PASSWORD_PATTERN))
				throw new RichiestaConvenzionamentoNonValidaException("PasswordError", "Il campo password deve contenere almeno" 
						+ "un numero, almeno una lettera e non deve contenere spazi.");
			return password;
		}
		
		/**
		 * Il metodo fornisce i controlli di validazione del parametro conferma password di un generico delegato aziendale
		 * @param password
		 * @param confermaPassword
		 * @return confermaPassword
		 * @throws RichiestaConvenzionamentoNonValidaException
		 */
		public String validaConfermaPassword(String password, String confermaPassword) throws RichiestaConvenzionamentoNonValidaException {
			
			if (confermaPassword == null)
				throw new RichiestaConvenzionamentoNonValidaException("ConfermaPasswordError", "Il campo conferma password non può essere nullo.");

			if (confermaPassword.length() < DelegatoAziendale.MIN_LUNGHEZZA_PASSWORD)
				throw new RichiestaConvenzionamentoNonValidaException("ConfermaPasswordError", "Il campo password e il campo conferma password non corrispondono.");

			if (confermaPassword.length() > DelegatoAziendale.MAX_LUNGHEZZA_PASSWORD)
				throw new RichiestaConvenzionamentoNonValidaException("ConfermaPasswordError", "Il campo password e il campo conferma password non corrispondono.");

			if (!confermaPassword.matches(DelegatoAziendale.PASSWORD_PATTERN))
				throw new RichiestaConvenzionamentoNonValidaException("ConfermaPasswordError", "Il campo password e il campo conferma password non corrispondono.");
			
			if (!confermaPassword.equals(password))
				throw new RichiestaConvenzionamentoNonValidaException("ConfermaPasswordError", "Il campo password e il campo conferma password non corrispondono.");
			return confermaPassword;
		}
		
		/**
		 * Il metodo fornisce i controlli di validazione del parametro ragione sociale di una generica azienda
		 * @param ragioneSociale
		 * @return ragioneSociale
		 * @throws RichiestaConvenzionamentoNonValidaException
		 */
		public String validaRagioneSociale(String ragioneSociale) throws RichiestaConvenzionamentoNonValidaException {
					
			if (ragioneSociale == null)
				throw new RichiestaConvenzionamentoNonValidaException("RagioneSocialeError", "Il campo Ragione Sociale non può essere nullo.");

			if (ragioneSociale.length() < Azienda.MIN_LUNGHEZZA_SEDE_SETTORE_RAGIONE_SOCIALE)
				throw new RichiestaConvenzionamentoNonValidaException("RagioneSocialeError", "Il campo Ragione Sociale deve contenere almeno 5 caratteri.");

			if (ragioneSociale.length() > Azienda.MAX_LUNGHEZZA_SEDE_SETTORE_RAGIONE_SOCIALE)
				throw new RichiestaConvenzionamentoNonValidaException("RagioneSocialeError", "Il campo Ragione Sociale deve contenere al massimo 255 caratteri.");

			if (!ragioneSociale.matches(Azienda.RAGIONE_SOCIALE_PATTERN))
				throw new RichiestaConvenzionamentoNonValidaException("RagioneSocialeError", "Il campo Ragione Sociale deve contenere soltanto caratteri alafanumerici e di punteggiatura.");
			return ragioneSociale;
		}
		
		/**
		 * Il metodo fornisce i controlli di validazione del parametro sede di una generica azienda
		 * @param sede
		 * @return sede
		 * @throws RichiestaConvenzionamentoNonValidaException
		 */
		public String validaSede(String sede) throws RichiestaConvenzionamentoNonValidaException {
					
			if (sede == null)
				throw new RichiestaConvenzionamentoNonValidaException("SedeError", "Il campo Sede non può essere nullo.");

			if (sede.length() < Azienda.MIN_LUNGHEZZA_SEDE_SETTORE_RAGIONE_SOCIALE)
				throw new RichiestaConvenzionamentoNonValidaException("SedeError", "Il campo Sede deve contenere almeno 5 caratteri.");

			if (sede.length() > Azienda.MAX_LUNGHEZZA_SEDE_SETTORE_RAGIONE_SOCIALE)
				throw new RichiestaConvenzionamentoNonValidaException("SedeError", "Il campo Sede deve contenere al massimo 255 caratteri.");

			if (!sede.matches(Azienda.SEDE_PATTERN))
				throw new RichiestaConvenzionamentoNonValidaException("SedeError", "Il campo Sede deve contenere soltanto caratteri alfanumerici e di punteggiatura");
			return sede;
		}
		
		/**
		 * Il metodo fornisce i controlli di validazione del parametro partita iva di una generica azienda
		 * @param piva
		 * @return piva
		 * @throws RichiestaConvenzionamentoNonValidaException
		 */
		public String validaPiva(String piva) throws RichiestaConvenzionamentoNonValidaException {
					
			if (piva == null)
				throw new RichiestaConvenzionamentoNonValidaException("PartitaIvaError", "Il campo partita IVA nome non può essere nullo.");

			if (piva.length() != Azienda.LUNGHEZZA_PARTITA_IVA)
				throw new RichiestaConvenzionamentoNonValidaException("PartitaIvaError", "Il campo partita IVA deve contenere 11 caratteri");
			
			if (!piva.matches(Azienda.PIVA_PATTERN))
				throw new RichiestaConvenzionamentoNonValidaException("PartitaIvaError", "Il campo partita IVA deve contenere esattamente 11 numeri ");
			return piva;
		}
		
		/**
		 * Il metodo fornisce i controlli di validazione del parametro settore di una generica azienda
		 * @param ragioneSociale
		 * @return ragioneSociale
		 * @throws RichiestaConvenzionamentoNonValidaException
		 */
		public String validaSettore(String settore) throws RichiestaConvenzionamentoNonValidaException {
					
			if (settore == null)
				throw new RichiestaConvenzionamentoNonValidaException("SettoreError", "Il campo Settore non può essere nullo.");

			if (settore.length() < Azienda.MIN_LUNGHEZZA_SEDE_SETTORE_RAGIONE_SOCIALE)
				throw new RichiestaConvenzionamentoNonValidaException("SettoreError", "Il campo Settore deve contenere almeno 2 caratteri.");

			if (settore.length() > Azienda.MAX_LUNGHEZZA_SEDE_SETTORE_RAGIONE_SOCIALE)
				throw new RichiestaConvenzionamentoNonValidaException("SettoreError", "Il campo Settore deve contenere al massimo 255 caratteri.");

			if (!settore.matches(Azienda.SETTORE_PATTERN))
				throw new RichiestaConvenzionamentoNonValidaException("SettoreError", "Il campo Settore deve contenere soltanto caratteri alfanumerici");
			return settore;
		}
		
		/**
		 * Il metodo fornisce i controlli di validazione del parametro descrizione di una generica azienda
		 * @param ragioneSociale
		 * @return ragioneSociale
		 * @throws RichiestaConvenzionamentoNonValidaException
		 */
		public String validaDescrizione(String descrizione) throws RichiestaConvenzionamentoNonValidaException {
					
			if (descrizione == null)
				throw new RichiestaConvenzionamentoNonValidaException("DescrizioneError", "Il campo Descrizione nome non può essere nullo.");

			if (descrizione.length() < Azienda.MIN_LUNGHEZZA_DESCRIZIONE)
				throw new RichiestaConvenzionamentoNonValidaException("DescrizioneError", "Il campo Descrizione contenere almeno 2 caratteri.");

			if (descrizione.length() > Azienda.MAX_LUNGHEZZA_DESCRIZIONE)
				throw new RichiestaConvenzionamentoNonValidaException("DescrizioneError", "Il campo Descrizione deve contenere al massimo 800 caratteri.");
			
			return descrizione;
		}
		
		/**
		 * Il metodo fornisce i controlli di validazione del parametro condizioniDelegato privacy per una richiesta di convenzionamento.
		 * @param condizioniDelegato
		 * @return condizioniDelegato
		 * @throws RichiestaConvenzionamentoNonValidaException
		 */
		public String validaCondizioniDelegato(String condizioniDelegato) throws RichiestaConvenzionamentoNonValidaException {
			if (condizioniDelegato == null)
				throw new RichiestaConvenzionamentoNonValidaException("CondizioniDelegatoError", "È obbligatorio accettare le condizioni sulla privacy.");
			
			return condizioniDelegato;
		}
		
		/**
		 * Il metodo fornisce i controlli di validazione del parametro condizioniAzienda privacy per una richiesta di convenzionamento.
		 * @param condizioniAzienda
		 * @return condizioniAzienda
		 * @throws RichiestaConvenzionamentoNonValidaException
		 */
		public String validaCondizioniAzienda(String condizioniAzienda) throws RichiestaConvenzionamentoNonValidaException {
			if (condizioniAzienda == null)
				throw new RichiestaConvenzionamentoNonValidaException("CondizioniAziendaError", "È obbligatorio accettare le condizioni sulla privacy.");
			
			return condizioniAzienda;
		}

}
