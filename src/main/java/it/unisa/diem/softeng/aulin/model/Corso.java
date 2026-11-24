package it.unisa.diem.softeng.aulin.model;

import java.util.Objects;

public class Corso {

    private String codice;
    private String denominazione;

    /**
     *
     * @param codice
     * @param denominazione
     */
    public Corso(String codice, String denominazione){

    }

    public void modifica(String codice, String denominazione){

    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Corso corso = (Corso) o;
        return Objects.equals(codice, corso.codice) && Objects.equals(denominazione, corso.denominazione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codice, denominazione);
    }
}
