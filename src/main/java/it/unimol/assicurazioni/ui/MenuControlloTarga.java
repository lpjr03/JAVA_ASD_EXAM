package it.unimol.assicurazioni.ui;
import it.unimol.assicurazioni.app.GestoreAuto;
import it.unimol.assicurazioni.app.TargaValidator;
import it.unimol.assicurazioni.exceptions.WrongTargaException;
import lombok.AllArgsConstructor;
import java.util.Scanner;

@AllArgsConstructor
public class MenuControlloTarga implements Schermata{

    private Scanner input;

    private GestoreAuto gestoreAuto;

    @Override
    public void esegui(){

        String targa;
        System.out.print("Inserisci un targa: ");
        targa = input.nextLine();
        try{
            if(TargaValidator.isTargaItalianaValida(targa))
                this.gestoreAuto.controllaTarga(targa);

        }catch (WrongTargaException e){
            System.out.println(e.getMessage());
        }

    }
}
