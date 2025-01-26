package it.unimol.assicurazioni.app;

import it.unimol.assicurazioni.exceptions.WrongCodiceFiscaleException;
import java.util.regex.Pattern;

/**
 * Classe di utilità per la validazione dei codici fiscali italiani.
 * Questa classe fornisce un metodo per verificare se un dato codice fiscale
 * rispetta il formato standard utilizzando un'espressione regolare.
 */
public class CodiceFiscaleValidator {

    /**
     * Verifica se un codice fiscale fornito è valido.
     *
     * @param targa Il codice fiscale da validare. Deve rispettare il formato
     *              standard italiano: 6 lettere maiuscole, 2 cifre, 1 carattere
     *              specifico, 2 cifre, 4 caratteri alfanumerici e una lettera finale.
     * @return {@code true} se il codice fiscale è valido.
     * @throws WrongCodiceFiscaleException Se il codice fiscale non rispetta il formato richiesto.
     */
    public static boolean isCodiceFiscaleValido(String targa) throws WrongCodiceFiscaleException {
        // Espressione regolare per il formato del codice fiscale italiano
        final String pattern = "^[A-Z]{6}[0-9]{2}[A-EHLMPR-T][0-9]{2}[A-Z0-9]{4}[A-Z]$";
        if (!Pattern.matches(pattern, targa))
            throw new WrongCodiceFiscaleException("Codice fiscale non valido");
        return true;
    }
}
