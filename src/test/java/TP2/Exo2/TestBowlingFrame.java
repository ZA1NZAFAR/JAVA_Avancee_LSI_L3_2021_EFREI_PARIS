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
    public void testBowlingFrameScore9() {
        frame.setFirstThrow(5);
        frame.setSecondThrow(4);
        assertEquals(9, frame.getScore());
    }

    // Tests pour les spares
    @Test
    public void testBowlingFrameCheckSpareTrue() {
        frame.setFirstThrow(5);
        frame.setSecondThrow(5);
        assertTrue(frame.isSpare());
    }

    @Test
    public void testBowlingFrameCheckSpareFalse() {
        frame.setFirstThrow(5);
        frame.setSecondThrow(3);
        assertFalse(frame.isSpare());
    }

    // Tests pour les strikes
    @Test
    public void testBowlingFrameCheckStrikeTrue() {
        frame.setFirstThrow(10);
        assertTrue(frame.isStrike());
    }

    @Test
    public void testBowlingFrameCheckStrikeFalse() {
        frame.setFirstThrow(5);
        frame.setSecondThrow(3);
        assertFalse(frame.isStrike());
    }

    // Tests pour les verifications des scores
    @Test
    public void testBowlingFrameScoreSuperieurA10Lancer1() {
        assertThrows(IllegalArgumentException.class, () -> frame.setFirstThrow(11));
    }

    @Test
    public void testBowlingFrameScoreSuperieurA10Lancer2() {
        frame.setFirstThrow(5);
        assertThrows(IllegalArgumentException.class, () -> frame.setSecondThrow(11));
    }

    @Test
    public void testBowlingFrameNegativeScore() {
        assertThrows(IllegalArgumentException.class, () -> frame.setFirstThrow(-1));
    }

    @Test
    public void testBowlingFrameDepasser10Dans2Tours() {
        frame.setFirstThrow(6);
        assertThrows(IllegalArgumentException.class, () -> frame.setSecondThrow(7));
    }

    @Test
    public void testBowlingFramePasDeLancerApresStrike() {
        frame.setFirstThrow(10);
        assertThrows(IllegalArgumentException.class, () -> frame.setSecondThrow(5));
    }

    // Tests pour les bonus strikes
    @Test
    public void testBowlingFrameBonusStrikeSimple() {
        frame.setFirstThrow(10);
        frame.setBonus(5);
        assertEquals(15, frame.getScore());
    }

    @Test
    public void testBowlingFrameBonusStrikeDouble() {
        frame.setFirstThrow(10);
        frame.setBonus(20);
        assertEquals(30, frame.getScore());
    }

    @Test
    public void testBowlingFrameBonusStrikeIllegal() {
        frame.setFirstThrow(10);
        assertThrows(IllegalArgumentException.class, () -> frame.setBonus(21));
    }

    @Test
    public void testBowlingFrameBonusStrikeIllegal2() {
        frame.setFirstThrow(8);
        frame.setSecondThrow(1);
        assertThrows(IllegalArgumentException.class, () -> frame.setBonus(4));
    }

    // Tests pour les bonus spares
    @Test
    public void testBowlingFrameBonusSpareSimple() {
        frame.setFirstThrow(5);
        frame.setSecondThrow(5);
        frame.setBonus(5);
        assertEquals(15, frame.getScore());
    }

    @Test
    public void testBowlingFrameBonusSpareIllegal1() {
        frame.setFirstThrow(5);
        frame.setFirstThrow(5);
        assertThrows(IllegalArgumentException.class, () -> frame.setBonus(11));
    }

    @Test
    public void testBowlingFrameBonusSpareIllegal2() {
        frame.setFirstThrow(5);
        frame.setFirstThrow(3);
        assertThrows(IllegalArgumentException.class, () -> frame.setBonus(5));
    }
}