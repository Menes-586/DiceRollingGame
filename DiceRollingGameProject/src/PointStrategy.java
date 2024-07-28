import java.util.ArrayList;

public class PointStrategy {
    // polymorphism is used here Point is an interface and call the Pointing  methods according the situation
    public void addPoint(Point point, ArrayList<Player> players , int [] points){
        point.addPoint(players,points);
    }
}
