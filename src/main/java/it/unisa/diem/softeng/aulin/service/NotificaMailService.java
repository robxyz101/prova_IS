package it.unisa.diem.softeng.aulin.service;

import it.unisa.diem.softeng.aulin.model.EsitoInvio;
import it.unisa.diem.softeng.aulin.model.Prenotazione;
import it.unisa.diem.softeng.aulin.storage.ArchivioDati;
import java.util.List;

/**
 * @brief Realizzazione di {@link NotificaService} basata sull'invio di e-mail tramite server SMTP.
 *
 * Utilizza l'indirizzo "Aul-In" di sistema preimpostato come mittente (FI10.6, ED6.2, IS1).
 * A ogni invio verifica dinamicamente lo stato delle notifiche nelle impostazioni dell'archivio:
 * se disattivate, restituisce {@link EsitoInvio#NON_ATTIVO} senza contattare il server SMTP (FI10.7-FI10.9).
 * L'invio viene eseguito in modo sincrono nel thread chiamante (demandando l'esecuzione in background
 * al livello UI per rispettare NF9). Un fallimento del server SMTP non annulla l'operazione sulla
 * prenotazione, memorizza il messaggio in {@code ultimoInvioFallito} per consentire il reinvio (FI10.10)
 * e restituisce {@link EsitoInvio#FALLITO} (FI10.5, IS2).
 *
 * @invariant archivio != null
 * @invariant mittenteSistema != null && !mittenteSistema.trim().isEmpty()
 * @see NotificaService
 * @see ArchivioDati
 */
public class NotificaMailService implements NotificaService {

    private final ArchivioDati archivio;
    private final String mittenteSistema;

    /**
     * Ultimo messaggio e-mail non recapitato, conservato in memoria per il reinvio (FI10.10).
     * Nota: tipizzare come {@code jakarta.mail.Message} dopo aver aggiunto la dipendenza Jakarta Mail al pom.xml.
     */
    private Object ultimoInvioFallito;

    /**
     * @brief Costruisce il servizio di notifica e-mail collegandolo all'archivio e al mittente di sistema.
     *
     * @param[in] archivio Archivio dati da cui leggere dinamicamente lo stato di attivazione delle notifiche.
     * @param[in] mittenteSistema Indirizzo e-mail di sistema utilizzato come mittente delle comunicazioni.
     * @pre archivio != null
     * @pre mittenteSistema != null && !mittenteSistema.trim().isEmpty()
     * @post Il servizio è pronto a inviare notifiche SMTP e non ha alcun invio fallito in sospeso.
     */
    public NotificaMailService(ArchivioDati archivio, String mittenteSistema) {
        this.archivio = archivio;
        this.mittenteSistema = mittenteSistema;
    }

    /**
     * @brief Invia un'e-mail di conferma al docente per le prenotazioni indicate.
     *
     * Se le notifiche risultano disattivate nelle impostazioni correnti dell'archivio,
     * non contatta il server SMTP e restituisce {@link EsitoInvio#NON_ATTIVO}.
     * Per una serie ricorrente la data di termine riportata nel corpo è la data dell'ultima occorrenza.
     *
     * @param[in] prenotazioni Elenco non vuoto delle prenotazioni confermate.
     * @pre prenotazioni != null && !prenotazioni.isEmpty()
     * @return {@link EsitoInvio#INVIATO} se recapitata, {@link EsitoInvio#FALLITO} in caso di errore SMTP,
     *         {@link EsitoInvio#NON_ATTIVO} se l'invio è disattivato.
     * @post In caso di fallimento il messaggio preparato è salvato per un successivo {@link #reinviaNotifica()}.
     */
    @Override
    public EsitoInvio inviaConferma(List<Prenotazione> prenotazioni) {
        return EsitoInvio.NON_ATTIVO;
    }

    /**
     * @brief Invia un'e-mail di notifica modifica al docente per le prenotazioni aggiornate.
     *
     * @param[in] prenotazioni Elenco non vuoto delle prenotazioni modificate.
     * @pre prenotazioni != null && !prenotazioni.isEmpty()
     * @return {@link EsitoInvio#INVIATO} se recapitata, {@link EsitoInvio#FALLITO} in caso di errore SMTP,
     *         {@link EsitoInvio#NON_ATTIVO} se l'invio è disattivato.
     * @post In caso di fallimento il messaggio preparato è salvato per un successivo {@link #reinviaNotifica()}.
     */
    @Override
    public EsitoInvio inviaModifica(List<Prenotazione> prenotazioni) {
        return EsitoInvio.NON_ATTIVO;
    }

    /**
     * @brief Invia un'e-mail di notifica cancellazione al docente per le prenotazioni eliminate.
     *
     * @param[in] prenotazioni Elenco non vuoto delle prenotazioni cancellate.
     * @pre prenotazioni != null && !prenotazioni.isEmpty()
     * @return {@link EsitoInvio#INVIATO} se recapitata, {@link EsitoInvio#FALLITO} in caso di errore SMTP,
     *         {@link EsitoInvio#NON_ATTIVO} se l'invio è disattivato.
     * @post In caso di fallimento il messaggio preparato è salvato per un successivo {@link #reinviaNotifica()}.
     */
    @Override
    public EsitoInvio inviaCancellazione(List<Prenotazione> prenotazioni) {
        return EsitoInvio.NON_ATTIVO;
    }

    /**
     * @brief Ritenta l'invio tramite SMTP dell'ultimo messaggio non recapitato.
     *
     * @return {@link EsitoInvio#INVIATO} se il reinvio riesce, {@link EsitoInvio#FALLITO} se l'errore persiste,
     *         {@link EsitoInvio#NON_ATTIVO} se le notifiche sono disattivate o non esiste alcun invio fallito.
     * @post Se l'invio riesce, {@code ultimoInvioFallito} viene azzerato (impostato a null).
     */
    @Override
    public EsitoInvio reinviaNotifica() {
        return EsitoInvio.NON_ATTIVO;
    }
}
