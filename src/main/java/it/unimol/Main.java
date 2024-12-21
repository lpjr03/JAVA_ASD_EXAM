package it.unimol;

import it.unimol.assicurazioni.exceptions.WrongTargaException;
import it.unimol.assicurazioni.ui.MenuPrincipale;

public class Main {
    public static void main(String[] args) throws WrongTargaException {
        MenuPrincipale menuPrincipale=MenuPrincipale.getInstance();
        menuPrincipale.esegui();
    }
}