package it.unisa.diem.softeng.aulin.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

public class Prenotazione {

    private String id;
    private Aula aula;
    private Docente docente;
    private Corso corso;
    private TipoAttivita tipologia;
    private String denominazione;
    private LocalDate data;
    private LocalTime orarioInizio;
    private LocalTime orarioFine;
    private String idSerie; // usiamo NULL come valore per riconoscere se fa parte di una serie


    /**
     *
     * @param aula
     * @param docente
     * @param corso
     * @param tipologia
     * @param denominazione
     * @param data
     * @param orarioInizio
     * @param orarioFine
     */
    public Prenotazione(Aula aula, Docente docente, Corso corso, TipoAttivita tipologia, String denominazione, LocalDate data, LocalTime orarioInizio, LocalTime orarioFine) {
        this.id = UUID.randomUUID().toString();

        this.aula = aula;
        this.docente = docente;
        this.corso = corso;
        this.tipologia = tipologia;
        this.denominazione = denominazione;
        this.data = data;
        this.orarioInizio = orarioInizio;
        this.orarioFine = orarioFine;
    }

    /**
     *
     * @param aula
     * @param docente
     * @param corso
     * @param tipologia
     * @param denominazione
     * @param data
     * @param orarioInizio
     * @param orarioFine
     * @param idSerie
     */
    public Prenotazione(Aula aula, Docente docente, Corso corso, TipoAttivita tipologia, String denominazione, LocalDate data, LocalTime orarioInizio, LocalTime orarioFine, String idSerie) {
        this(aula, docente, corso, tipologia, denominazione, data, orarioInizio, orarioFine);
        this.idSerie = idSerie;
    }


    /**
     * @brief Questo costrutore serve per creare le prenotazioni da caricamento file, percio contiene id che deve essere caricato da FILE e non generato d'accapo
     * @param id
     * @param aula
     * @param docente
     * @param corso
     * @param tipologia
     * @param denominazione
     * @param data
     * @param orarioInizio
     * @param orarioFine
     */
    public Prenotazione(String id,Aula aula, Docente docente, Corso corso, TipoAttivita tipologia, String denominazione, LocalDate data, LocalTime orarioInizio, LocalTime orarioFine) {
        this(aula, docente, corso, tipologia, denominazione, data, orarioInizio, orarioFine);
        this.id = id;
    }


    /**
     * @brief Questo costrutore serve per creare le prenotazioni da caricamento file, percio contiene id e idSerie che devono essere caricati da FILE e non generati d'accapo
     * @param id
     * @param aula
     * @param docente
     * @param corso
     * @param tipologia
     * @param denominazione
     * @param data
     * @param orarioInizio
     * @param orarioFine
     * @param idSerie
     */
    public Prenotazione(String id,Aula aula, Docente docente, Corso corso, TipoAttivita tipologia, String denominazione, LocalDate data, LocalTime orarioInizio, LocalTime orarioFine, String idSerie){
        this(id, aula, docente, corso, tipologia, denominazione, data, orarioInizio, orarioFine);
        this.idSerie = idSerie;
    }


    public void modifica(Aula aula, Docente docente, Corso corso, TipoAttivita tipologia, String denominazione, LocalDate data, LocalTime orarioInizio, LocalTime orarioFine){

    }

    public void modifica(Aula aula, Docente docente, Corso corso, TipoAttivita tipologia, String denominazione, LocalDate data, LocalTime orarioInizio, LocalTime orarioFine, String idSerie){

    }

    public boolean isRicorente(){
        return idSerie != null;
    }

    public boolean siSovrapponeA(Prenotazione altra){
        return false;
    }

    public String getId() {
        return id;
    }

    public Aula getAula() {
        return aula;
    }

    public Docente getDocente() {
        return docente;
    }

    public Corso getCorso() {
        return corso;
    }

    public TipoAttivita getTipologia() {
        return tipologia;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getOrarioInizio() {
        return orarioInizio;
    }

    public LocalTime getOrarioFine() {
        return orarioFine;
    }

    public String getIdSerie() {
        return idSerie;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Prenotazione that = (Prenotazione) o;
        return Objects.equals(id, that.id) && Objects.equals(aula, that.aula) && Objects.equals(docente, that.docente) && Objects.equals(corso, that.corso) && tipologia == that.tipologia && Objects.equals(denominazione, that.denominazione) && Objects.equals(data, that.data) && Objects.equals(orarioInizio, that.orarioInizio) && Objects.equals(orarioFine, that.orarioFine) && Objects.equals(idSerie, that.idSerie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, aula, docente, corso, tipologia, denominazione, data, orarioInizio, orarioFine, idSerie);
    }
}
