package TP2.Exo2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestBowlingFrameLast {
    private BowlingFrameLast frame;

    @BeforeEach
    public void setUp() {
        frame = new BowlingFrameLast();
    }

    @Test
    public void testGetScoreNoThird() {
        frame.setFirstThrow(5);
        frame.setSecondThrow(4);
        assertEquals(9, frame.getScore());
    }

    @Test
    public void testGetScoreIllegal() {
        frame.setFirstThrow(5);
        frame.setSecondThrow(4);
        assertThrows(IllegalArgumentException.class, () -> frame.setThirdThrow(5));
    }

    @Test
    public void testGetScoreStrike() {
        frame.setFirstThrow(10);
        frame.setSecondThrow(4);
        frame.setThirdThrow(3);
        assertEquals(17, frame.getScore());
    }

    @Test
    public void testGetScoreSpare() {
        frame.setFirstThrow(6);
        frame.setSecondThrow(4);
        frame.setThirdThrow(3);
        assertEquals(13, frame.getScore());
    }

    @Test
    public void testPerfectScore() {
        frame.setFirstThrow(10);
        frame.setSecondThrow(10);
        frame.setThirdThrow(10);
        assertEquals(30, frame.getScore());
    }

    @Test
    public void testSetBonus() {
        frame.setFirstThrow(5);
        frame.setSecondThrow(5);
        frame.setThirdThrow(3);
        assertThrows(UnsupportedOperationException.class, () -> frame.setBonus(5));
    }
}
