package JUnitBasics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPersonne {

    private final Personne personne = new Personne();

    @BeforeEach
    public void setupPersonne() {
        personne.setNom("GHARS");
        personne.setPrenom("Marwan");
        personne.setAge(24);
    }

    @Test
    public void setupPersonneBob() {
        personne.setPrenom("Bob");
        assertEquals("Bob", personne.getPrenom());
    }

    @Test
    public void createNewPersonne() {
        assertEquals("Marwan", personne.getPrenom());
    }


    @Test
    public void testIfAgeGreaterThan() {
        assertEquals("GHARS", personne.getNom());
        assertTrue(personne.getAge() > 20);
    }
}