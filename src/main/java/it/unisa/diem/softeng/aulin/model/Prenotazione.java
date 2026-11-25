
package it.unisa.diem.softeng.aulin.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

/**
 * @brief Rappresenta una prenotazione di un'aula da parte di un docente
 * in una determinata data e fascia oraria.
 *
 * La prenotazione associa un'aula, un docente e, facoltativamente,
 * un corso universitario a una specifica attività.
 *
 * Ogni prenotazione è identificata univocamente da un UUID e può essere
 * singola oppure appartenere a una serie di prenotazioni ricorrenti,
 * identificata dal campo idSerie.
 *
 * La classe mette a disposizione operazioni per modificare i dati
 * della prenotazione e verificare eventuali sovrapposizioni temporali
 * con altre prenotazioni.
 *
 * @invariant id != null && !id.isBlank()
 * @invariant aula != null && docente != null && tipologia != null
 * @invariant denominazione != null && !denominazione.isBlank()
 * @invariant data != null
 * @invariant orarioInizio != null && orarioFine != null
 * @invariant orarioFine.isAfter(orarioInizio)
 * @invariant idSerie == null || !idSerie.isBlank()
 *
 * @see Aula
 * @see Docente
 * @see Corso
 * @see TipoAttivita
 */
public class Prenotazione {

    private final String id;
    private Aula aula;
    private Docente docente;
    private Corso corso;
    private TipoAttivita tipologia;
    private String denominazione;
    private LocalDate data;
    private LocalTime orarioInizio;
    private LocalTime orarioFine;
    private final String idSerie; // null indica una prenotazione singola

    /**
     * @brief Crea una nuova prenotazione singola generando automaticamente
     * un identificativo UUID.
     *
     * Questo costruttore viene utilizzato quando una prenotazione viene
     * creata direttamente dall'applicazione e non appartiene a una
     * serie ricorrente.
     *
     * L'identificativo viene generato internamente, mentre idSerie
     * viene lasciato a null per indicare una prenotazione singola.
     *
     * @param[in] aula Aula alla quale viene assegnata la prenotazione.
     * @param[in] docente Docente responsabile dell'attività.
     * @param[in] corso Corso universitario associato, null se non previsto.
     * @param[in] tipologia Tipologia dell'attività prenotata.
     * @param[in] denominazione Titolo o descrizione dell'attività.
     * @param[in] data Data in cui si svolge la prenotazione.
     * @param[in] orarioInizio Orario di inizio della prenotazione.
     * @param[in] orarioFine Orario di termine della prenotazione.
     *
     * @post id contiene un nuovo identificativo UUID.
     * @post idSerie == null.
     *
     * @see UUID
     */
    public Prenotazione(Aula aula, Docente docente, Corso corso,
                        TipoAttivita tipologia, String denominazione,
                        LocalDate data, LocalTime orarioInizio,
                        LocalTime orarioFine) {

        this.id = UUID.randomUUID().toString();

        this.aula = aula;
        this.docente = docente;
        this.corso = corso;
        this.tipologia = tipologia;
        this.denominazione = denominazione;
        this.data = data;
        this.orarioInizio = orarioInizio;
        this.orarioFine = orarioFine;
        this.idSerie = null;
    }

    /**
     * @brief Crea una nuova prenotazione appartenente a una serie ricorrente,
     * generando automaticamente un identificativo UUID.
     *
     * Questo costruttore viene utilizzato durante la creazione da programma
     * delle singole occorrenze di una serie ricorrente.
     *
     * Ogni occorrenza possiede un identificativo univoco indipendente,
     * mentre tutte le prenotazioni appartenenti alla stessa serie
     * condividono il medesimo identificativo idSerie.
     *
     * @param[in] aula Aula alla quale viene assegnata la prenotazione.
     * @param[in] docente Docente responsabile dell'attività.
     * @param[in] corso Corso universitario associato, null se non previsto.
     * @param[in] tipologia Tipologia dell'attività prenotata.
     * @param[in] denominazione Titolo o descrizione dell'attività.
     * @param[in] data Data in cui si svolge questa occorrenza.
     * @param[in] orarioInizio Orario di inizio della prenotazione.
     * @param[in] orarioFine Orario di termine della prenotazione.
     * @param[in] idSerie Identificativo condiviso dalla serie ricorrente.
     *
     * @post id contiene un nuovo identificativo UUID.
     * @post idSerie contiene l'identificativo della serie di appartenenza.
     *
     * @see UUID
     */
    public Prenotazione(Aula aula, Docente docente, Corso corso,
                        TipoAttivita tipologia, String denominazione,
                        LocalDate data, LocalTime orarioInizio,
                        LocalTime orarioFine, String idSerie) {

        this.id = UUID.randomUUID().toString();

        this.aula = aula;
        this.docente = docente;
        this.corso = corso;
        this.tipologia = tipologia;
        this.denominazione = denominazione;
        this.data = data;
        this.orarioInizio = orarioInizio;
        this.orarioFine = orarioFine;
        this.idSerie = idSerie;
    }

    /**
     * @brief Ricostruisce una prenotazione singola a partire dai dati
     * precedentemente salvati su file.
     *
     * A differenza dei costruttori destinati alla creazione da programma,
     * questo costruttore riceve esplicitamente l'identificativo della
     * prenotazione, in modo da preservarne l'identità durante il
     * caricamento dei dati persistiti.
     *
     * La prenotazione ricostruita non appartiene a una serie ricorrente.
     *
     * @param[in] id Identificativo UUID precedentemente assegnato
     * alla prenotazione.
     * @param[in] aula Aula alla quale viene assegnata la prenotazione.
     * @param[in] docente Docente responsabile dell'attività.
     * @param[in] corso Corso universitario associato, null se non previsto.
     * @param[in] tipologia Tipologia dell'attività prenotata.
     * @param[in] denominazione Titolo o descrizione dell'attività.
     * @param[in] data Data in cui si svolge la prenotazione.
     * @param[in] orarioInizio Orario di inizio della prenotazione.
     * @param[in] orarioFine Orario di termine della prenotazione.
     *
     * @post id conserva l'identificativo ricevuto.
     * @post idSerie == null.
     *
     * @see UUID
     */
    public Prenotazione(String id, Aula aula, Docente docente, Corso corso,
                        TipoAttivita tipologia, String denominazione,
                        LocalDate data, LocalTime orarioInizio,
                        LocalTime orarioFine) {

        this.id = id;

        this.aula = aula;
        this.docente = docente;
        this.corso = corso;
        this.tipologia = tipologia;
        this.denominazione = denominazione;
        this.data = data;
        this.orarioInizio = orarioInizio;
        this.orarioFine = orarioFine;
        this.idSerie = null;
    }

    /**
     * @brief Ricostruisce una prenotazione appartenente a una serie
     * ricorrente a partire dai dati precedentemente salvati su file.
     *
     * Questo costruttore viene utilizzato durante il caricamento
     * delle prenotazioni persistite per ripristinare sia l'identificativo
     * univoco della singola occorrenza sia quello condiviso dalla serie.
     *
     * La conservazione di entrambi gli identificativi permette di
     * mantenere l'identità delle prenotazioni e la loro appartenenza
     * alla serie anche dopo il caricamento dei dati.
     *
     * @param[in] id Identificativo UUID della singola prenotazione.
     * @param[in] aula Aula alla quale viene assegnata la prenotazione.
     * @param[in] docente Docente responsabile dell'attività.
     * @param[in] corso Corso universitario associato, null se non previsto.
     * @param[in] tipologia Tipologia dell'attività prenotata.
     * @param[in] denominazione Titolo o descrizione dell'attività.
     * @param[in] data Data in cui si svolge questa occorrenza.
     * @param[in] orarioInizio Orario di inizio della prenotazione.
     * @param[in] orarioFine Orario di termine della prenotazione.
     * @param[in] idSerie Identificativo della serie ricorrente
     * di appartenenza.
     *
     * @post id conserva l'identificativo ricevuto.
     * @post idSerie conserva l'identificativo della serie ricevuto.
     *
     * @see UUID
     */
    public Prenotazione(String id, Aula aula, Docente docente, Corso corso,
                        TipoAttivita tipologia, String denominazione,
                        LocalDate data, LocalTime orarioInizio,
                        LocalTime orarioFine, String idSerie) {

        this.id = id;

        this.aula = aula;
        this.docente = docente;
        this.corso = corso;
        this.tipologia = tipologia;
        this.denominazione = denominazione;
        this.data = data;
        this.orarioInizio = orarioInizio;
        this.orarioFine = orarioFine;

        this.idSerie = idSerie;
    }

    /**
     * @brief Aggiorna i dati modificabili di una prenotazione.
     *
     * Modifica l'aula, il docente, il corso, la tipologia dell'attività,
     * la denominazione, la data e la fascia oraria.
     *
     * L'identificativo della prenotazione e l'eventuale identificativo
     * della serie ricorrente non vengono modificati.
     *
     * @param[in] aula Nuova aula assegnata alla prenotazione.
     * @param[in] docente Nuovo docente responsabile dell'attività.
     * @param[in] corso Nuovo corso associato, null se non previsto.
     * @param[in] tipologia Nuova tipologia dell'attività.
     * @param[in] denominazione Nuovo titolo o descrizione dell'attività.
     * @param[in] data Nuova data della prenotazione.
     * @param[in] orarioInizio Nuovo orario di inizio.
     * @param[in] orarioFine Nuovo orario di termine.
     *
     * @pre I nuovi dati devono rispettare i vincoli di dominio.
     * @pre orarioFine deve essere successivo a orarioInizio.
     *
     * @post I dati modificabili risultano aggiornati.
     * @post id e idSerie mantengono i valori precedenti.
     *
     * @throws ValidazioneException Se i nuovi dati non rispettano
     * i vincoli di dominio.
     */
    public void modifica(Aula aula, Docente docente, Corso corso,
                         TipoAttivita tipologia, String denominazione,
                         LocalDate data, LocalTime orarioInizio,
                         LocalTime orarioFine) {

    }

    /**
     * @brief Verifica se la prenotazione appartiene a una serie ricorrente.
     *
     * Una prenotazione viene considerata ricorrente quando possiede
     * un identificativo di serie diverso da null.
     *
     * @return true se la prenotazione appartiene a una serie ricorrente,
     * false altrimenti.
     */
    public boolean isRicorente() {
        return idSerie != null;
    }

    /**
     * @brief Verifica se la fascia oraria della prenotazione si sovrappone
     * a quella di un'altra prenotazione.
     *
     * Il confronto considera la data e gli orari di inizio e fine
     * delle due prenotazioni.
     *
     * Due prenotazioni con intervalli temporali adiacenti, ovvero quando
     * l'orario di fine di una coincide con l'orario di inizio dell'altra,
     * non sono considerate sovrapposte.
     *
     * @param[in] altra Prenotazione con cui effettuare il confronto.
     *
     * @return true se le due prenotazioni si sovrappongono temporalmente,
     * false altrimenti.
     *
     * @pre altra != null.
     */
    public boolean siSovrapponeA(Prenotazione altra) {
        return false;
    }

    /**
     * @brief Restituisce l'identificativo univoco della prenotazione.
     *
     * @return Identificativo UUID della prenotazione.
     */
    public String getId() {
        return id;
    }

    /**
     * @brief Restituisce l'aula assegnata alla prenotazione.
     *
     * @return Aula associata alla prenotazione.
     */
    public Aula getAula() {
        return aula;
    }

    /**
     * @brief Restituisce il docente responsabile della prenotazione.
     *
     * @return Docente associato alla prenotazione.
     */
    public Docente getDocente() {
        return docente;
    }

    /**
     * @brief Restituisce il corso universitario associato alla prenotazione.
     *
     * @return Corso associato oppure null se non previsto.
     */
    public Corso getCorso() {
        return corso;
    }

    /**
     * @brief Restituisce la tipologia dell'attività prenotata.
     *
     * @return Tipologia dell'attività.
     */
    public TipoAttivita getTipologia() {
        return tipologia;
    }

    /**
     * @brief Restituisce la denominazione dell'attività prenotata.
     *
     * @return Titolo o descrizione dell'attività.
     */
    public String getDenominazione() {
        return denominazione;
    }

    /**
     * @brief Restituisce la data della prenotazione.
     *
     * @return Data in cui si svolge l'attività.
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * @brief Restituisce l'orario di inizio della prenotazione.
     *
     * @return Orario di inizio.
     */
    public LocalTime getOrarioInizio() {
        return orarioInizio;
    }

    /**
     * @brief Restituisce l'orario di termine della prenotazione.
     *
     * @return Orario di fine.
     */
    public LocalTime getOrarioFine() {
        return orarioFine;
    }

    /**
     * @brief Restituisce l'identificativo della serie ricorrente.
     *
     * Il valore restituito è null se la prenotazione non appartiene
     * a una serie ricorrente.
     *
     * @return Identificativo della serie oppure null.
     */
    public String getIdSerie() {
        return idSerie;
    }

    /**
     * @brief Verifica l'uguaglianza tra due prenotazioni.
     *
     * Due prenotazioni sono considerate uguali se appartengono alla
     * stessa classe e presentano gli stessi valori in tutti i campi,
     * compresi gli identificativi e i dati temporali.
     *
     * @param[in] o Oggetto con cui effettuare il confronto.
     *
     * @return true se i due oggetti sono uguali, false altrimenti.
     *
     * @see Objects#equals(Object, Object)
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Prenotazione that = (Prenotazione) o;
        return Objects.equals(id, that.id)
                && Objects.equals(aula, that.aula)
                && Objects.equals(docente, that.docente)
                && Objects.equals(corso, that.corso)
                && tipologia == that.tipologia
                && Objects.equals(denominazione, that.denominazione)
                && Objects.equals(data, that.data)
                && Objects.equals(orarioInizio, that.orarioInizio)
                && Objects.equals(orarioFine, that.orarioFine)
                && Objects.equals(idSerie, that.idSerie);
    }

    /**
     * @brief Calcola il codice hash della prenotazione.
     *
     * Il valore viene calcolato utilizzando tutti i campi considerati
     * dal metodo equals, garantendo il rispetto del contratto tra
     * equals() e hashCode().
     *
     * @return Codice hash della prenotazione.
     *
     * @see Objects#hash(Object...)
     * @see #equals(Object)
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, aula, docente, corso, tipologia,
                denominazione, data, orarioInizio, orarioFine, idSerie);
    }
}
