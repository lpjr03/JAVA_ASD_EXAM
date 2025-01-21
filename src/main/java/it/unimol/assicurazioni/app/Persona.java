package it.unimol.assicurazioni.app;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona implements Serializable {
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String codiceFiscale;
}
