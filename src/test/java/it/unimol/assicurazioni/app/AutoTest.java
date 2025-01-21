package it.unimol.assicurazioni.app;

import org.junit.jupiter.api.Test;

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

}