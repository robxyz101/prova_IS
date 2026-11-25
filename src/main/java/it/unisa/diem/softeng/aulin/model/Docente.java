package it.unisa.diem.softeng.aulin.model;

import java.util.Objects;

/**
 * @brief Rappresenta un docente titolare o richiedente di prenotazioni.
 *
 * Identificato univocamente dall'indirizzo e-mail istituzionale/personale,
 * memorizzato in minuscolo e privo di spazi superflui (ED1.1, FI7.1, FI7.2).
 *
 * @invariant mail != null && !mail.isBlank()
 * @invariant nome != null && !nome.isBlank()
 * @invariant cognome != null && !cognome.isBlank()
 * @see Prenotazione
 */
public class Docente {
    private String mail;
    private String nome;
    private String cognome;

    /**
     * @brief Costruisce un nuovo docente validando e-mail, nome e cognome.
     *
     * @param[in] mail Indirizzo e-mail univoco del docente.
     * @param[in] nome Nome proprio del docente.
     * @param[in] cognome Cognome del docente.
     * @pre mail != null && mail.trim() rispetta il formato e-mail standard
     * @pre nome != null && !nome.trim().isEmpty()
     * @pre cognome != null && !cognome.trim().isEmpty()
     * @post getmail().equals(mail.trim().toLowerCase())
     * @post getNome().equals(nome.trim()) && getCognome().equals(cognome.trim())
     * @throws ValidazioneException Se l'e-mail è malformata o uno dei campi è nullo/vuoto.
     */
    public Docente (String mail, String nome, String cognome){

    }

    /**
     * @brief Aggiorna atomicamente i dati anagrafici del docente.
     *
     * @param[in] mail Nuovo indirizzo e-mail del docente.
     * @param[in] nome Nuovo nome del docente.
     * @param[in] cognome Nuovo cognome del docente.
     * @pre mail != null && mail.trim() rispetta il formato e-mail standard
     * @pre nome != null && !nome.trim().isEmpty()
     * @pre cognome != null && !cognome.trim().isEmpty()
     * @post Tutti gli attributi sono aggiornati e normalizzati.
     * @throws ValidazioneException Se almeno un campo non è valido (lo stato resta invariato).
     */
    public void modifica(String mail, String nome, String cognome){

    }

    /**
     * @brief Restituisce l'indirizzo mail del docente normalizzato in minuscolo.
     *
     * @return mail del docente.
     */
    public String getMail() {
        return mail;
    }

    /**
     * @brief Aggiorna il mail del docente verificando le invarianti.
     *
     * @param[in] mail Nuovo mail del docente.
     * @pre mail != null && !mail.trim().isEmpty()
     * @post getMail().equals(mail.trim())
     * @throws ValidazioneException Se nome è nullo o vuoto (lo stato precedente resta invariato).
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @brief Restituisce il nome del docente.
     *
     * @return Nome del docente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @brief Aggiorna il nome del docente verificando le invarianti.
     *
     * @param[in] nome Nuovo nome del docente.
     * @pre nome != null && !nome.trim().isEmpty()
     * @post getNome().equals(nome.trim())
     * @throws ValidazioneException Se nome è nullo o vuoto (lo stato precedente resta invariato).
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @brief Restituisce il cognome del docente.
     *
     * @return Cognome del docente.
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @brief Aggiorna il cognome del docente verificando le invarianti.
     *
     * @param[in] cognome Nuovo cognome del docente.
     * @pre cognome != null && !cognome.trim().isEmpty()
     * @post getCognome().equals(cognome.trim())
     * @throws ValidazioneException Se cognome è nullo o vuoto (lo stato precedente resta invariato).
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @brief Confronta due docenti in base all'indirizzo e-mail (case-insensitive).
     *
     * @param[in] o Oggetto da confrontare.
     * @return true se o è un Docente con la stessa e-mail, false altrimenti.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Docente docente = (Docente) o;
        return Objects.equals(mail, docente.mail) && Objects.equals(nome, docente.nome) && Objects.equals(cognome, docente.cognome);
    }

    /**
     * @brief Calcola il codice hash basato sull'indirizzo e-mail.
     *
     * @return Valore hash del docente.
     */
    @Override
    public int hashCode() {
        return Objects.hash(mail, nome, cognome);
    }
}
