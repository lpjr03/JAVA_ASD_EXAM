package it.unimol.assicurazioni.app;

import it.unimol.assicurazioni.exceptions.WrongTargaException;
import java.util.regex.Pattern;

/**
 * Classe di utilità per la validazione delle targhe italiane.
 * Questa classe fornisce un metodo per verificare se una targa automobilistica
 * rispetta il formato standard italiano.
 */
public class TargaValidator {

    /**
     * Verifica se una targa automobilistica fornita è valida secondo il formato italiano.
     *
     * Il formato italiano per le targhe prevede due lettere iniziali, seguite da tre cifre
     * e due lettere finali (esempio: "AB123CD").
     *
     * @param targa La targa da validare. Deve rispettare il formato standard italiano.
     * @return {@code true} se la targa è valida.
     * @throws WrongTargaException Se la targa non rispetta il formato richiesto.
     */
    public static boolean isTargaItalianaValida(String targa) throws WrongTargaException {
        // Espressione regolare per il formato delle targhe italiane
        final String pattern = "^[A-Z]{2}\\d{3}[A-Z]{2}$";
        if (!Pattern.matches(pattern, targa))
            throw new WrongTargaException("Targa non valida");
        return true;
    }
}
