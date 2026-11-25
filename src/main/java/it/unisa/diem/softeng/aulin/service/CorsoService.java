package it.unisa.diem.softeng.aulin.service;

import it.unisa.diem.softeng.aulin.model.Corso;
import it.unisa.diem.softeng.aulin.model.ValidazioneException;
import it.unisa.diem.softeng.aulin.storage.ArchivioDati;
import it.unisa.diem.softeng.aulin.storage.ArchivioException;
import java.util.List;

/**
 * @brief Servizio applicativo per la gestione dell'anagrafica dei corsi universitari (UC5, BF08).
 *
 * Coordina inserimento, modifica, cancellazione ed elenco dei corsi.
 * Garantisce l'unicità del codice del corso (case-insensitive, FI8.2), il blocco della
 * cancellazione se il corso è referenziato da una o più prenotazioni (FI8.4, FI8.5)
 * e la persistenza atomica con ripristino in memoria in caso di errore (FI13.1, NF3).
 *
 * @invariant archivio != null
 * @see Corso
 * @see ArchivioDati
 * @see RiferimentoPendenteException
 */
public class CorsoService {

    private final ArchivioDati archivio;

    /**
     * @brief Costruisce il servizio di gestione corsi iniettando l'archivio dati.
     *
     * @param[in] archivio Astrazione dell'archivio dati da utilizzare per lettura e persistenza.
     * @pre archivio != null
     * @post Il servizio opera sull'archivio fornito.
     */
    public CorsoService(ArchivioDati archivio) {
        this.archivio = archivio;
    }

    /**
     * @brief Registra un nuovo corso nell'archivio dopo aver verificato validità e unicità del codice.
     *
     * @param[in] codice Codice identificativo univoco del corso (3-12 caratteri alfanumerici o trattini).
     * @param[in] denominazione Titolo o denominazione del corso.
     * @pre codice e denominazione rispettano le invarianti di {@link Corso}.
     * @pre Non esiste già un corso con lo stesso codice (case-insensitive, FI8.2).
     * @return Istanza di {@link Corso} creata e salvata nell'archivio.
     * @post Il nuovo corso è presente nell'archivio e salvato; in caso di errore lo stato in memoria è ripristinato (NF3).
     * @throws ValidazioneException Se i dati non sono validi o il codice del corso è già presente.
     * @throws ArchivioException Se il salvataggio dell'archivio fallisce.
     */
    public Corso aggiungiCorso(String codice, String denominazione) throws ArchivioException {
        return null;
    }

    /**
     * @brief Modifica codice e denominazione di un corso esistente verificando l'unicità del nuovo codice.
     *
     * @param[in] codiceOriginale Codice corrente del corso da modificare.
     * @param[in] nuovoCodice Nuovo codice identificativo del corso.
     * @param[in] nuovaDenominazione Nuova denominazione del corso.
     * @pre Esiste un corso identificato da codiceOriginale (case-insensitive).
     * @pre nuovoCodice non è già assegnato a un altro corso (FI8.2).
     * @post Il corso è aggiornato (riflettendosi sulle prenotazioni collegate, ED7.1) e l'archivio è salvato;
     *       in caso di errore lo stato precedente viene ripristinato (NF3).
     * @throws ValidazioneException Se il corso originale non esiste, i dati non sono validi o il nuovo codice è duplicato.
     * @throws ArchivioException Se il salvataggio dell'archivio fallisce.
     */
    public void modificaCorso(String codiceOriginale, String nuovoCodice,
                              String nuovaDenominazione) throws ArchivioException {
    }

    /**
     * @brief Elimina un corso dall'archivio se non risulta associato ad alcuna prenotazione.
     *
     * @param[in] codice Codice identificativo del corso da eliminare.
     * @pre Esiste un corso con il codice specificato (case-insensitive).
     * @pre Nessuna prenotazione nell'archivio fa riferimento al corso (FI8.4).
     * @post Il corso è rimosso dall'archivio e la modifica è salvata;
     *       in caso di errore lo stato in memoria viene ripristinato (NF3).
     * @throws ValidazioneException Se il codice è nullo/vuoto o non corrisponde ad alcun corso registrato.
     * @throws RiferimentoPendenteException Se esistono prenotazioni collegate al corso (FI8.5).
     * @throws ArchivioException Se il salvataggio dell'archivio fallisce.
     */
    public void eliminaCorso(String codice) throws RiferimentoPendenteException, ArchivioException {
    }

    /**
     * @brief Restituisce l'elenco completo di tutti i corsi registrati nell'archivio.
     *
     * @return Lista dei corsi presenti nell'archivio (vuota se non ve ne sono).
     * @post Lo stato interno dell'archivio non viene modificato.
     */
    public List<Corso> getTuttiCorsi() {
        return null;
    }
}
