package it.unimol.assicurazioni.ui;

import it.unimol.assicurazioni.app.Auto;
import it.unimol.assicurazioni.app.CodiceFiscaleValidator;
import it.unimol.assicurazioni.app.Persona;
import it.unimol.assicurazioni.exceptions.WrongCodiceFiscaleException;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

@AllArgsConstructor
public class MenuImmatricolazione implements Schermata{

    private Scanner input;

    @Override
    public void esegui() {
        String nomeProduttore, modello, allestimento;
        Persona proprietario;
        float cilindrata;
        int cavalli;

        System.out.print("Inserisci il nome del produttore dell'auto:");
        nomeProduttore = input.nextLine();
        System.out.print("Inserisci il nome del modello dell'auto:");
        modello = input.nextLine();
        System.out.print("Inserisci l'allestimento dell'auto:");
        allestimento = input.nextLine();
        System.out.print("Inserisci la cilindrata dell'auto:");
        cilindrata=Float.parseFloat(input.nextLine());
        System.out.print("Inserisci il numero di cavalli dell'auto:");
        cavalli=Integer.parseInt(input.nextLine());

        String nome;
        String cognome;
        LocalDate dataNascita;
        String codiceFiscale;

        System.out.print("Inserisci il nome del proprietario: ");
        nome = input.nextLine();
        System.out.print("Inserisci il cognome del proprietario: ");
        cognome = input.nextLine();
        System.out.print("Inserisci la data nascita del proprietario (formato dd-mm-yyyy): ");
        try {
            dataNascita = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            codiceFiscale=input.nextLine();
            CodiceFiscaleValidator.isCodiceFiscaleValido(codiceFiscale);
            proprietario=new Persona(nome, cognome, dataNascita,codiceFiscale);
        } catch (DateTimeParseException | WrongCodiceFiscaleException e) {
            System.out.println(e.getMessage());
            return;
        }

        Auto auto=new Auto(nomeProduttore,modello,allestimento,proprietario,cilindrata,cavalli);



    }
}
