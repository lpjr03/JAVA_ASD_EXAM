package it.unimol.assicurazioni.app;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AutoTest {
    @Test
    public void testNomeProduttore()
    {
        Auto auto = new Auto();
        auto.setNomeProduttore("Mazda");
        assertEquals("Mazda", auto.getNomeProduttore());
    }

    @Test
    public void testModello()
    {
        Auto auto = new Auto();
        auto.setModello("RX-8");
        assertEquals("RX-8", auto.getModello());
    }

    @Test
    public void testAllestimento()
    {
        Auto auto = new Auto();
        auto.setAllestimento("Sport");
        assertEquals("Sport", auto.getAllestimento());
    }

    @Test
    public void testCilindrata()
    {
        Auto auto = new Auto();
        auto.setCilindrata(1.3f);
        assertEquals(1.3f, auto.getCilindrata());
    }

    @Test
    public void testCavalli()
    {
        Auto auto = new Auto();
        auto.setCavalli(231);
        assertEquals(231, auto.getCavalli());
    }

    @Test
    public void testEquals_SameAttributes() {
        Persona proprietario = new Persona("Mario", "Rossi", LocalDate.of(1990, 1, 1), "RSSMRA90A01H501U");
        Auto auto1 = new Auto("Fiat", "Punto", "Sport", proprietario, 1.4f, 95);
        Auto auto2 = new Auto("Fiat", "Punto", "Sport", proprietario, 1.4f, 95);

        assertEquals(auto1, auto2, "Due auto con gli stessi attributi dovrebbero essere uguali");
    }

    @Test
    public void testEquals_SameObject() {
        Persona proprietario = new Persona("Mario", "Rossi", LocalDate.of(1990, 1, 1), "RSSMRA90A01H501U");
        Auto auto = new Auto("Fiat", "Punto", "Sport", proprietario, 1.4f, 95);

        assertEquals(auto, auto, "Un oggetto dovrebbe essere uguale a sé stesso");
    }

    @Test
    public void testEquals_Null() {
        Persona proprietario = new Persona("Mario", "Rossi", LocalDate.of(1990, 1, 1), "RSSMRA90A01H501U");
        Auto auto = new Auto("Fiat", "Punto", "Sport", proprietario, 1.4f, 95);

        assertNotEquals(auto, null, "Un'auto non dovrebbe mai essere uguale a null");
    }

    @Test
    public void testEquals_DifferentClass() {
        Persona proprietario = new Persona("Mario", "Rossi", LocalDate.of(1990, 1, 1), "RSSMRA90A01H501U");
        Auto auto = new Auto("Fiat", "Punto", "Sport", proprietario, 1.4f, 95);

        assertNotEquals(auto, "NonUnAuto", "Un'auto non dovrebbe mai essere uguale a un oggetto di una classe diversa");
    }

    @Test
    public void testEquals_DifferentNomeProduttore() {
        Persona proprietario = new Persona("Mario", "Rossi", LocalDate.of(1990, 1, 1), "RSSMRA90A01H501U");
        Auto auto1 = new Auto("Fiat", "Punto", "Sport", proprietario, 1.4f, 95);
        Auto auto2 = new Auto("Ford", "Punto", "Sport", proprietario, 1.4f, 95);

        assertNotEquals(auto1, auto2, "Auto con nome produttore diverso non dovrebbero essere uguali");
    }

    @Test
    public void testEquals_DifferentModello() {
        Persona proprietario = new Persona("Mario", "Rossi", LocalDate.of(1990, 1, 1), "RSSMRA90A01H501U");
        Auto auto1 = new Auto("Fiat", "Punto", "Sport", proprietario, 1.4f, 95);
        Auto auto2 = new Auto("Fiat", "500", "Sport", proprietario, 1.4f, 95);

        assertNotEquals(auto1, auto2, "Auto con modello diverso non dovrebbero essere uguali");
    }

    @Test
    public void testEquals_DifferentAllestimento() {
        Persona proprietario = new Persona("Mario", "Rossi", LocalDate.of(1990, 1, 1), "RSSMRA90A01H501U");
        Auto auto1 = new Auto("Fiat", "Punto", "Sport", proprietario, 1.4f, 95);
        Auto auto2 = new Auto("Fiat", "Punto", "Base", proprietario, 1.4f, 95);

        assertNotEquals(auto1, auto2, "Auto con allestimento diverso non dovrebbero essere uguali");
    }

    @Test
    public void testEquals_DifferentProprietario() {
        Persona proprietario1 = new Persona("Mario", "Rossi", LocalDate.of(1990, 1, 1), "RSSMRA90A01H501U");
        Persona proprietario2 = new Persona("Luigi", "Verdi", LocalDate.of(1985, 5, 10), "VRDLGU85E10H501B");
        Auto auto1 = new Auto("Fiat", "Punto", "Sport", proprietario1, 1.4f, 95);
        Auto auto2 = new Auto("Fiat", "Punto", "Sport", proprietario2, 1.4f, 95);

        assertNotEquals(auto1, auto2, "Auto con proprietario diverso non dovrebbero essere uguali");
    }

    @Test
    public void testEquals_DifferentCilindrata() {
        Persona proprietario = new Persona("Mario", "Rossi", LocalDate.of(1990, 1, 1), "RSSMRA90A01H501U");
        Auto auto1 = new Auto("Fiat", "Punto", "Sport", proprietario, 1.4f, 95);
        Auto auto2 = new Auto("Fiat", "Punto", "Sport", proprietario, 1.6f, 95);

        assertNotEquals(auto1, auto2, "Auto con cilindrata diversa non dovrebbero essere uguali");
    }

    @Test
    public void testEquals_DifferentCavalli() {
        Persona proprietario = new Persona("Mario", "Rossi", LocalDate.of(1990, 1, 1), "RSSMRA90A01H501U");
        Auto auto1 = new Auto("Fiat", "Punto", "Sport", proprietario, 1.4f, 95);
        Auto auto2 = new Auto("Fiat", "Punto", "Sport", proprietario, 1.4f, 120);

        assertNotEquals(auto1, auto2, "Auto con cavalli diversi non dovrebbero essere uguali");
    }



    @Test
    public void testHashCode_SameAttributes() {
        LocalDateTime now = LocalDateTime.now();
        Persona proprietario = new Persona("Lelio","Palmisano",now.toLocalDate(),"PLMLLE03P16B519G");
        Auto auto1 = new Auto();
        auto1.setNomeProduttore("Fiat");
        auto1.setModello("Panda");
        auto1.setAllestimento("Base");
        auto1.setProprietario(proprietario);
        auto1.setCilindrata(1.2f);
        auto1.setCavalli(69);

        Auto auto2 = new Auto();
        auto2.setNomeProduttore("Fiat");
        auto2.setModello("Panda");
        auto2.setAllestimento("Base");
        auto2.setProprietario(proprietario);
        auto2.setCilindrata(1.2f);
        auto2.setCavalli(69);

        assertEquals(auto1.hashCode(), auto2.hashCode(), "HashCode dovrebbe essere uguale per auto con stessi attributi");
    }

    @Test
    public void testHashCode_DifferentAttributes() {
        LocalDateTime now = LocalDateTime.now();
        Auto auto1 = new Auto();
        auto1.setNomeProduttore("Fiat");
        auto1.setModello("Panda");

        Auto auto2 = new Auto();
        auto2.setNomeProduttore("Fiat");
        auto2.setModello("500");

        assertNotEquals(auto1.hashCode(), auto2.hashCode(), "HashCode dovrebbe differire per auto con attributi diversi");
    }

    @Test
    public void testSetProprietario() {
        LocalDateTime now = LocalDateTime.now();
        Persona proprietario1 = new Persona("Lelio","Palmisano",now.toLocalDate(),"PLMLLE03P16B519G");
        LocalDateTime now_2 = LocalDateTime.now();
        Persona proprietario2 = new Persona("Silvia","Palmisano",now_2.toLocalDate(),"PLMSLV01R46B519K");

        Auto auto = new Auto();
        auto.setProprietario(proprietario1);

        auto.setProprietario(proprietario2);

        assertEquals(proprietario2, auto.getProprietario(), "Il proprietario dovrebbe essere aggiornato correttamente");
    }


}