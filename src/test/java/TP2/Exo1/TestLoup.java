package TP2.Exo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLoup {

    private Loup loup;

    @BeforeEach
    public void setUp() {
        loup = new Loup("Shadow", Orientation.NORD);
    }

    @Test
    public void testDirectionNordDefault() {
        assertEquals(loup.getOrientation(), Orientation.NORD);
    }

    @Test
    public void testDirectionEst() {
        loup.turnClockwise();
        assertEquals(loup.getOrientation(), Orientation.EST);
    }

    @Test
    public void testDirectionSud() {
        loup.turnClockwise();
        loup.turnClockwise();
        assertEquals(loup.getOrientation(), Orientation.SUD);
    }

    @Test
    public void testDirectionOuest() {
        loup.turnClockwise();
        loup.turnClockwise();
        loup.turnClockwise();
        assertEquals(loup.getOrientation(), Orientation.OUEST);
    }

    @Test
    public void testDirectionReturnNord() {
        loup.turnClockwise();
        loup.turnClockwise();
        loup.turnClockwise();
        loup.turnClockwise();
        assertEquals(loup.getOrientation(), Orientation.NORD);
    }

}
