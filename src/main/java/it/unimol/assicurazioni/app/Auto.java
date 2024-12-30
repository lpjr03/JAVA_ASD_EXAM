package it.unimol.assicurazioni.app;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auto implements Serializable {
    private String nomeProduttore;
    private String modello;
    private String allestimento;
    private Persona proprietario;
    private float cilindrata;
    private int cavalli;
}
