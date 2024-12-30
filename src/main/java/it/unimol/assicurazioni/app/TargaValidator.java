package it.unimol.assicurazioni.app;

import it.unimol.assicurazioni.exceptions.WrongTargaException;

import java.util.regex.Pattern;

public class TargaValidator {
    public static boolean isTargaItalianaValida(String targa) throws WrongTargaException {
        // Espressione regolare per il formato delle targhe italiane
        String pattern = "^[A-HJ-NP-Z]{2}\\\\d{3}[A-HJ-NP-Z]{2}$";
         if(!Pattern.matches(pattern, targa))
             throw new WrongTargaException("Targa non valida");
         return true;
    }
}
