package it.unimol.assicurazioni.exceptions;

/**
 * Eccezione personalizzata che viene lanciata quando una targa
 * fornita non è valida.
 *
 * <p>Questa eccezione viene utilizzata principalmente dalla classe
 * {@link it.unimol.assicurazioni.app.TargaValidator} per segnalare
 * errori nella validazione delle targhe.</p>
 */
public class WrongTargaException extends Exception{
    /**
     * Costruisce una nuova eccezione con il messaggio di dettaglio specificato.
     *
     * @param message Il messaggio di dettaglio che descrive il motivo dell'errore.
     */
    public WrongTargaException(String message) {
        super(message);
    }
}
