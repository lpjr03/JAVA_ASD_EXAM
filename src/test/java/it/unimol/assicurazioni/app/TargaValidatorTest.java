package it.unimol.assicurazioni.app;

import it.unimol.assicurazioni.exceptions.WrongTargaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TargaValidatorTest {
    @Test
    public void testTargaValida() {
        TargaValidator targaValidator = new TargaValidator();
        try {
            assertTrue(targaValidator.isTargaItalianaValida("AA000AA"));
            assertTrue(targaValidator.isTargaItalianaValida("AB123CD"));
            assertTrue(targaValidator.isTargaItalianaValida("AZ987ZY"));
            assertTrue(targaValidator.isTargaItalianaValida("ZA987BC"));
            assertTrue(targaValidator.isTargaItalianaValida("ZZ999ZZ"));
        } catch (WrongTargaException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testTargaNonValida() {
        TargaValidator targaValidator = new TargaValidator();
        assertThrows(WrongTargaException.class, () -> targaValidator.isTargaItalianaValida(""));
        assertThrows(WrongTargaException.class, () -> targaValidator.isTargaItalianaValida("IO123D"));
        assertThrows(WrongTargaException.class, () -> targaValidator.isTargaItalianaValida("AB123C"));
        assertThrows(WrongTargaException.class, () -> targaValidator.isTargaItalianaValida("ZZ9ZZ"));
    }


}