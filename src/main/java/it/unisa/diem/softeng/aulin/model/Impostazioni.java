package it.unisa.diem.softeng.aulin.model;

/**
 * @brief Rappresenta le preferenze globali di configurazione dell'applicazione.
 *
 * Memorizza lo stato di attivazione delle notifiche e-mail ai docenti e la
 * modalità di visualizzazione grafica attiva (ED6.1, FI10.7, IU5.1).
 *
 * @invariant modalitaVisualizzazione != null
 * @see ModalitaVisualizzazione
 */
public class Impostazioni {
    private boolean notificheAttive = true;
    private ModalitaVisuaizzazione modalita;

    /**
     * @brief Costruisce le impostazioni con i valori predefiniti di sistema.
     *
     * @post isNotificheAttive() == true
     * @post getModalitaVisualizzazione() == ModalitaVisualizzazione.NORMALE
     */
    public Impostazioni() {
    }

    /**
     * @brief Costruisce le impostazioni con i parametri specificati.
     *
     * @param[in] notificheAttive true per abilitare l'invio di e-mail ai docenti, false altrimenti.
     * @param[in] modalitaVisualizzazione Tema grafico da applicare all'interfaccia.
     * @pre modalitaVisualizzazione != null
     * @post isNotificheAttive() == notificheAttive
     * @post getModalitaVisualizzazione() == modalitaVisualizzazione
     * @throws ValidazioneException Se modalitaVisualizzazione è null.
     */
    public Impostazioni(boolean notificheAttive, ModalitaVisuaizzazione modalita) {
        this.notificheAttive = notificheAttive;
        this.modalita = modalita;
    }

    /**
     * @brief Indica se l'invio automatico delle notifiche e-mail è attivo.
     *
     * @return true se le notifiche sono attive, false altrimenti.
     */
    public boolean isNotificheAttive() {
        return notificheAttive;
    }

    /**
     * @brief Abilita o disabilita l'invio delle notifiche e-mail ai docenti.
     *
     * @param[in] attive Nuovo stato di attivazione delle notifiche.
     * @post isNotificheAttive() == attive
     */
    public void setNotificheAttive(boolean notificheAttive) {
        this.notificheAttive = notificheAttive;
    }

    /**
     * @brief Restituisce la modalità di visualizzazione correntemente selezionata.
     *
     * @return Modalità di visualizzazione attiva (mai null).
     */
    public ModalitaVisuaizzazione getModalitaVisualizzazione() {
        return modalita;
    }

    /**
     * @brief Imposta la modalità di visualizzazione grafica.
     *
     * @param[in] modalita Nuova modalità di visualizzazione.
     * @pre modalita != null
     * @post getModalitaVisualizzazione() == modalita
     * @throws ValidazioneException Se modalita è null.
     */
    public void setModalitaVisualizzazione(ModalitaVisuaizzazione modalita) {
        this.modalita = modalita;
    }
}
