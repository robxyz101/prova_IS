package it.unisa.diem.softeng.aulin.service;

import it.unisa.diem.softeng.aulin.model.Prenotazione;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @brief Eccezione controllata lanciata quando una prenotazione entra in conflitto con altre.
 *
 * Segnala la violazione del vincolo di assenza di sovrapposizioni temporali per la stessa aula
 * o per lo stesso docente (FI1.3, FI1.4, FI3.4, NF4). Trasporta l'elenco delle prenotazioni
 * già presenti in archivio che risultano in conflitto, così da consentire all'interfaccia
 * di mostrarne i dettagli (data, aula, docente, fascia oraria) all'operatore (FI1.5, FI3.5).
 *
 * @invariant conflitti != null && !conflitti.isEmpty()
 * @see Prenotazione
 * @see PrenotazioneService
 */
public class SovrapposizioneException extends Exception {

    private final List<Prenotazione> conflitti;

    /**
     * @brief Costruisce una nuova eccezione con l'elenco delle prenotazioni in conflitto.
     *
     * @param[in] conflitti Lista non vuota delle prenotazioni esistenti che causano la sovrapposizione.
     * @pre conflitti != null && !conflitti.isEmpty() e nessun elemento è null.
     * @post getConflitti() restituisce una vista non modificabile dei conflitti forniti.
     */
    public SovrapposizioneException(List<Prenotazione> conflitti) {
        super("Rilevata sovrapposizione con una o più prenotazioni esistenti.");
        this.conflitti = conflitti == null
                ? Collections.emptyList()
                : Collections.unmodifiableList(new ArrayList<>(conflitti));
    }

    /**
     * @brief Restituisce l'elenco delle prenotazioni che generano la sovrapposizione.
     *
     * @return Lista non modificabile delle prenotazioni in conflitto.
     * @post Lo stato interno dell'eccezione non viene modificato.
     */
    public List<Prenotazione> getConflitti() {
        return conflitti;
    }
}
