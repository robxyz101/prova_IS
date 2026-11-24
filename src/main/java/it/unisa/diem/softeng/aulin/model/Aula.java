package it.unisa.diem.softeng.aulin.model;

public class Aula {
    private String codice;
    private String nome;
    private String edificio;
    private String piano;
    private int capienza;

    /**
     * Pippo tanto
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
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
