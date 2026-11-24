package it.unisa.diem.softeng.aulin.model;

import java.util.Objects;

public class Docente {
    private String mail;
    private String nome;
    private String cognome;


    /**
     *
     * @param mail
     * @param nome
     * @param cognome
     */

    public Docente (String mail, String nome, String cognome){

    }

    public void modifica(String mail, String nome, String cognome){

    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Docente docente = (Docente) o;
        return Objects.equals(mail, docente.mail) && Objects.equals(nome, docente.nome) && Objects.equals(cognome, docente.cognome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail, nome, cognome);
    }
}
