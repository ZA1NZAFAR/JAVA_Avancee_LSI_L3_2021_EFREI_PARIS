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
    public void testGameNormale() { // un test de base
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
    public void testGamePasDeLastFrame() { // test le dernier frame doit être un last frame et non pas un frame normale
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
    public void testGamePasDeLastFrameAvantLaFin() { // tester qu'un last frame n'est pas accepté avant la fin du jeu
        game.enregisterFrame(new BowlingFrame(1, 2));
        assertThrows(IllegalArgumentException.class, () -> game.enregisterFrame(new BowlingFrameLast(1, 2)));
    }

    @Test
    public void testGameIncomplete() { // tester qu'un game incomplete retourne un score quand même
        game.enregisterFrame(new BowlingFrame(1, 2));
        game.enregisterFrame(new BowlingFrame(1, 2));
        game.enregisterFrame(new BowlingFrame(1, 2));

        assertEquals(9, game.getScoreTotale());
    }

    @Test
    public void testGetScorePourIndex() { // tester que le score est correct pour un index
        game.enregisterFrame(new BowlingFrame(1, 2));
        game.enregisterFrame(new BowlingFrame(1, 8));
        game.enregisterFrame(new BowlingFrame(1, 2));

        assertEquals(9, game.getScorePourFrame(1));
    }

    @Test
    public void testPerfectGame() { // tester un game avec tous les strikes (un score max)
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
    public void testGameWithSpares() { // tester un game avec des spares
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
    public void testGameWithStrikes() { // tester un game avec des strikes
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

    public BowlingFrame getStrikeFrame() { // créer un frame strike
        BowlingFrame strikeFrame = new BowlingFrame();
        strikeFrame.setFirstThrow(10);
        return strikeFrame;
    }
}
