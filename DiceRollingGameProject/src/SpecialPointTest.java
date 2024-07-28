import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SpecialPointTest {

    private SpecialPoint specialPoint;

    @BeforeEach
    void setUp() {
        specialPoint =  new SpecialPoint();
    }

    @Test
    void testAddPoint() {
        int[] points =  {4,4,2};
        ArrayList<Player> players =  new ArrayList<>();
        players.add(new Player("Menes"));
        players.add(new Player("Senes"));
        players.add(new Player("Hilmi"));


        specialPoint.addPoint(players,points);
        assertEquals(8, players.get(0).getTotalPoint());
        assertEquals(8, players.get(1).getTotalPoint());
        assertEquals(2, players.get(2).getTotalPoint());
    }


}