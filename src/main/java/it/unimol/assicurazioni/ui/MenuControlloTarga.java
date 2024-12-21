package it.unimol.assicurazioni.ui;

import it.unimol.assicurazioni.exceptions.WrongTargaException;
import lombok.AllArgsConstructor;

import java.util.Scanner;
import java.util.regex.Pattern;

@AllArgsConstructor
public class MenuControlloTarga implements Schermata{

    private Scanner input;



    @Override
    public void esegui() throws WrongTargaException{

        String targa;
        System.out.print("Inserisci un targa: ");
        targa = input.nextLine();
        if(!Pattern.matches("^[A-Z]{2}\\d{3}[A-Z]{2}$", targa))
            throw new WrongTargaException("Targa errata!");


    }
}
