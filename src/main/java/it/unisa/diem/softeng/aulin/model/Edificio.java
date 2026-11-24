package it.unisa.diem.softeng.aulin.model;

import java.util.Objects;

public class Edificio {
    private String nome;


    /**
     *
     * @param nome
     */
    public Edificio(String nome){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Edificio edificio = (Edificio) o;
        return Objects.equals(nome, edificio.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}
