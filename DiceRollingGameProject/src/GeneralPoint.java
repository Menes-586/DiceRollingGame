import java.util.ArrayList;

public class GeneralPoint implements Point{


    //  add points to players what they got from rollDice
    @Override
    public void addPoint(ArrayList<Player> players, int[] points) {

        for (int i = 0; i < players.size(); i++) {
            players.get(i).addPoint(points[i]);
        }
    }
}

