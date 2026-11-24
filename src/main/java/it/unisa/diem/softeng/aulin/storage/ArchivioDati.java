package it.unisa.diem.softeng.aulin.storage;

import it.unisa.diem.softeng.aulin.model.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @brief Contratto astratto per l'accesso e la persistenza dell'archivio dati di Aul-In.
 *
 * Separa la logica applicativa dei servizi dai dettagli di memorizzazione su file (DIP).
 * Tutte le collezioni restituite dai metodi di lettura sono non modificabili per preservare
 * l'integrità dello stato interno e degli eventuali indici in memoria.
 *
 * @see ArchivioFile
 * @see ArchivioException
 */
public interface ArchivioDati {

    /**
     * @brief Restituisce l'elenco corrente dei docenti registrati.
     *
     * @return Lista non modificabile dei docenti in memoria (vuota se assenti).
     * @post Lo stato interno dell'archivio non viene modificato.
     */
    List<Docente> getDocenti();

    /**
     * @brief Sostituisce l'elenco dei docenti in memoria.
     *
     * @param[in] docenti Nuova lista di docenti da memorizzare.
     * @pre docenti != null e nessun elemento è null.
     * @post L'archivio in memoria contiene una copia difensiva della lista fornita.
     */
    void setDocenti(List<Docente> docenti);

    /**
     * @brief Restituisce l'elenco corrente delle aule registrate.
     *
     * @return Lista non modificabile delle aule in memoria (vuota se assenti).
     * @post Lo stato interno dell'archivio non viene modificato.
     */
    List<Aula> getAule();

    /**
     * @brief Sostituisce l'elenco delle aule in memoria.
     *
     * @param[in] aule Nuova lista di aule da memorizzare.
     * @pre aule != null e nessun elemento è null.
     * @post L'archivio in memoria contiene una copia difensiva della lista fornita.
     */
    void setAule(List<Aula> aule);

    /**
     * @brief Restituisce l'elenco corrente degli edifici registrati.
     *
     * @return Lista non modificabile degli edifici in memoria (vuota se assenti).
     * @post Lo stato interno dell'archivio non viene modificato.
     */
    List<Edificio> getEdifici();

    /**
     * @brief Sostituisce l'elenco degli edifici in memoria.
     *
     * @param[in] edifici Nuova lista di edifici da memorizzare.
     * @pre edifici != null e nessun elemento è null.
     * @post L'archivio in memoria contiene una copia difensiva della lista fornita.
     */
    void setEdifici(List<Edificio> edifici);

    /**
     * @brief Restituisce l'elenco corrente dei corsi registrati.
     *
     * @return Lista non modificabile dei corsi in memoria (vuota se assenti).
     * @post Lo stato interno dell'archivio non viene modificato.
     */
    List<Corso> getCorsi();

    /**
     * @brief Sostituisce l'elenco dei corsi in memoria.
     *
     * @param[in] corsi Nuova lista di corsi da memorizzare.
     * @pre corsi != null e nessun elemento è null.
     * @post L'archivio in memoria contiene una copia difensiva della lista fornita.
     */
    void setCorsi(List<Corso> corsi);

    /**
     * @brief Restituisce l'elenco completo di tutte le prenotazioni (singole e ricorrenti).
     *
     * @return Lista non modificabile di tutte le prenotazioni in memoria.
     * @post Lo stato interno dell'archivio non viene modificato.
     */
    List<Prenotazione> getPrenotazioni();

    /**
     * @brief Sostituisce l'intero elenco delle prenotazioni in memoria e aggiorna gli indici interni.
     *
     * @param[in] prenotazioni Nuova lista completa delle prenotazioni.
     * @pre prenotazioni != null e nessun elemento è null.
     * @post Le prenotazioni in memoria e tutti gli indici di ricerca (per data, serie e id)
     *       sono coerenti con la lista fornita.
     */
    void setPrenotazioni(List<Prenotazione> prenotazioni);

    /**
     * @brief Recupera una prenotazione tramite il suo identificativo univoco.
     *
     * @param[in] id Identificativo UUID della prenotazione.
     * @return Optional contenente la prenotazione se presente, vuoto altrimenti.
     * @pre id != null
     * @post Lo stato interno dell'archivio non viene modificato.
     */
    Optional<Prenotazione> getPrenotazionePerId(String id);

    /**
     * @brief Restituisce tutte le prenotazioni (singole e occorrenze di serie) in una specifica data.
     *
     * @param[in] data Giorno di interesse.
     * @return Lista non modificabile delle prenotazioni presenti in quella data (vuota se nessuna).
     * @pre data != null
     * @post Lo stato interno dell'archivio non viene modificato.
     */
    List<Prenotazione> getPrenotazioniPerData(LocalDate data);

    /**
     * @brief Restituisce tutte le prenotazioni comprese in un intervallo di date (estremi inclusi).
     *
     * @param[in] da Data di inizio dell'intervallo (inclusa).
     * @param[in] a Data di fine dell'intervallo (inclusa).
     * @return Lista non modificabile delle prenotazioni nel periodo, ordinate almeno per data crescente.
     * @pre da != null && a != null && !a.isBefore(da)
     * @post Lo stato interno dell'archivio non viene modificato.
     */
    List<Prenotazione> getPrenotazioniPerPeriodo(LocalDate da, LocalDate a);

    /**
     * @brief Restituisce tutte le occorrenze appartenenti a una specifica serie ricorrente.
     *
     * @param[in] idSerie Identificativo univoco della serie ricorrente.
     * @return Lista non modificabile delle occorrenze della serie (vuota se la serie non esiste).
     * @pre idSerie != null && !idSerie.isBlank()
     * @post Lo stato interno dell'archivio non viene modificato.
     */
    List<Prenotazione> getPrenotazioniPerSerie(String idSerie);

    /**
     * @brief Restituisce le impostazioni applicative correnti.
     *
     * @return Oggetto Impostazioni corrente (mai null).
     * @post Lo stato interno dell'archivio non viene modificato.
     */
    Impostazioni getImpostazioni();

    /**
     * @brief Aggiorna le impostazioni applicative in memoria.
     *
     * @param[in] impostazioni Nuove impostazioni da applicare.
     * @pre impostazioni != null
     * @post getImpostazioni() restituisce le nuove impostazioni.
     */
    void setImpostazioni(Impostazioni impostazioni);

    /**
     * @brief Persiste in modo atomico l'intero stato corrente dell'archivio.
     *
     * @post L'archivio persistente riflette integralmente lo stato corrente in memoria.
     *       In caso di errore l'archivio persistente precedente resta integro e invariato.
     * @throws ArchivioException Se si verifica un errore durante la scrittura o la sostituzione del file.
     */
    void salva() throws ArchivioException;

    /**
     * @brief Carica l'archivio dalla sorgente persistente all'avvio dell'applicazione.
     *
     * Se il file di archivio non esiste ancora, inizializza un archivio vuoto con impostazioni predefinite.
     * Se il file esiste ma è illeggibile o danneggiato, non lo sovrascrive.
     *
     * @post Lo stato in memoria (incluse le strutture di indicizzazione) corrisponde al file caricato,
     *       oppure è vuoto se il file non esisteva.
     * @throws ArchivioException Se il file esiste ma è illeggibile, corrotto o contiene riferimenti incoerenti.
     */
    void carica() throws ArchivioException;

    /**
     * @brief Crea una copia di backup dell'archivio corrente nel percorso specificato.
     *
     * @param[in] percorso Percorso del file di destinazione per il backup.
     * @pre percorso != null
     * @post Nel percorso indicato è salvata una copia integra dell'archivio corrente;
     *       il file principale dell'archivio e lo stato in memoria non vengono alterati.
     * @throws ArchivioException Se non è possibile scrivere il file di backup.
     */
    void creaBackup(Path percorso) throws ArchivioException;

    /**
     * @brief Importa e valida un archivio da un file esterno sostituendo atomicamente quello corrente.
     *
     * Il contenuto del file viene deserializzato e validato (inclusa l'integrità referenziale)
     * interamente in memoria prima di sostituire i dati correnti e salvare su disco.
     *
     * @param[in] percorso Percorso del file da importare.
     * @pre percorso != null
     * @post Se il file è valido, lo stato in memoria, gli indici e il file principale contengono i dati importati;
     *       in caso di errore l'archivio corrente (in memoria e su file) resta invariato.
     * @throws ArchivioException Se il file non esiste, è illeggibile, malformato o viola l'integrità referenziale.
     */
    void importaDaFile(Path percorso) throws ArchivioException;
}