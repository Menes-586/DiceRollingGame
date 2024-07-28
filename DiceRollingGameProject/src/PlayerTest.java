import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;
    @BeforeEach
    public void setUp(){
        this.player = new Player();
    }

    @Test
    public void testSetUserName(){
        player.setUserName("Menes");
        assertEquals("Menes" , player.getUserName());
    }

    @Test
    public void testRollDice() {
        // checking rollDice for multiple random values
        for (int i = 0; i < 10; i++) {
            int rolledDicedValue =  player.rollDice();
            assertTrue(rolledDicedValue >= 1 && rolledDicedValue <= 6);
        }
    }

    @Test
    public void testAddPoint() {

        // first totalPoint  of player equals to 0
        System.out.println("First Total Point : " + player.getTotalPoint());

        player.addPoint(5);
        assertEquals(5 , player.getTotalPoint());

        player.addPoint(4);
        assertEquals(9 , player.getTotalPoint());
    }
}