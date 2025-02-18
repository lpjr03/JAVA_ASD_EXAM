package it.unimol.assicurazioni.app;

import it.unimol.assicurazioni.exceptions.WrongCodiceFiscaleException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodiceFiscaleValidatorTest {
    @Test
    public void testCodiceFiscaleValido()
    {
        CodiceFiscaleValidator validator = new CodiceFiscaleValidator();
        try {
            assertTrue(validator.isCodiceFiscaleValido("GLLGTA01M54C933N"));
            assertTrue(validator.isCodiceFiscaleValido("PLMLLE03P16B519G"));
        } catch (WrongCodiceFiscaleException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testCodiceFiscaleNonValido()
    {
        CodiceFiscaleValidator validator = new CodiceFiscaleValidator();
        assertThrows(WrongCodiceFiscaleException.class, ()-> validator.isCodiceFiscaleValido("GLLGTA01M54C933n"));
        assertThrows(WrongCodiceFiscaleException.class, ()-> validator.isCodiceFiscaleValido("GLLGTA01M54C933"));
    }
}