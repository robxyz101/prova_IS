package it.unisa.diem.softeng.aulin.model;

/**
 * @brief Tipologia di attività didattica o accademica associabile a una prenotazione.
 *
 * Classifica l'evento prenotato in un'aula secondo le categorie previste
 * dai requisiti di dominio (FI1.1, ED5.1).
 *
 * @see Prenotazione
 */
public enum TipoAttivita {
    /** Lezione frontale o esercitazione didattica. */
    LEZIONE,
    /** Appello d'esame o prova di valutazione. */
    ESAME,
    /** Seminario, conferenza o evento scientifico. */
    SEMINARIO,
    /** Altra attività istituzionale non rientrante nelle precedenti. */
    ALTRO
}
