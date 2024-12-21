package it.unimol;

import it.unimol.assicurazioni.ui.MenuPrincipale;

public class Main {
    public static void main(String[] args) {
        MenuPrincipale menuPrincipale=MenuPrincipale.getInstance();
        menuPrincipale.esegui();
    }
}