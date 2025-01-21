package it.unimol.assicurazioni.app;

import it.unimol.assicurazioni.exceptions.WrongCodiceFiscaleException;

import java.util.regex.Pattern;

public class CodiceFiscaleValidator {
    public static boolean isCodiceFiscaleValido(String targa) throws WrongCodiceFiscaleException {
        // Espressione regolare per il formato del codice fiscale italiano
        final String pattern = "^[A-Z]{6}[0-9]{2}[A-EHLMPR-T][0-9]{2}[A-Z0-9]{4}[A-Z]$";
        if(!Pattern.matches(pattern, targa))
            throw new WrongCodiceFiscaleException("Codice fiscale non valido");
        return true;
    }
}
