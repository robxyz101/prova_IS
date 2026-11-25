package it.unisa.diem.softeng.aulin.model;

import java.util.Objects;

public class Aula {
    private String codice;
    private String nome;
    private String edificio;
    private String piano;
    private int capienza;

    /**
     *
     * @param codice
     * @param nome
     * @param edficio
     * @param piano
     * @param capienza
     */
    public Aula(String codice, String nome, String edficio, String piano, int capienza){

    }

    public  boolean haCapienzaSufficiente(int capienzaMinima){
        return false;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public String getPiano() {
        return piano;
    }

    public void setPiano(String piano) {
        this.piano = piano;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aula aula = (Aula) o;
        return capienza == aula.capienza && Objects.equals(codice, aula.codice) && Objects.equals(nome, aula.nome) && Objects.equals(edificio, aula.edificio) && Objects.equals(piano, aula.piano);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codice, nome, edificio, piano, capienza);
    }
}
