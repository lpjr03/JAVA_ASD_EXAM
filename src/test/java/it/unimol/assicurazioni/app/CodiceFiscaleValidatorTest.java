package it.unimol.assicurazioni.app;

import it.unimol.assicurazioni.exceptions.WrongCodiceFiscaleException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodiceFiscaleValidatorTest {
    @Test
    public void testCodiceFiscaleValido()
    {
        try {
            assertTrue(CodiceFiscaleValidator.isCodiceFiscaleValido("GLLGTA01M54C933N"));
            assertTrue(CodiceFiscaleValidator.isCodiceFiscaleValido("PLMLLE03P16B519G"));
        } catch (WrongCodiceFiscaleException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testCodiceFiscaleNonValido()
    {
        assertThrows(WrongCodiceFiscaleException.class, ()-> CodiceFiscaleValidator.isCodiceFiscaleValido("GLLGTA01M54C933n"));
        assertThrows(WrongCodiceFiscaleException.class, ()-> CodiceFiscaleValidator.isCodiceFiscaleValido("GLLGTA01M54C933"));
    }
}