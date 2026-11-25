package it.unisa.diem.softeng.aulin.model;

/**
 * @brief Modalità di visualizzazione grafica dell'interfaccia utente.
 *
 * Definisce i temi cromatici supportati dall'applicazione per l'accessibilità
 * e il comfort visivo (IU5.1, IU5.2, NF12).
 *
 * @see Impostazioni
 */
public enum ModalitaVisuaizzazione {
    /** Tema grafico predefinito standard. */
    NORMALE,
    /** Tema ad alto contrasto (rapporto di contrasto testo/sfondo >= 4,5:1). */
    HIGH_CONTRAST,
    /** Tema con tonalità calde per ridurre l'affaticamento visivo. */
    EYE_REST
}
