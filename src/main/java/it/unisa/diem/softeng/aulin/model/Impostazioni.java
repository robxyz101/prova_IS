package it.unisa.diem.softeng.aulin.model;

public class Impostazioni {
    private boolean notificheAttive = true;
    private ModalitaVisuaizzazione modalita;

    /**
     *
     */
    public Impostazioni() {
    }

    /**
     *
     * @param notificheAttive
     * @param modalita
     */
    public Impostazioni(boolean notificheAttive, ModalitaVisuaizzazione modalita) {
        this.notificheAttive = notificheAttive;
        this.modalita = modalita;
    }

    public boolean isNotificheAttive() {
        return notificheAttive;
    }

    public void setNotificheAttive(boolean notificheAttive) {
        this.notificheAttive = notificheAttive;
    }

    public ModalitaVisuaizzazione getModalita() {
        return modalita;
    }

    public void setModalita(ModalitaVisuaizzazione modalita) {
        this.modalita = modalita;
    }
}
