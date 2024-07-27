import java.util.ArrayList;

public class SpecialPoint implements Point {
    @Override
    public void addPoint(ArrayList<Player> players, int[] points) {

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
