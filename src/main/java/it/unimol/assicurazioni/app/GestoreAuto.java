package it.unimol.assicurazioni.app;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * La classe GestoreAuto gestisce una lista di automobili e una lista di targhe rottamate.
 * Implementa il pattern Singleton per garantire una sola istanza di GestoreAuto nell'applicazione.
 *
 * La classe permette di aggiungere nuove automobili, immatricolare auto, controllare la validità delle targhe,
 * e gestire le operazioni di salvataggio e caricamento dei dati da un file di serializzazione.
 */
public class GestoreAuto implements Serializable {

    /**
     * L'istanza singleton di GestoreAuto.
     */
    private static GestoreAuto gestoreAuto;

    /**
     * Mappa che associa una targa ad un'auto.
     */
    HashMap<String, Auto> listaAuto;

    /**
     * Lista delle targhe delle auto rottamate.
     */
    private List<String> autoRottamate;

    /**
     * Costruttore privato per implementare il pattern Singleton.
     * Inizializza la lista di auto e la lista delle targhe rottamate.
     */
    private GestoreAuto() {
        listaAuto = new HashMap<>();
        autoRottamate = new ArrayList<>();
    }

    /**
     * Restituisce l'istanza unica di GestoreAuto.
     *
     * @return L'istanza di GestoreAuto.
     */
    public static GestoreAuto getInstance(){
        return gestoreAuto;
    }

    /**
     * Inizializza l'istanza di GestoreAuto caricando i dati da un file di serializzazione.
     *
     * @throws IOException Se si verificano errori durante il caricamento dei dati.
     */
    public static void initialize() throws IOException {
        GestoreAuto.gestoreAuto = GestoreAuto.load();
    }

    /**
     * Verifica se una targa è già presente nella lista delle auto immatricolate.
     *
     * @param targa La targa da verificare.
     * @return true se la targa è presente, false altrimenti.
     */
    private boolean esisteAuto(String targa){
        return this.listaAuto.entrySet().stream().anyMatch(listaAuto -> listaAuto.getKey().equals(targa));
    }

    /**
     * Verifica se una targa è stata associata ad un'auto rottamata.
     *
     * @param targa La targa da verificare.
     * @return true se la targa è rottamata, false altrimenti.
     */
    private boolean isAutoRottamata(String targa){
        for(String _targa : autoRottamate){
            if(_targa.equals(targa))
                return true;
        }
        return false;
    }

    /**
     * Aggiunge una targa alla lista delle auto rottamate se non è già presente.
     *
     * @param targa La targa da aggiungere alla lista delle auto rottamate.
     * @return true se l'operazione è andata a buon fine, false altrimenti.
     */
    public boolean aggiungiAutoRottamata(String targa) {
        if (esisteAuto(targa)) {
            if (!isAutoRottamata(targa)) {
                this.autoRottamate.add(targa);
                System.out.println("Targa rottamata aggiunta!");
                this.save();
                return true;
            } else
                System.out.println("Targa già rottamata!");
        } else {
            System.out.println("Targa inesistente!");
        }
        return false;
    }

    /**
     * Controlla se una targa è associata ad un'auto e stampa i dettagli dell'auto se esiste.
     * Se la targa è rottamata, informa l'utente.
     *
     * @param targa La targa da controllare.
     * @return true se la targa è valida, false altrimenti.
     */
    public boolean controllaTarga(String targa) {
        if (isAutoRottamata(targa)) {
            System.out.println("L'automobile associata alla targa inserita è stata rottamata");
            return false;
        } else {
            System.out.println("La targa non è stata ancora assegnata");
        }

        if (esisteAuto(targa)) {
            System.out.println(this.listaAuto.get(targa).toString());
            return true;
        }
        return false;
    }


    /**
     * Immatricola una nuova auto generando una targa casuale e aggiungendo l'auto alla lista.
     *
     * @param auto L'auto da immatricolare.
     * @return true se l'auto è stata immatricolata correttamente, false se la targa è già in uso.
     * @throws FileNotFoundException Se si verifica un errore nell'accesso al file di salvataggio.
     */
    public boolean immatricolaAuto(Auto auto) throws FileNotFoundException {
        String targa=GestoreAuto.generaTarga();
        if(esisteAuto(targa))
            return false;
        this.listaAuto.put(targa, auto);
        System.out.println(targa);
        this.save();
        return true;
    }

    /**
     * Genera una targa casuale seguendo il formato XX123YY.
     *
     * @return La targa generata.
     */
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

    /**
     * Salva lo stato corrente del gestore auto in un file di serializzazione.
     */
    private void save() {
        File file = new File("/app/data/gestore.sr");
        File directory = file.getParentFile();

        if (directory != null && !directory.exists()) {
            directory.mkdirs();
        }

        try (
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            objectOutputStream.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Carica lo stato di un GestoreAuto da un file di serializzazione.
     * Se il file non esiste, viene creato un nuovo GestoreAuto vuoto.
     *
     * @return L'istanza di GestoreAuto caricata dal file.
     */
    private static GestoreAuto load() {
        File file = new File("/app/data/gestore.sr");
        File directory = file.getParentFile();

        if (directory != null && !directory.exists()) {
            directory.mkdirs();
        }

        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            Object o = objectInputStream.readObject();
            return (GestoreAuto) o;
        } catch (FileNotFoundException e) {
            return new GestoreAuto();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
