import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GeneralPointTest {

    private GeneralPoint generalPoint;
    @BeforeEach
    void setUp() {
        generalPoint =  new GeneralPoint();
    }

    @Test
    void testAddPoint() {
        int[] points =  {7,8,4};
        ArrayList<Player> players =  new ArrayList<>();
        players.add(new Player("Menes"));
        players.add(new Player("Senes"));
        players.add(new Player("Hilmi"));

        generalPoint.addPoint(players,points);

        assertEquals(7,players.get(0).getTotalPoint());
        assertEquals(8,players.get(1).getTotalPoint());
        assertEquals(4,players.get(2).getTotalPoint());
    }
}