
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Scanner scanner;

    @BeforeEach
    public void setUp(){
        scanner =  new Scanner(System.in);

    }

    @Test
    public void testGetPlayersName(){
        ArrayList<String> expectedNames = new ArrayList<>(Arrays.asList("Menes", "Kamil","Faruk"));
        //ArrayList<String > actualNames = DiceRollingGame.getPlayersName(scanner);
        String[] names = {"Kamil","Enes","Faruk"};
        String[] actualNameess = {"Kamil","Enes","Faruk"};

        assertArrayEquals(names,actualNameess);

    }



}