package it.unimol.assicurazioni.exceptions;

/**
 * Eccezione personalizzata che viene lanciata quando un codice fiscale
 * fornito non è valido.
 *
 * <p>Questa eccezione viene utilizzata principalmente dalla classe
 * {@link it.unimol.assicurazioni.app.CodiceFiscaleValidator} per segnalare
 * errori nella validazione dei codici fiscali.</p>
 */
public class WrongCodiceFiscaleException extends Exception {

    /**
     * Costruisce una nuova eccezione con il messaggio di dettaglio specificato.
     *
     * @param message Il messaggio di dettaglio che descrive il motivo dell'errore.
     */
    public WrongCodiceFiscaleException(String message) {
        super(message);
    }
}
