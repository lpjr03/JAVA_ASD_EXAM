package it.unimol.assicurazioni.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GestoreAuto{

    private static GestoreAuto gestoreAuto;

    private HashMap<String, Auto> listaAuto;

    private List<String> autoRottamate;

    private GestoreAuto() {
        listaAuto = new HashMap<>();
        autoRottamate = new ArrayList<>();
    }

    public static GestoreAuto getInstance(){

        if(gestoreAuto == null)
            gestoreAuto = new GestoreAuto();
        return gestoreAuto;
    }

    private boolean esisteAuto(String targa)
    {
        return this.listaAuto.entrySet().stream().anyMatch(listaAuto -> listaAuto.getKey().equals(targa));
    }

    private boolean isAutoRottamata(String targa)
    {
        return this.autoRottamate.stream().anyMatch(autoRottamate -> autoRottamate.equals(targa));
    }

    private void aggiungiAutoRottamata(String targa)
    {
        this.autoRottamate.add(targa);
    }
}
