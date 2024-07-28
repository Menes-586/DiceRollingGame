import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PointStrategyTest {

    private PointStrategy pointStrategy;
    @BeforeEach
    void setUp() {
        pointStrategy = new PointStrategy();
    }

    @Test
    void testAddPoint() {

        int[] points =  {5,5,4};
        ArrayList<Player> players = createPlayers();

        pointStrategy.addPoint(new SpecialPoint(),players,points);
        assertEquals(10,players.get(0).getTotalPoint());
        assertEquals(10,players.get(1).getTotalPoint());
        assertEquals(4,players.get(2).getTotalPoint());

    }

    @Test
    void test2AddPoint() {
        int[] points =  {4,5,3};
        ArrayList<Player> players = createPlayers();

        pointStrategy.addPoint(new GeneralPoint(),players,points);
        assertEquals(4,players.get(0).getTotalPoint());
        assertEquals(5,players.get(1).getTotalPoint());
        assertEquals(3,players.get(2).getTotalPoint());

    }

    private static ArrayList<Player> createPlayers() {
        ArrayList<Player> players =  new ArrayList<>();
        players.add(new Player("Menes"));
        players.add(new Player("Senes"));
        players.add(new Player("Hilmi"));
        return players;
    }
}