package it.unisa.diem.softeng.aulin.model;

import java.util.regex.Pattern;

public class Formati {
    private final Pattern CODICE_AULA = Pattern.compile("^[A-Za-z0-9-]{2,15}$");
    private static final Pattern EMAIL = Pattern.compile("^[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(\\.[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@([A-Za-z0-9]([A-Za-z0-9-]{0,61}[A-Za-z0-9])?\\.)+[A-Za-z0-9]([A-Za-z0-9-]{0,61}[A-Za-z0-9])?$");

    /**
     * @brief Verifica se il codice rispetta il formato richiesto
     *
     * @post Se la stringa codice rispetta il pattern il metodo ritorna true, altrimenti false
     * @throws ValidazioneException Se codice è null.
     */
    public static boolean isCodiceAulaValido(String codice){
        return false;
    }

    /**
     * @brief Verifica se la mail rispetta il formato richiesto
     *
     * @post Se la mail rispetta il pattern il metodo ritorna true, altrimenti false
     * @throws ValidazioneException Se mail è null.
     */
    public static boolean isEmailValida(String codice){
        return false;
    }

    /**
     * @brief Formatta la stringa eliminando gli spazi iniziali e finali, ponendo in maiuscola la prima lettera.
     *
     * @post Ritorna la stringa formattata
     * @throws ValidazioneException Se string è null.
     */
    public static String formattaString(String string){
        return  string;
    }

}
