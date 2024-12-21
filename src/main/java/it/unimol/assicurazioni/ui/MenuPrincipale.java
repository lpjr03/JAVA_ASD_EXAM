package it.unimol.assicurazioni.ui;

import it.unimol.assicurazioni.exceptions.WrongTargaException;

import java.util.Scanner;

public class MenuPrincipale implements Schermata{

    private static MenuPrincipale menuPrincipale;

    private Scanner input;

    public static MenuPrincipale getInstance()
    {
        if(menuPrincipale==null)
            menuPrincipale=new MenuPrincipale();
        return menuPrincipale;
    }

    @Override
    public void esegui() throws WrongTargaException {
        input = new Scanner(System.in);
        boolean esci;
        int scelta;
        do {
            this.stampaMenu();
            System.out.print("Scelta: ");
            scelta=Integer.parseInt(input.nextLine());
            esci=this.gestisciInput(scelta);
        }while(!esci);


    }

    private boolean gestisciInput(int scelta) throws WrongTargaException
    {
        switch (scelta)
        {
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

    private void stampaMenu()
    {
        System.out.println("1. Immatricola automobile");
        System.out.println("2. Rottama automobile");
        System.out.println("3. Controlla targa");
        System.out.println("0. Esci");
    }

    private void func1()
    {
        MenuImmatricolazione menuImmatricolazione=new MenuImmatricolazione(input);
        menuImmatricolazione.esegui();
    }

    private void func2()
    {
        MenuRottamazione menuRottamazione=new MenuRottamazione(input);
        menuRottamazione.esegui();
    }

    private void func3() throws WrongTargaException
    {
        MenuControlloTarga menuControlloTarga=new MenuControlloTarga(input);
        menuControlloTarga.esegui();
    }
}
