package it.unimol.assicurazioni.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Persona {
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String codiceFiscale;
}
