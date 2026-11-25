package it.unisa.diem.softeng.aulin.service;

import it.unisa.diem.softeng.aulin.model.EsitoInvio;
import it.unisa.diem.softeng.aulin.model.Prenotazione;
import java.util.List;

/**
 * @brief Realizzazione nulla (Null Object) del contratto {@link NotificaService}.
 *
 * Utilizzata quando il servizio di posta elettronica non è disponibile oppure durante
 * i test automatici JUnit (NF19), consentendo a {@link PrenotazioneService} di operare
 * senza controlli condizionali sulla presenza del servizio di notifica (LSP, OCP).
 * Tutte le operazioni non eseguono alcun invio e restituiscono {@link EsitoInvio#NON_ATTIVO}.
 *
 * @see NotificaService
 * @see NotificaMailService
 */
public class NotificaNullService implements NotificaService {

    /**
     * @brief Costruisce una nuova istanza del servizio di notifica nullo.
     */
    public NotificaNullService() {
    }

    /**
     * @brief Non esegue alcun invio di conferma.
     *
     * @param[in] prenotazioni Elenco delle prenotazioni confermate (ignorato).
     * @return Sempre {@link EsitoInvio#NON_ATTIVO}.
     */
    @Override
    public EsitoInvio inviaConferma(List<Prenotazione> prenotazioni) {
        return EsitoInvio.NON_ATTIVO;
    }

    /**
     * @brief Non esegue alcun invio di modifica.
     *
     * @param[in] prenotazioni Elenco delle prenotazioni modificate (ignorato).
     * @return Sempre {@link EsitoInvio#NON_ATTIVO}.
     */
    @Override
    public EsitoInvio inviaModifica(List<Prenotazione> prenotazioni) {
        return EsitoInvio.NON_ATTIVO;
    }

    /**
     * @brief Non esegue alcun invio di cancellazione.
     *
     * @param[in] prenotazioni Elenco delle prenotazioni cancellate (ignorato).
     * @return Sempre {@link EsitoInvio#NON_ATTIVO}.
     */
    @Override
    public EsitoInvio inviaCancellazione(List<Prenotazione> prenotazioni) {
        return EsitoInvio.NON_ATTIVO;
    }

    /**
     * @brief Non esegue alcun reinvio di notifica.
     *
     * @return Sempre {@link EsitoInvio#NON_ATTIVO}.
     */
    @Override
    public EsitoInvio reinviaNotifica() {
        return EsitoInvio.NON_ATTIVO;
    }
}
