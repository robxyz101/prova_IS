
package it.unisa.diem.softeng.aulin.model;

import java.util.Objects;

/**
 * @brief Rappresenta un'aula didattica o laboratorio prenotabile.
 *
 * Ogni aula è identificata univocamente dal proprio codice e contiene
 * informazioni relative alla denominazione, all'edificio in cui si trova,
 * al piano e alla capienza massima.
 *
 * L'edificio è rappresentato direttamente mediante un oggetto Edificio,
 * consentendo di mantenere il collegamento con la relativa anagrafica.
 *
 * @invariant codice != null && !codice.isBlank()
 * @invariant nome != null && !nome.isBlank()
 * @invariant edificio != null
 * @invariant piano != null && !piano.isBlank()
 * @invariant capienza > 0
 *
 * @see Prenotazione
 * @see Edificio
 */
public class Aula {

    private String codice;
    private String nome;
    private Edificio edificio;
    private String piano;
    private int capienza;

    /**
     * @brief Costruisce una nuova aula validando i campi obbligatori.mail
     * L'aula viene associata direttamente all'oggetto Edificio ricevuto,
     * mantenendo il riferimento all'entità presente nel modello.mail
     *
     * @param[in] codice Codice identificativo univoco dell'aula.
     * @param[in] nome Denominazione descrittiva dell'aula.
     * @param[in] edificio Oggetto Edificio in cui si trova l'aula.
     * @param[in] piano Piano o livello dell'edificio.
     * @param[in] capienza Numero massimo di posti disponibili.mail
     *
     * @pre codice != null && codice.trim().matches("^[A-Za-z0-9-]{2,15}$")
     * @pre nome != null && !nome.trim().isEmpty()
     * @pre edificio != null
     * @pre piano != null && !piano.trim().isEmpty()
     * @pre capienza > 0
     *
     * @post getCodice() restituisce il codice normalizzato in maiuscolo.
     * @post getNome(), getPiano() restituiscono i rispettivi valori normalizzati.
     * @post getEdificio() restituisce l'oggetto Edificio ricevuto.
     *
     * @throws ValidazioneException Se uno dei parametri non rispetta
     * i vincoli previsti.
     */
    public Aula(String codice, String nome, Edificio edificio,
                String piano, int capienza) {

    }

    /**
     * @brief Aggiorna i dati dell'aula.
     *
     * Modifica il codice identificativo, la denominazione, l'edificio,
     * il piano e la capienza dell'aula.mail
     * L'aggiornamento deve avvenire atomicamente: se uno dei parametri
     * non è valido, lo stato precedente dell'oggetto deve essere mantenuto.
     *
     * @param[in] codice Nuovo codice identificativo dell'aula.
     * @param[in] nome Nuova denominazione dell'aula.
     * @param[in] edificio Nuovo oggetto Edificio associato all'aula.
     * @param[in] piano Nuovo piano dell'aula.
     * @param[in] capienza Nuova capienza massima.
     *
     * @pre Tutti i parametri rispettano le stesse precondizioni del costruttore.
     *
     * @post Tutti i campi dell'aula risultano aggiornati e normalizzati.
     *
     * @throws ValidazioneException Se almeno un parametro non rispetta
     * i vincoli previsti. Lo stato precedente rimane invariato.
     */
    public void modifica(String codice, String nome, Edificio edificio,
                         String piano, int capienza) {

    }

    /**
     * @brief Verifica se la capienza dell'aula soddisfa una soglia minima.
     *mail @param[in] capienzaMinima Numero minimo di posti richiesti.
     *mail @return true se la capienza dell'aula è maggiore o uguale
     * alla soglia richiesta, false altrimenti.
     */
    public boolean haCapienzaSufficiente(int capienzaMinima) {
        return false;
    }

    /**
     * @brief Restituisce il codice identificativo dell'aula.
     *mail @return Codice identificativo normalizzato in maiuscolo.
     */
    public String getCodice() {
        return codice;
    }

    /**
     * @brief Aggiorna il codice identificativo dell'aula.mail
     * @param[in] codice Nuovo codice identificativo.mail
     * @pre codice != null && codice.trim().matches("^[A-Za-z0-9-]{2,15}$")mail
     * @post getCodice() restituisce il nuovo codice normalizzato.mail
     * @throws ValidazioneException Se il codice non rispetta
     * il formato previsto.
     */
    public void setCodice(String codice) {

        this.codice = codice;
    }

    /**
     * @brief Restituisce la denominazione descrittiva dell'aula.mail
     * @return Nome dell'aula.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @brief Aggiorna la denominazione descrittiva dell'aula.
     *mail @param[in] nome Nuova denominazione dell'aula.
     *mail @pre nome != null && !nome.trim().isEmpty()
     *mail @post getNome() restituisce il nuovo nome normalizzato.
     * @throws ValidazioneException Se il nome è nullo o vuoto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @brief Restituisce l'edificio in cui è situata l'aula.
     * @return Oggetto Edificio associato all'aula.
     */
    public Edificio getEdificio() {
        return edificio;
    }

    /**
     * @brief Aggiorna l'edificio in cui è situata l'aula.
     * @param[in] edificio Nuovo oggetto Edificio associato all'aula.
     * @pre edificio != null @post getEdificio() restituisce il nuovo edificio associato.
     * @throws ValidazioneException Se l'edificio è null.
     */
    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    /**
     * @brief Restituisce il piano in cui è situata l'aula.
     * @return Piano dell'aula.
     */
    public String getPiano() {
        return piano;
    }

    /**
     * @brief Aggiorna il piano in cui è situata l'aula.
     * @param[in] piano Nuovo piano dell'aula.mail
     * @pre piano != null && !piano.trim().isEmpty()mail
     * @post getPiano() restituisce il nuovo piano normalizzato.mail
     * @throws ValidazioneException Se il piano è nullo o vuoto.
     */
    public void setPiano(String piano) {
        this.piano = piano;
    }

    /**
     * @brief Restituisce la capienza massima dell'aula.
     *mail @return Numero massimo di posti disponibili.
     */
    public int getCapienza() {
        return capienza;
    }

    /**
     * @brief Aggiorna la capienza massima dell'aula.mail
     * @param[in] capienza Nuova capienza dell'aula.mail
     * @pre capienza > 0mail
     * @post getCapienza() restituisce il nuovo valore.mail
     * @throws ValidazioneException Se la capienza non è positiva.
     */
    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    /**
     * @brief Confronta due aule in base ai rispettivi attributi.mail
     * @param[in] o Oggetto da confrontare.mail
     * @return true se l'oggetto è un'Aula con gli stessi valori
     * di tutti gli attributi, false altrimenti.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Aula aula = (Aula) o;

        return capienza == aula.capienza
                && Objects.equals(codice, aula.codice)
                && Objects.equals(nome, aula.nome)
                && Objects.equals(edificio, aula.edificio)
                && Objects.equals(piano, aula.piano);
    }

    /**
     * @brief Calcola il codice hash dell'aula.mail
     * Il calcolo utilizza gli stessi attributi considerati dal metodo
     * equals(), rispettando il relativo contratto.mail
     * @return Codice hash dell'aula.mail
     * @see #equals(Object)
     */
    @Override
    public int hashCode() {
        return Objects.hash(codice, nome, edificio, piano, capienza);
    }
}
