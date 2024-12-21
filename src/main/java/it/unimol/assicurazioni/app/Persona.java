package it.unimol.assicurazioni.app;

import java.time.LocalDate;
import java.util.Objects;

public class Persona {
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
     public Persona(String nome, String cognome, LocalDate dataNascita) {
         this.nome = nome;
         this.cognome = cognome;
         this.dataNascita = dataNascita;
     }

     public String getNome() {
         return nome;
     }

     public void setNome(String nome) {
         this.nome = nome;
     }

     public String getCognome() {
         return cognome;
     }

     public void setCognome(String cognome) {
         this.cognome = cognome;
     }

     public LocalDate getDataNascita() {
         return dataNascita;
     }


    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona persona)) return false;
        return Objects.equals(getNome(), persona.getNome()) && Objects.equals(getCognome(), persona.getCognome()) && Objects.equals(getDataNascita(), persona.getDataNascita());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getCognome(), getDataNascita());
    }

}
