package it.unisa.diem.softeng.aulin.service;

import it.unisa.diem.softeng.aulin.model.EsitoInvio;
import it.unisa.diem.softeng.aulin.model.Prenotazione;
import java.util.List;

/**
 * @brief Contratto astratto per l'invio delle notifiche ai docenti relative alle prenotazioni.
 *
 * Disaccoppia {@link PrenotazioneService} dai dettagli del canale di notifica (DIP, OCP),
 * consentendo di alternare l'invio SMTP reale ({@link NotificaMailService}) con
 * un'implementazione nulla ({@link NotificaNullService}) usata quando il servizio di posta
 * non è disponibile o nei test (UC14, BF10).
 * Per ogni operazione su una serie ricorrente viene inviata una sola notifica riepilogativa (FI10.4).
 *
 * @see NotificaMailService
 * @see NotificaNullService
 * @see EsitoInvio
 */
public interface NotificaService {

    /**
     * @brief Invia al docente la notifica di conferma per una prenotazione singola o una serie ricorrente.
     *
     * Se la lista contiene più occorrenze di una serie, produce un unico messaggio riepilogativo
     * indicando la periodicità e la data dell'ultima occorrenza come data di termine (FI10.1, FI10.4).
     *
     * @param[in] prenotazioni Elenco non vuoto delle prenotazioni confermate (1 per singola, N per serie).
     * @pre prenotazioni != null && !prenotazioni.isEmpty() e nessun elemento è null.
     * @return Esito dell'invio ({@link EsitoInvio#INVIATO}, {@link EsitoInvio#FALLITO} o {@link EsitoInvio#NON_ATTIVO}).
     * @post In caso di errore di recapito non viene sollevata alcuna eccezione e viene restituito FALLITO (FI10.5).
     */
    EsitoInvio inviaConferma(List<Prenotazione> prenotazioni);

    /**
     * @brief Invia al docente la notifica di avvenuta modifica di una o più occorrenze di prenotazione.
     *
     * @param[in] prenotazioni Elenco non vuoto delle prenotazioni modificate.
     * @pre prenotazioni != null && !prenotazioni.isEmpty() e nessun elemento è null.
     * @return Esito dell'invio ({@link EsitoInvio#INVIATO}, {@link EsitoInvio#FALLITO} o {@link EsitoInvio#NON_ATTIVO}).
     * @post In caso di errore di recapito non viene sollevata alcuna eccezione e viene restituito FALLITO (FI10.2, FI10.5).
     */
    EsitoInvio inviaModifica(List<Prenotazione> prenotazioni);

    /**
     * @brief Invia al docente la notifica di cancellazione di una singola occorrenza, occorrenze future o intera serie.
     *
     * @param[in] prenotazioni Elenco non vuoto delle prenotazioni cancellate.
     * @pre prenotazioni != null && !prenotazioni.isEmpty() e nessun elemento è null.
     * @return Esito dell'invio ({@link EsitoInvio#INVIATO}, {@link EsitoInvio#FALLITO} o {@link EsitoInvio#NON_ATTIVO}).
     * @post In caso di errore di recapito non viene sollevata alcuna eccezione e viene restituito FALLITO (FI10.3, FI10.5).
     */
    EsitoInvio inviaCancellazione(List<Prenotazione> prenotazioni);

    /**
     * @brief Ritenta l'invio dell'ultima notifica non recapitata memorizzata dal servizio.
     *
     * Consente all'operatore di riprovare l'invio su richiesta dopo un esito {@link EsitoInvio#FALLITO} (FI10.10).
     *
     * @return Esito del nuovo tentativo di invio, oppure {@link EsitoInvio#NON_ATTIVO} se non vi sono invii falliti o le notifiche sono disattivate.
     * @post Se il reinvio riesce, la notifica in sospeso viene rimossa dalla memoria del servizio.
     */
    EsitoInvio reinviaNotifica();
}
