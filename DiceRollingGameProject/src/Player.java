import java.util.Random;
import java.util.random.RandomGenerator;

public class Player implements IPlayer {

    private String userName;
    private int totalPoint = 0;

    public Player(String userName) {
        this.userName = userName;
    }

    @Override
    public int rollDice(){
        Random random  = new Random();
        return random.nextInt(1,7);
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    @Override
    public void addPoint(int point){
        this.totalPoint += point;
    }

}
