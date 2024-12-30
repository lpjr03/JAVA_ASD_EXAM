package it.unimol.assicurazioni.app;

import it.unimol.assicurazioni.exceptions.WrongTargaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TargaValidatorTest {
    @Test
    public void testTargaValida() {
        try {
            assertTrue(TargaValidator.isTargaItalianaValida("AA000AA"));
            assertTrue(TargaValidator.isTargaItalianaValida("AB123CD"));
            assertTrue(TargaValidator.isTargaItalianaValida("AZ987ZY"));
            assertTrue(TargaValidator.isTargaItalianaValida("ZA987BC"));
            assertTrue(TargaValidator.isTargaItalianaValida("ZZ999ZZ"));
        } catch (WrongTargaException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testTargaNonValida() {
        assertThrows(WrongTargaException.class, () -> TargaValidator.isTargaItalianaValida(""));
        assertThrows(WrongTargaException.class, () -> TargaValidator.isTargaItalianaValida("IO123D"));
        assertThrows(WrongTargaException.class, () -> TargaValidator.isTargaItalianaValida("AB123C"));
        assertThrows(WrongTargaException.class, () -> TargaValidator.isTargaItalianaValida("ZZ9ZZ"));
    }


}