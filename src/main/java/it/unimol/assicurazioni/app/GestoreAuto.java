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
        for(String _targa : autoRottamate)
        {
            if(_targa.equals(targa))
                return true;
        }
        return false;
    }

    public void aggiungiAutoRottamata(String targa)
    {
        if(esisteAuto(targa)) {
            if (!isAutoRottamata(targa)) {
                this.autoRottamate.add(targa);
                System.out.println("Targa rottamata aggiunta!");
            } else
                System.out.println("Targa già rottamata!");
        }
        else
            System.out.println("Targa inesistente!");

    }

    public void controllaTarga(String targa)
    {
        if(esisteAuto(targa))
        {
            System.out.println(this.listaAuto.get(targa).toString());
            return;
        }
        if(isAutoRottamata(targa))
            System.out.println("L'automobile associata alla targa inserita è stata rottamata");
        else
            System.out.println("La targa non è stata ancora assegnata");
    }



}
