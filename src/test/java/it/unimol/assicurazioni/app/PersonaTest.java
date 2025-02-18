package it.unimol.assicurazioni.app;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {
    @Test
    public void testSetNomePersona() {
        Persona p = new Persona();
        p.setNome("Riccardo");
        assertEquals("Riccardo", p.getNome());
    }

    @Test
    public void testSetCognomePersona() {
        Persona p = new Persona();
        p.setCognome("Rossi");
        assertEquals("Rossi", p.getCognome());
    }

    @Test
    public void testCodiceFiscale()
    {
        Persona p = new Persona();
        p.setCodiceFiscale("PLMLLE03P16B519G");
        assertEquals("PLMLLE03P16B519G", p.getCodiceFiscale());
    }

    @Test
    public void testDataNascita()
    {
        LocalDate dataNascita=LocalDate.parse("20/10/2011", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Persona p = new Persona();
        p.setDataNascita(dataNascita);
        assertEquals(dataNascita, p.getDataNascita());
    }

    @Test
    public void testEquals_SameAttributes() {
        Persona persona1 = new Persona("Mario", "Rossi", LocalDate.of(1990, 1, 1), "RSSMRA90A01H501U");
        Persona persona2 = new Persona("Mario", "Rossi", LocalDate.of(1990, 1, 1), "RSSMRA90A01H501U");

        assertEquals(persona1, persona2, "Due persone con gli stessi attributi dovrebbero essere uguali");
    }

    @Test
    public void testEquals_DifferentNome() {
        Persona persona1 = new Persona("Mario", "Rossi", LocalDate.of(1990, 1, 1), "RSSMRA90A01H501U");
        Persona persona2 = new Persona("Luigi", "Rossi", LocalDate.of(1990, 1, 1), "RSSMRA90A01H501U");

        assertNotEquals(persona1, persona2, "Persone con nome diverso non dovrebbero essere uguali");
    }

    @Test
    public void testHashCode_SameAttributes() {
        Persona persona1 = new Persona("Mario", "Rossi", LocalDate.of(1990, 1, 1), "RSSMRA90A01H501U");
        Persona persona2 = new Persona("Mario", "Rossi", LocalDate.of(1990, 1, 1), "RSSMRA90A01H501U");

        assertEquals(persona1.hashCode(), persona2.hashCode(), "HashCode dovrebbe essere uguale per persone con stessi attributi");
    }

    @Test
    public void testHashCode_DifferentAttributes() {
        Persona persona1 = new Persona("Mario", "Rossi", LocalDate.of(1990, 1, 1), "RSSMRA90A01H501U");
        Persona persona2 = new Persona("Mario", "Bianchi", LocalDate.of(1990, 1, 1), "RSSMRA90A01H501U");

        assertNotEquals(persona1.hashCode(), persona2.hashCode(), "HashCode dovrebbe differire per persone con attributi diversi");
    }

    @Test
    public void testEquals_Null() {
        Persona persona = new Persona("Mario", "Rossi", LocalDate.of(1990, 1, 1), "RSSMRA90A01H501U");

        assertNotEquals(persona, null, "Una persona non dovrebbe mai essere uguale a null");
    }
}