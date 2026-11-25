package it.unisa.diem.softeng.aulin.model;

import java.util.Objects;

/**
 * @brief Rappresenta un insegnamento o corso universitario dell'anagrafica.
 *
 * Identificato univocamente dal codice (3-12 caratteri alfanumerici o trattini,
 * memorizzato in maiuscolo) e descritto dalla denominazione (ED4.1, FI8.1).
 *
 * @invariant codice != null && !codice.isBlank()
 * @invariant denominazione != null && !denominazione.isBlank()
 * @see Prenotazione
 */
public class Corso {

    private String codice;
    private String denominazione;

    /**
     * @brief Costruisce un nuovo corso validando codice e denominazione.
     *
     * @param[in] codice Codice identificativo del corso (3-12 caratteri alfanumerici o trattino).
     * @param[in] denominazione Nome esteso dell'insegnamento.
     * @pre codice != null && codice.trim().matches("^[A-Za-z0-9-]{3,12}$")
     * @pre denominazione != null && !denominazione.trim().isEmpty()
     * @post getCodice().equals(codice.trim().toUpperCase())
     * @post getDenominazione().equals(denominazione.trim())
     * @throws ValidazioneException Se il codice non rispetta il formato o la denominazione è vuota.
     */
    public Corso(String codice, String denominazione){

    }

    /**
     * @brief Aggiorna atomicamente codice e denominazione del corso.
     *
     * Valida entrambi i parametri prima di modificare lo stato dell'oggetto,
     * evitando stati intermedi non validi.
     *
     * @param[in] codice Nuovo codice del corso.
     * @param[in] denominazione Nuova denominazione del corso.
     * @pre codice != null && codice.trim().matches("^[A-Za-z0-9-]{3,12}$")
     * @pre denominazione != null && !denominazione.trim().isEmpty()
     * @post getCodice().equals(codice.trim().toUpperCase()) && getDenominazione().equals(denominazione.trim())
     * @throws ValidazioneException Se uno dei campi non è valido (lo stato resta invariato).
     */
    public void modifica(String codice, String denominazione){

    }

    /**
     * @brief Restituisce il codice identificativo del corso in maiuscolo.
     *
     * @return Codice del corso.
     */
    public String getCodice() {
        return codice;
    }

    /**
     * @brief Aggiorna il codice del corso verificando le invarianti.
     *
     * @param[in] codice Nuovo codice del corso.
     * @pre codice != null && !codice.trim().isEmpty()
     * @post getCodice().equals(codice.trim())
     * @throws ValidazioneException Se codice è nullo o vuoto (lo stato precedente resta invariato).
     */
    public void setCodice(String codice) {
        this.codice = codice;
    }

    /**
     * @brief Restituisce la denominazione del corso.
     *
     * @return Denominazione del corso.
     */
    public String getDenominazione() {
        return denominazione;
    }

    /**
     * @brief Aggiorna la denominazione del corso verificando le invarianti.
     *
     * @param[in] denominazione Nuova denominazione del corso.
     * @pre denominazione != null && !denominazione.trim().isEmpty()
     * @post getDenominazione().equals(denominazione.trim())
     * @throws ValidazioneException Se denominazione è nullo o vuoto (lo stato precedente resta invariato).
     */
    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    /**
     * @brief Confronta due corsi in base al codice (case-insensitive).
     *
     * @param[in] o Oggetto da confrontare.
     * @return true se o è un Corso con lo stesso codice, false altrimenti.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Corso corso = (Corso) o;
        return Objects.equals(codice, corso.codice) && Objects.equals(denominazione, corso.denominazione);
    }

    /**
     * @brief Calcola il codice hash basato sul codice del corso.
     *
     * @return Valore hash del corso.
     */
    @Override
    public int hashCode() {
        return Objects.hash(codice, denominazione);
    }
}
