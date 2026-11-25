package it.unisa.diem.softeng.aulin.model;

import java.util.Objects;

/**
 * @brief Rappresenta un edificio registrato nell'anagrafica dipartimentale.
 *
 * Ogni edificio è identificato univocamente dal proprio nome, memorizzato senza
 * spazi iniziali o finali e confrontato senza distinzione tra maiuscole e minuscole (ED3.1).
 *
 * @invariant nome != null && !nome.isBlank()
 * @see Aula
 */
public class Edificio {
    private String nome;


    /**
     * @brief Costruisce un nuovo edificio validandone il nome.
     *
     * @param[in] nome Denominazione dell'edificio.
     * @pre nome != null && !nome.trim().isEmpty()
     * @post getNome().equals(nome.trim())
     * @throws ValidazioneException Se nome è nullo o vuoto.
     */
    public Edificio(String nome){

    }
    /**
     * @brief Restituisce il nome dell'edificio.
     *
     * @return Nome dell'edificio privo di spazi superflui.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @brief Aggiorna il nome dell'edificio verificando le invarianti.
     *
     * @param[in] nome Nuovo nome dell'edificio.
     * @pre nome != null && !nome.trim().isEmpty()
     * @post getNome().equals(nome.trim())
     * @throws ValidazioneException Se nome è nullo o vuoto (lo stato precedente resta invariato).
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @brief Confronta due edifici in base al nome senza distinzione tra maiuscole e minuscole.
     *
     * @param[in] o Oggetto da confrontare con l'istanza corrente.
     * @return true se o è un Edificio con lo stesso nome (case-insensitive), false altrimenti.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Edificio edificio = (Edificio) o;
        return Objects.equals(nome, edificio.nome);
    }

    /**
     * @brief Calcola il codice hash coerente con equals (basato sul nome in minuscolo).
     *
     * @return Valore hash dell'edificio.
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}
