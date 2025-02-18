package it.unimol.assicurazioni.app;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Persona implements Serializable {
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String codiceFiscale;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona persona)) return false;
        return Objects.equals(getNome(), persona.getNome()) && Objects.equals(getCognome(), persona.getCognome()) &&
                Objects.equals(getDataNascita(), persona.getDataNascita()) &&
                Objects.equals(getCodiceFiscale(), persona.getCodiceFiscale());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getCognome(), getDataNascita(), getCodiceFiscale());
    }
}
