import java.util.ArrayList;

public class SpecialPoint implements Point {
    @Override
    public void addPoint(ArrayList<Player> players, int[] points) {

        // if only two players get same point and this point is greater than  point that other player gets ,
        // then add to  point multiplied by 2  to  players who get same point and add the point other player get to other player
        if(points[0] == points[1] ){
            players.get(0).addPoint(points[0] * 2);
            players.get(1).addPoint(points[1] * 2);
            players.get(2).addPoint(points[2]);
        }
        if(points[0] == points[2]){
            players.get(0).addPoint(points[0] * 2);
            players.get(1).addPoint(points[1]);
            players.get(2).addPoint(points[2] * 2);

        }
        if(points[1] == points[2]){
            players.get(0).addPoint(points[0]);
            players.get(1).addPoint(points[1] * 2);
            players.get(2).addPoint(points[2] * 2);

        }
    }

}
