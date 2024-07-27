import java.util.ArrayList;

public class PointAdder {
    // polymorphism is used here Point is an interface and call the Pointing  methods according the situation
    public void addPoint(Point point, ArrayList<Player> players , int [] points){
        point.addPoint(players,points);
    }
}
