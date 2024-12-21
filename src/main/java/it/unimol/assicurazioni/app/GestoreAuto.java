package it.unimol.assicurazioni.app;

import java.util.HashMap;

public class GestoreAuto{

    private static GestoreAuto gestoreAuto;

    private HashMap<String, Auto> listaAuto;

    private GestoreAuto() {
        listaAuto = new HashMap<>();
    }

    public static GestoreAuto getInstance(){

        if(gestoreAuto == null)
            gestoreAuto = new GestoreAuto();
        return gestoreAuto;
    }

}
