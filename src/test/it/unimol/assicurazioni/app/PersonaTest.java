package it.unimol.assicurazioni.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {
        @Test
        public void testSetPersona() {
            Persona p=new Persona();
            p.setNome("Riccardo");
            assertEquals("Riccardo",p.getNome());
        }
}