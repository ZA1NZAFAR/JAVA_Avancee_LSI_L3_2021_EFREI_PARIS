package TP2.Exo2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// cette classe beneficie de tout les tests de la classe TestBowlingFrame
public class TestBowlingFrameLast {
    private BowlingFrameLast frame;

    @BeforeEach
    public void setUp() {
        frame = new BowlingFrameLast();
    }

    @Test
    public void testGetScoreNoThird() { // cas où il n'y a pas de troisième lancer
        frame.setFirstThrow(5);
        frame.setSecondThrow(4);
        assertEquals(9, frame.getScore());
    }

    @Test
    public void testGetScoreIllegal() { // cas où il y a un lancer non valide
        frame.setFirstThrow(5);
        frame.setSecondThrow(4);
        assertThrows(IllegalArgumentException.class, () -> frame.setThirdThrow(5));
    }

    @Test
    public void testGetScoreStrike() { // cas où il y a un strike
        frame.setFirstThrow(10);
        frame.setSecondThrow(4);
        frame.setThirdThrow(3);
        assertEquals(17, frame.getScore());
    }

    @Test
    public void testGetScoreSpare() { // cas où il y a un spare
        frame.setFirstThrow(6);
        frame.setSecondThrow(4);
        frame.setThirdThrow(3);
        assertEquals(13, frame.getScore());
    }

    @Test
    public void testPerfectScore() { // cas où on a un score parfait (tous les lancers sont 10)
        frame.setFirstThrow(10);
        frame.setSecondThrow(10);
        frame.setThirdThrow(10);
        assertEquals(30, frame.getScore());
    }

    @Test
    public void testSetBonus() { // pas de bonus pour le dernier frame
        frame.setFirstThrow(5);
        frame.setSecondThrow(5);
        frame.setThirdThrow(3);
        assertThrows(UnsupportedOperationException.class, () -> frame.setBonus(5));
    }
}
