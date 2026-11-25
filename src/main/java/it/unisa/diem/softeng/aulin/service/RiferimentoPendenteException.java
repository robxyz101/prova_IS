package it.unisa.diem.softeng.aulin.service;

import it.unisa.diem.softeng.aulin.model.Aula;
import it.unisa.diem.softeng.aulin.model.Prenotazione;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @brief Eccezione controllata lanciata quando la cancellazione di un'entità è bloccata da riferimenti esistenti.
 *
 * Impedisce di violare l'integrità referenziale dell'archivio (ED7.1) durante l'eliminazione
 * di docenti, aule, corsi o edifici collegati a prenotazioni o ad aule prenotate
 * (FI7.5, FI7.6, FI8.4, FI8.5, FI9.5, FI9.6, FI12.4).
 * Trasporta gli elenchi delle prenotazioni e/o delle aule che impediscono la cancellazione,
 * permettendo all'interfaccia di informare puntualmente l'operatore.
 *
 * @invariant prenotazioniCollegate != null
 * @invariant auleCollegate != null
 * @see DocenteService
 * @see AulaService
 * @see CorsoService
 * @see EdificioService
 */
public class RiferimentoPendenteException extends Exception {

    private final List<Prenotazione> prenotazioniCollegate;
    private final List<Aula> auleCollegate;

    /**
     * @brief Costruisce una nuova eccezione riportando le prenotazioni e le aule che bloccano la cancellazione.
     *
     * @param[in] prenotazioni Lista delle prenotazioni collegate all'entità da eliminare (può essere vuota o null).
     * @param[in] aule Lista delle aule collegate che bloccano la cancellazione di un edificio (può essere vuota o null).
     * @pre Almeno una tra le due liste contiene almeno un elemento.
     * @post getPrenotazioniCollegate() e getAuleCollegate() restituiscono viste non modificabili degli elenchi forniti.
     */
    public RiferimentoPendenteException(List<Prenotazione> prenotazioni, List<Aula> aule) {
        super("Impossibile completare l'eliminazione: esistono riferimenti pendenti nell'archivio.");
        this.prenotazioniCollegate = prenotazioni == null
                ? Collections.emptyList()
                : Collections.unmodifiableList(new ArrayList<>(prenotazioni));
        this.auleCollegate = aule == null
                ? Collections.emptyList()
                : Collections.unmodifiableList(new ArrayList<>(aule));
    }

    /**
     * @brief Restituisce le prenotazioni che impediscono la cancellazione dell'entità.
     *
     * @return Lista non modificabile delle prenotazioni collegate (vuota se non applicabile).
     * @post Lo stato interno dell'eccezione non viene modificato.
     */
    public List<Prenotazione> getPrenotazioniCollegate() {
        return prenotazioniCollegate;
    }

    /**
     * @brief Restituisce le aule che impediscono la cancellazione dell'edificio.
     *
     * @return Lista non modificabile delle aule collegate con prenotazioni attive (vuota se non applicabile).
     * @post Lo stato interno dell'eccezione non viene modificato.
     */
    public List<Aula> getAuleCollegate() {
        return auleCollegate;
    }
}
