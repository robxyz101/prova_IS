package it.unisa.diem.softeng.aulin.model;

/**
 * @brief Eccezione non controllata per la violazione di vincoli di validazione.
 *
 * Viene lanciata dai costruttori e dai metodi di modifica delle entità del dominio
 * (e dai servizi applicativi) quando un dato è nullo, vuoto, malformato o duplicato.
 * Trasporta il nome del campo coinvolto per consentire all'interfaccia di evidenziarlo (IU2.1).
 *
 * @invariant getCampo() != null
 * @see Aula
 * @see Corso
 * @see Docente
 * @see Edificio
 * @see Prenotazione
 */
public class ValidazioneException extends RuntimeException {

    /**
     * @brief Costruisce una nuova eccezione di validazione associata a uno specifico campo.
     *
     * @param[in] campo Nome identificativo del campo che ha violato il vincolo.
     * @param[in] messaggio Descrizione del vincolo violato destinata all'operatore.
     * @pre campo != null && !campo.isBlank()
     * @pre messaggio != null && !messaggio.isBlank()
     * @post getCampo() restituisce il nome del campo normalizzato e getMessage() il messaggio.
     */
    public ValidazioneException(String campo, String messaggio) {
        super(messaggio);
    }

    /**
     * @brief Restituisce il nome del campo che ha causato l'errore di validazione.
     *
     * @return Nome del campo coinvolto.
     */
    public String getCampo() {
      return null;
    }
}