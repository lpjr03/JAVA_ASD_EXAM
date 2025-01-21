package it.unimol.assicurazioni.app;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GestoreAuto implements Serializable {

    private static GestoreAuto gestoreAuto;

    HashMap<String, Auto> listaAuto;

    private List<String> autoRottamate;

    private GestoreAuto() {
        listaAuto = new HashMap<>();
        autoRottamate = new ArrayList<>();
    }

    public static GestoreAuto getInstance(){
        return gestoreAuto;
    }

    public static void initialize() throws IOException {
        GestoreAuto.gestoreAuto = GestoreAuto.load();
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

    public boolean aggiungiAutoRottamata(String targa)
    {
        if(esisteAuto(targa)) {
            if (!isAutoRottamata(targa)) {
                this.autoRottamate.add(targa);
                System.out.println("Targa rottamata aggiunta!");
                return true;
            } else
                System.out.println("Targa già rottamata!");
        }
        else
            System.out.println("Targa inesistente!");
        this.save();
        return false;
    }

    public boolean controllaTarga(String targa)
    {
        if(esisteAuto(targa))
        {
            System.out.println(this.listaAuto.get(targa).toString());
            return true;
        }
        if(isAutoRottamata(targa))
            System.out.println("L'automobile associata alla targa inserita è stata rottamata");
        else
            System.out.println("La targa non è stata ancora assegnata");
        return false;
    }

    public boolean immatricolaAuto(Auto auto) throws FileNotFoundException {
        String targa=GestoreAuto.generaTarga();
        if(esisteAuto(targa))
            return false;
        this.listaAuto.put(targa, auto);
        System.out.println(targa);
        this.save();
        return true;
    }

    private static String generaTarga() {
        Random random = new Random();

        // Genera i primi due caratteri alfabetici
        char primaLettera = (char) ('A' + random.nextInt(26));
        char secondaLettera = (char) ('A' + random.nextInt(26));

        // Genera i tre numeri centrali
        int numeri = random.nextInt(1000); // Numero da 0 a 999

        // Genera gli ultimi due caratteri alfabetici
        char terzaLettera = (char) ('A' + random.nextInt(26));
        char quartaLettera = (char) ('A' + random.nextInt(26));

        // Costruisci la targa
        return String.format("%c%c%03d%c%c", primaLettera, secondaLettera, numeri, terzaLettera, quartaLettera);
    }

    private void save(){
        try(
                FileOutputStream fileOutputStream = new FileOutputStream("gestore.sr");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ){
            objectOutputStream.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static GestoreAuto load()
    {
        try(
                FileInputStream fileInputStream = new FileInputStream("gestore.sr");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ){
            Object o = objectInputStream.readObject();
            return (GestoreAuto) o;
        } catch (FileNotFoundException e) {
            return new GestoreAuto();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }



}
