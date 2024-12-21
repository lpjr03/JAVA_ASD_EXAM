package it.unimol.assicurazioni.app;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Auto {
    private String nomeProduttore;
    private String modello;
    private String allestimento;
    private Persona proprietario;
    private float cilindrata;
    private int cavalli;
}
