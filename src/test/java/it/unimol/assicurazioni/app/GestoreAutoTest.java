package it.unimol.assicurazioni.app;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class GestoreAutoTest {
    @BeforeEach
    void setUp() throws Exception {
        GestoreAuto.initialize();
    }

    @AfterEach
    void tearDown() {
        File file = new File("gestore.sr");
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testSingleton() {
        GestoreAuto instance1 = GestoreAuto.getInstance();
        GestoreAuto instance2 = GestoreAuto.getInstance();
        assertSame(instance1, instance2, "getInstance() dovrebbe restituire sempre la stessa istanza.");
    }

    @Test
    void testImmatricolaAuto() throws Exception {
        Auto auto = new Auto("Ford", "Focus", "Sport", null, 1.3f,160);
        GestoreAuto gestoreAuto=GestoreAuto.getInstance();
        assertTrue(gestoreAuto.immatricolaAuto(auto), "L'auto dovrebbe essere immatricolata con successo.");
    }

    @Test
    void testControllaTarga() throws FileNotFoundException {
        Auto auto = new Auto("Suzuki", "Swift", "Utilitaria", null, 1.2f,75);
        GestoreAuto gestoreAuto=GestoreAuto.getInstance();
        assertTrue(gestoreAuto.immatricolaAuto(auto), "L'auto dovrebbe essere immatricolata con successo.");
        String targa = GestoreAuto.getInstance().listaAuto.keySet().iterator().next();
        assertTrue(GestoreAuto.getInstance().controllaTarga(targa), "La targa dovrebbe essere riconosciuta.");
    }

    @Test
    void testRottamaAuto() throws FileNotFoundException {
        Auto auto = new Auto("Mitsubishi", "ASX", "Suv", null, 1.8f,150);
        GestoreAuto gestoreAuto=GestoreAuto.getInstance();
        assertTrue(gestoreAuto.immatricolaAuto(auto), "L'auto dovrebbe essere immatricolata con successo.");
        String targa = GestoreAuto.getInstance().listaAuto.keySet().iterator().next();
        assertTrue(gestoreAuto.aggiungiAutoRottamata(targa), "L'auto dovrebbe essere rottamata con successo.");
    }
}