package it.unisa.diem.softeng.aulin.model;

import java.util.Objects;

/**
 * @brief Rappresenta un'aula didattica o laboratorio prenotabile.
 *
 * Identificata univocamente dal codice (2-15 caratteri alfanumerici o trattini,
 * memorizzato in maiuscolo). Conserva la denominazione dell'edificio come stringa
 * per consentire sia l'uso libero sia la validazione tramite anagrafica edifici (ED2.1, ED2.2).
 *
 * @invariant codice != null && !codice.isBlank()
 * @invariant nome != null && !nome.isBlank()
 * @invariant edificio != null && !edificio.isBlank()
 * @invariant piano != null && !piano.isBlank()
 * @invariant capienza > 0
 * @see Prenotazione
 * @see Edificio
 */
public class Aula {
    private String codice;
    private String nome;
    private String edificio;
    private String piano;
    private int capienza;

    /**
     * @brief Costruisce una nuova aula validando tutti i campi obbligatori.
     *
     * @param[in] codice Codice identificativo univoco dell'aula (2-15 caratteri alfanumerici o trattino).
     * @param[in] nome Denominazione descrittiva dell'aula.
     * @param[in] edificio Nome dell'edificio in cui si trova l'aula.
     * @param[in] piano Piano o livello dell'edificio.
     * @param[in] capienza Numero massimo di posti disponibili.
     * @pre codice != null && codice.trim().matches("^[A-Za-z0-9-]{2,15}$")
     * @pre nome != null && !nome.trim().isEmpty()
     * @pre edificio != null && !edificio.trim().isEmpty()
     * @pre piano != null && !piano.trim().isEmpty()
     * @pre capienza > 0
     * @post getCodice().equals(codice.trim().toUpperCase()) e tutti gli altri campi sono normalizzati.
     * @throws ValidazioneException Se il codice non è valido, un testo è vuoto o capienza <= 0.
     */
    public Aula(String codice, String nome, String edficio, String piano, int capienza){

    }

    /**
     * @brief Aggiorna atomicamente tutti i dati dell'aula.
     *
     * @param[in] codice Nuovo codice identificativo dell'aula.
     * @param[in] nome Nuova denominazione dell'aula.
     * @param[in] edificio Nuovo nome dell'edificio.
     * @param[in] piano Nuovo piano.
     * @param[in] capienza Nuova capienza massima (strettamente positiva).
     * @pre Tutti i parametri rispettano le stesse precondizioni del costruttore.
     * @post Lo stato dell'aula riflette i nuovi valori normalizzati.
     * @throws ValidazioneException Se almeno un parametro viola le invarianti (lo stato resta invariato).
     */
    public void modifica(String codice, String nome, String edificio, String piano, int capienza) {

    }

    /**
     * @brief Verifica se la capienza dell'aula soddisfa una soglia minima richiesta.
     *
     * @param[in] capienzaMinima Numero minimo di posti richiesti.
     * @return true se getCapienza() >= capienzaMinima, false altrimenti.
     */
    public  boolean haCapienzaSufficiente(int capienzaMinima){
        return false;
    }

    /**
     * @brief Restituisce il codice identificativo dell'aula in maiuscolo.
     *
     * @return Codice dell'aula.
     */
    public String getCodice() {
        return codice;
    }

    /**
     * @brief Aggiorna il codice dell'aula verificando le invarianti.
     *
     * @param[in] codice Nuovo codice dell'aula.
     * @pre codice != null && !codice.trim().isEmpty()
     * @post getCodice().equals(codice.trim())
     * @throws ValidazioneException Se codice è nullo o vuoto (lo stato precedente resta invariato).
     */
    public void setCodice(String codice) {
        this.codice = codice;
    }

    /**
     * @brief Restituisce il nome descrittivo dell'aula.
     *
     * @return Nome dell'aula.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @brief Aggiorna il nome l'aula verificando le invarianti.
     *
     * @param[in] nome Nuovo nome l'aula.
     * @pre nome != null && !nome.trim().isEmpty()
     * @post getNome().equals(nome.trim())
     * @throws ValidazioneException Se nome è nullo o vuoto (lo stato precedente resta invariato).
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @brief Restituisce il nome dell'edificio in cui è situata l'aula.
     *
     * @return Denominazione dell'edificio.
     */
    public String getEdificio() {
        return edificio;
    }

    /**
     * @brief Aggiorna il edificio dove è collocata l'aula verificando le invarianti.
     *
     * @param[in] edificio Nuovo edificio dove e collocata l'aula.
     * @pre edificio != null
     * @post getEdificio().equals(edificio)
     * @throws ValidazioneException Se edificio è nullo o vuoto (lo stato precedente resta invariato).
     */
    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    /**
     * @brief Restituisce il piano dell'aula.
     *
     * @return Piano dell'aula.
     */
    public String getPiano() {
        return piano;
    }

    /**
     * @brief Aggiorna il piano dove si trova l'aula verificando le invarianti.
     *
     * @param[in] piano Nuovo piano dove e situata l'aula.
     * @pre piano != null && !piano.trim().isEmpty()
     * @post getPiano().equals(piano.trim())
     * @throws ValidazioneException Se piano è nullo o vuoto (lo stato precedente resta invariato).
     */
    public void setPiano(String piano) {
        this.piano = piano;
    }

    /**
     * @brief Restituisce la capienza massima dell'aula in numero di posti.
     *
     * @return Capienza dell'aula (> 0).
     */
    public int getCapienza() {
        return capienza;
    }

    /**
     * @brief Aggiorna il capienza dell'aula verificando le invarianti.
     *
     * @param[in] capienza Nuova capienza dell'aula.
     * @pre capienza > 0
     * @post getCapienza().equals(capienza)
     * @throws ValidazioneException Se capienza è minore di Zero (lo stato precedente resta invariato).
     */
    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    /**
     * @brief Confronta due aule in base al codice (case-insensitive).
     *
     * @param[in] o Oggetto da confrontare.
     * @return true se o è un'Aula con lo stesso codice, false altrimenti.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aula aula = (Aula) o;
        return capienza == aula.capienza && Objects.equals(codice, aula.codice) && Objects.equals(nome, aula.nome) && Objects.equals(edificio, aula.edificio) && Objects.equals(piano, aula.piano);
    }

    /**
     * @brief Calcola il codice hash basato sul codice dell'aula.
     *
     * @return Valore hash dell'aula.
     */
    @Override
    public int hashCode() {
        return Objects.hash(codice, nome, edificio, piano, capienza);
    }
}
