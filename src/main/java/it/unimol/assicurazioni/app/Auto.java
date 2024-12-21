package it.unimol.assicurazioni.app;

import java.util.Objects;

public class Auto {

    private String nomeProduttore;
    private String modello;
    private String allestimento;

    public Auto(String nomeProduttore, String modello, String allestimento) {
        this.nomeProduttore = nomeProduttore;
        this.modello = modello;
        this.allestimento = allestimento;
    }

    public String getNomeProduttore() {
        return nomeProduttore;
    }

    public void setNomeProduttore(String nomeProduttore) {
        this.nomeProduttore = nomeProduttore;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getAllestimento() {
        return allestimento;
    }

    public void setAllestimento(String allestimento) {
        this.allestimento = allestimento;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "nomeProduttore='" + nomeProduttore + '\'' +
                ", modello='" + modello + '\'' +
                ", allestimento='" + allestimento + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auto auto)) return false;
        return Objects.equals(getNomeProduttore(), auto.getNomeProduttore()) && Objects.equals(getModello(), auto.getModello()) && Objects.equals(getAllestimento(), auto.getAllestimento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNomeProduttore(), getModello(), getAllestimento());
    }
}

