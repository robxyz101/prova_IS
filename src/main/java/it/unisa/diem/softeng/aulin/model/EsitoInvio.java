package it.unisa.diem.softeng.aulin.model;

/**
 * @brief Esito dell'operazione di invio di una notifica e-mail al docente.
 *
 * Permette ai servizi applicativi di comunicare all'interfaccia utente il risultato
 * della notifica senza annullare l'operazione principale sulla prenotazione (FI10.5, IS2).
 */
public enum EsitoInvio {
    /** La notifica e-mail è stata inviata con successo al server SMTP. */
    INVIATO,
    /** L'invio della notifica è fallito a causa di un errore di comunicazione o configurazione. */
    FALLITO,
    /** L'invio delle notifiche è disattivato nelle impostazioni o il servizio non è attivo. */
    NON_ATTIVO
}
