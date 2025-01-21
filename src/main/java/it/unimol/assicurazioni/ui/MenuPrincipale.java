package it.unimol.assicurazioni.ui;



import it.unimol.assicurazioni.app.GestoreAuto;

import java.io.IOException;
import java.util.Scanner;

public class MenuPrincipale implements Schermata{

    private static MenuPrincipale menuPrincipale;

    private Scanner input;

    private GestoreAuto gestoreAuto;

    public static MenuPrincipale getInstance(){
        if(menuPrincipale==null)
            menuPrincipale=new MenuPrincipale();
        return menuPrincipale;
    }

    @Override
    public void esegui() {
        input = new Scanner(System.in);
        boolean esci;
        int scelta;
        try {
            GestoreAuto.initialize();
        } catch (IOException e) {
            System.err.println("Non è stato possibile leggere il file. Eliminare il file.");
            System.exit(-1);
        }
        gestoreAuto=GestoreAuto.getInstance();
        do {
            this.stampaMenu();
            System.out.print("Scelta: ");
            scelta=Integer.parseInt(input.nextLine());
            esci=this.gestisciInput(scelta);
        }while(!esci);
    }

    private boolean gestisciInput(int scelta){
        switch (scelta){
            case 1:
                this.func1();
                break;
            case 2:
                this.func2();
                break;
            case 3:
                this.func3();
                break;
            case 0:
                return true;
        }
        return false;
    }

    private void stampaMenu(){
        System.out.println("1. Immatricola automobile");
        System.out.println("2. Rottama automobile");
        System.out.println("3. Controlla targa");
        System.out.println("0. Esci");
    }

    private void func1(){
        MenuImmatricolazione menuImmatricolazione=new MenuImmatricolazione(input, gestoreAuto);
        menuImmatricolazione.esegui();
    }

    private void func2(){
        MenuRottamazione menuRottamazione=new MenuRottamazione(input, gestoreAuto);
        menuRottamazione.esegui();
    }

    private void func3(){
        MenuControlloTarga menuControlloTarga=new MenuControlloTarga(input,gestoreAuto);
        menuControlloTarga.esegui();
    }
}
