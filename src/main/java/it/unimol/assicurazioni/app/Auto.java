package it.unimol.assicurazioni.app;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Auto implements Serializable {
    private String nomeProduttore;
    private String modello;
    private String allestimento;
    private Persona proprietario;
    private float cilindrata;
    private int cavalli;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auto auto)) return false;
        return Float.compare(getCilindrata(), auto.getCilindrata()) == 0 && getCavalli() == auto.getCavalli()
                && Objects.equals(getNomeProduttore(), auto.getNomeProduttore()) &&
                Objects.equals(getModello(),auto.getModello()) && Objects.equals(getAllestimento(),
                auto.getAllestimento()) && Objects.equals(getProprietario(),
                auto.getProprietario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNomeProduttore(), getModello(), getAllestimento(), getProprietario(),
                getCilindrata(), getCavalli());
    }
}