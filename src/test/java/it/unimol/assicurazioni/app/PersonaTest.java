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

}