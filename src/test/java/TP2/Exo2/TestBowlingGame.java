package TP2.Exo2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestBowlingGame {
    private BowlingGame game;

    @BeforeEach
    public void setUp() {
        game = new BowlingGame();
    }

    @Test
    public void testGameNormale() {
        game.enregisterFrame(new BowlingFrame(1, 2));
        game.enregisterFrame(new BowlingFrame(1, 2));
        game.enregisterFrame(new BowlingFrame(1, 2));
        game.enregisterFrame(new BowlingFrame(1, 2));
        game.enregisterFrame(new BowlingFrame(1, 2));
        game.enregisterFrame(new BowlingFrame(1, 2));
        game.enregisterFrame(new BowlingFrame(1, 2));
        game.enregisterFrame(new BowlingFrame(1, 2));
        game.enregisterFrame(new BowlingFrame(1, 2));
        game.enregisterFrame(new BowlingFrameLast(1, 2));

        assertEquals(30, game.getScoreTotale());
    }

    @Test
    public void testGamePasDeLastFrame() {
        game.enregisterFrame(new BowlingFrame(1, 2));
        game.enregisterFrame(new BowlingFrame(1, 2));
        game.enregisterFrame(new BowlingFrame(1, 2));
        game.enregisterFrame(new BowlingFrame(1, 2));
        game.enregisterFrame(new BowlingFrame(1, 2));
        game.enregisterFrame(new BowlingFrame(1, 2));
        game.enregisterFrame(new BowlingFrame(1, 2));
        game.enregisterFrame(new BowlingFrame(1, 2));
        game.enregisterFrame(new BowlingFrame(1, 2));
        assertThrows(IllegalArgumentException.class, () -> game.enregisterFrame(new BowlingFrame(1, 2)));
    }

    @Test
    public void testGamePasDeLastFrameAvantLaFin() {
        game.enregisterFrame(new BowlingFrame(1, 2));
        assertThrows(IllegalArgumentException.class, () -> game.enregisterFrame(new BowlingFrameLast(1, 2)));
    }

    @Test
    public void testGameIncomplete() {
        game.enregisterFrame(new BowlingFrame(1, 2));
        game.enregisterFrame(new BowlingFrame(1, 2));
        game.enregisterFrame(new BowlingFrame(1, 2));

        assertEquals(9, game.getScoreTotale());
    }

    @Test
    public void testGetScorePourIndex() {
        game.enregisterFrame(new BowlingFrame(1, 2));
        game.enregisterFrame(new BowlingFrame(1, 8));
        game.enregisterFrame(new BowlingFrame(1, 2));

        assertEquals(9, game.getScorePourFrame(1));
    }

    @Test
    public void testPerfectGame() {
        game.enregisterFrame(getStrikeFrame());
        game.enregisterFrame(getStrikeFrame());
        game.enregisterFrame(getStrikeFrame());
        game.enregisterFrame(getStrikeFrame());
        game.enregisterFrame(getStrikeFrame());
        game.enregisterFrame(getStrikeFrame());
        game.enregisterFrame(getStrikeFrame());
        game.enregisterFrame(getStrikeFrame());
        game.enregisterFrame(getStrikeFrame());
        BowlingFrame perfectFrame = new BowlingFrameLast(10,10,10);
        game.enregisterFrame(perfectFrame);

        assertEquals(300, game.getScoreTotale());
    }

    @Test
    public void testGameWithSpares() {
        game.enregisterFrame(new BowlingFrame(1, 1));
        game.enregisterFrame(new BowlingFrame(1, 1));
        game.enregisterFrame(new BowlingFrame(1, 1));
        game.enregisterFrame(new BowlingFrame(1, 9));
        game.enregisterFrame(new BowlingFrame(1, 1));
        game.enregisterFrame(new BowlingFrame(1, 1));
        game.enregisterFrame(new BowlingFrame(1, 1));
        game.enregisterFrame(new BowlingFrame(1, 1));
        game.enregisterFrame(new BowlingFrame(1, 9));
        game.enregisterFrame(new BowlingFrameLast(1, 1,1));

        assertEquals(39, game.getScoreTotale());
    }

    @Test
    public void testGameWithStrikes() {
        game.enregisterFrame(new BowlingFrame(1, 1));
        game.enregisterFrame(new BowlingFrame(1, 1));
        game.enregisterFrame(new BowlingFrame(1, 1));
        game.enregisterFrame(getStrikeFrame());
        game.enregisterFrame(new BowlingFrame(1, 1));
        game.enregisterFrame(new BowlingFrame(1, 1));
        game.enregisterFrame(new BowlingFrame(1, 1));
        game.enregisterFrame(getStrikeFrame());
        game.enregisterFrame(new BowlingFrame(1, 1));
        game.enregisterFrame(new BowlingFrameLast(1, 1,1));

        assertEquals(41, game.getScoreTotale());
    }

    public BowlingFrame getStrikeFrame() {
        BowlingFrame strikeFrame = new BowlingFrame();
        strikeFrame.setFirstThrow(10);
        return strikeFrame;
    }
}
