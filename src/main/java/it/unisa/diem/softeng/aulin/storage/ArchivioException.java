package it.unisa.diem.softeng.aulin.storage;

/**
 * @brief Eccezione controllata per errori di accesso o persistenza dell'archivio.
 *
 * Viene lanciata dalle operazioni di {@link ArchivioDati} quando il file di archivio
 * risulta illeggibile, danneggiato, semanticamente non valido oppure non scrivibile.
 *
 * @see ArchivioDati
 * @see ArchivioFile
 */
public class ArchivioException extends Exception {

    /**
     * @brief Costruisce una nuova eccezione con un messaggio descrittivo.
     *
     * @param[in] messaggio Descrizione dell'errore destinata al chiamante.
     * @pre messaggio != null && !messaggio.isBlank()
     * @post getMessage() restituisce il messaggio specificato.
     */
    public ArchivioException(String messaggio) {
        super(messaggio);
    }

    /**
     * @brief Costruisce una nuova eccezione con messaggio e causa originaria.
     *
     * @param[in] messaggio Descrizione dell'errore.
     * @param[in] causa Eccezione di basso livello (es. IOException) che ha provocato l'errore.
     * @pre messaggio != null && !messaggio.isBlank()
     * @post getMessage() restituisce messaggio e getCause() restituisce causa.
     */
    public ArchivioException(String messaggio, Throwable causa) {
        super(messaggio, causa);
    }
}