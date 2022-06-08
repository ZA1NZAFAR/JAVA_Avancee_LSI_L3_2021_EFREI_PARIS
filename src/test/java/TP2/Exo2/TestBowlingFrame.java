package TP2.Exo2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBowlingFrame {
    BowlingFrame frame;

    @BeforeEach
    public void setUp() {
        frame = new BowlingFrame();
    }

    // Test basique pour les frames
    @Test
    public void testBowlingFrameEmpty() {
        assertEquals(0, frame.getScore());
    }


    @Test
    public void testBowlingFrameScore9() { // simple test pour un score de 9
        frame.setFirstThrow(5);
        frame.setSecondThrow(4);
        assertEquals(9, frame.getScore());
    }

    // Tests pour les spares
    @Test
    public void testBowlingFrameCheckSpareTrue() { // test pour un spare (5 + 5 = spare)
        frame.setFirstThrow(5);
        frame.setSecondThrow(5);
        assertTrue(frame.isSpare());
    }

    @Test
    public void testBowlingFrameCheckSpareFalse() { // test pour un non spare (5 + 4 = non spare)
        frame.setFirstThrow(5);
        frame.setSecondThrow(3);
        assertFalse(frame.isSpare());
    }

    // Tests pour les strikes
    @Test
    public void testBowlingFrameCheckStrikeTrue() { // test pour un strike (10 = strike)
        frame.setFirstThrow(10);
        assertTrue(frame.isStrike());
    }

    @Test
    public void testBowlingFrameCheckStrikeFalse() { // test pour un non strike (5 + 3 = non strike)
        frame.setFirstThrow(5);
        frame.setSecondThrow(3);
        assertFalse(frame.isStrike());
    }

    // Tests pour les verifications des scores
    @Test
    public void testBowlingFrameScoreSuperieurA10Lancer1() { // test pour un score superieur a 10 dans lancer 1 ( un score de 11 ne doit pas etre accepte)
        assertThrows(IllegalArgumentException.class, () -> frame.setFirstThrow(11));
    }

    @Test
    public void testBowlingFrameScoreSuperieurA10Lancer2() { // test pour un score superieur a 10 dans lancer 2 ( un score de 11 ne doit pas etre accepte)
        frame.setFirstThrow(5);
        assertThrows(IllegalArgumentException.class, () -> frame.setSecondThrow(11));
    }

    @Test
    public void testBowlingFrameNegativeScore() { // test pour un score negatif lancer 1 (un score negatif ne doit pas etre accepte)
        assertThrows(IllegalArgumentException.class, () -> frame.setFirstThrow(-1));
    }

    @Test
    public void testBowlingFrameDepasser10Dans2Tours() { // test pour un score depasser 10 dans 2 tours (un score depasser 10 ne doit pas etre accepte)
        frame.setFirstThrow(6);
        assertThrows(IllegalArgumentException.class, () -> frame.setSecondThrow(7));
    }

    @Test
    public void testBowlingFramePasDeLancerApresStrike() { // on ne peut pas ajouter un lancer apres un strike
        frame.setFirstThrow(10);
        assertThrows(IllegalArgumentException.class, () -> frame.setSecondThrow(5));
    }

    // Tests pour les bonus strikes
    @Test
    public void testBowlingFrameBonusStrikeSimple() { // test strike + un bonus de 5 (10 + 5 = 15)
        frame.setFirstThrow(10);
        frame.setBonus(5);
        assertEquals(15, frame.getScore());
    }

    @Test
    public void testBowlingFrameBonusStrikeDouble() { // test strike + un bonus de 20 (10 + 10 + 10 = 30) (strike + strike + strike)
        frame.setFirstThrow(10);
        frame.setBonus(20);
        assertEquals(30, frame.getScore());
    }

    @Test
    public void testBowlingFrameBonusStrikeIllegal() { // test un bonus de 21 qui n'est pas possible
        frame.setFirstThrow(10);
        assertThrows(IllegalArgumentException.class, () -> frame.setBonus(21));
    }

    @Test
    public void testBowlingFrameBonusStrikeIllegal2() { // un bonus est attribue suite a un strike ou un spare
        frame.setFirstThrow(8);
        frame.setSecondThrow(1);
        assertThrows(IllegalArgumentException.class, () -> frame.setBonus(4));
    }

    // Tests pour les bonus spares
    @Test
    public void testBowlingFrameBonusSpareSimple() { // test spare + un bonus de 5 (5 + 5 + 5 = 15)
        frame.setFirstThrow(5);
        frame.setSecondThrow(5);
        frame.setBonus(5);
        assertEquals(15, frame.getScore());
    }

    @Test
    public void testBowlingFrameBonusSpareIllegal1() { // test un bonus de 11 suites a un spare qui n'est pas possible
        frame.setFirstThrow(5);
        frame.setFirstThrow(5);
        assertThrows(IllegalArgumentException.class, () -> frame.setBonus(11));
    }

    @Test
    public void testBowlingFrameBonusSpareIllegal2() { // un bonus est attribue suite a un strike ou un spare
        frame.setFirstThrow(5);
        frame.setFirstThrow(3);
        assertThrows(IllegalArgumentException.class, () -> frame.setBonus(5));
    }
}