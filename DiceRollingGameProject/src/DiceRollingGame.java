import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class DiceRollingGame {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        // {ASK MENTOR} burada scanner objesini olusturmam dogrumu yoksa getPlayersName classinin icinden mi olusturmaliyim ??
        ArrayList<String> playersName = getPlayersName(scanner);
        ArrayList<Player> players = createPlayers(playersName);
        // getting target round that players want to  play
        int targetRound = getTargetRound();

        PointAdder pointAdder = new PointAdder();
        initializeRounds(targetRound,players, pointAdder);
        showAllPlayersWithUserNameAndTotalPoint(players);
        showWinnerPlayer(getWinnerPlayer(players));


    }

    private static Player getWinnerPlayer(ArrayList<Player> players) {
        // gets  winner player
        // TO DO check  whether two or more people gets same points also ???
        return players.stream().max(Comparator.comparing(Player::getTotalPoint)).get();
    }

    private static void showWinnerPlayer(Player winnerPlayer) {
        System.out.println("Winner :  " + winnerPlayer.getUserName() + " Total Point :  " + winnerPlayer.getTotalPoint());
    }

    private static void showAllPlayersWithUserNameAndTotalPoint(ArrayList<Player> players) {
        for(Player player : players){
            System.out.println(player.getUserName() +  " -- " + player.getTotalPoint());
        }
    }

    private static void initializeRounds(int targetRound, ArrayList<Player> players, PointAdder pointAdder) {
        int[] currentRolledDicePoints = {0,0,0};

        while (targetRound > 0 ){

            // every player rolling dice and then store values in int [] currentRolledDicePoints
            rollDiceForEveryUser(players,currentRolledDicePoints);
            System.out.printf("%s : " + currentRolledDicePoints[0] + " --- %s : " + currentRolledDicePoints[1] + " --- %s: " + currentRolledDicePoints[2] + "\n",
                    players.get(0).getUserName(),players.get(1).getUserName(),players.get(2).getUserName());
           //STRATEGY PATTERN USAGE
            if(isSameDoublePointAndGreaterThanOtherPoint(currentRolledDicePoints)){
                // polymorphism
               pointAdder.addPoint(new SpecialPoint(), players, currentRolledDicePoints);
           }else{
               pointAdder.addPoint(new GeneralPoint(), players, currentRolledDicePoints);
           }
           targetRound--;
        }
    }


    // roll dice for every user and then add the points that players get to currentRolledDicePoints array
    private static void rollDiceForEveryUser(ArrayList<Player> players, int[] currentRolledDicePoints) {

        for (int i = 0; i < players.size(); i++) {
            currentRolledDicePoints[i] = players.get(i).rollDice();
        }
    }

    private static ArrayList<Player> createPlayers(ArrayList<String> playerNames) {

        // {ASK MENTOR}this method create and add islemi ayni anda yapiyor dogru mu ??

        ArrayList<Player> players = new ArrayList<>();
        for(String playerName : playerNames){
            players.add(new Player(playerName));
        }
        return players;
    }

    public static ArrayList<String> getPlayersName(Scanner scanner) {
        ArrayList<String> userNames =  new ArrayList<>();
        System.out.println("------- Welcome to DiceRollingGame --------- ");
        System.out.print("How many player do you wanna play ? ");
        int playerNumber = scanner.nextInt();
        String playerName = null;

        // get player name and call addPlayerNameToList method to add player names to arraylist
        for (int i = 1; i <=playerNumber ; i++) {
            System.out.printf("Enter a %d. playerName : " , i);
            playerName = scanner.next();
            addPlayerNameToList(userNames,playerName);
        }

        return userNames;
    }

    private static void addPlayerNameToList(ArrayList<String> userNames, String playerName) {
        userNames.add(playerName);
    }


    private static Boolean isSameDoublePointAndGreaterThanOtherPoint(int [] currentPointsOfPlayers) {

        if((currentPointsOfPlayers[0] == currentPointsOfPlayers[1]) && currentPointsOfPlayers[0] > currentPointsOfPlayers[2]){
            return  true;
        } else if ((currentPointsOfPlayers[0] == currentPointsOfPlayers[2]) && currentPointsOfPlayers[0] > currentPointsOfPlayers[1]) {
            return true;
        } else return ((currentPointsOfPlayers[1] == currentPointsOfPlayers[2]) && currentPointsOfPlayers[1] > currentPointsOfPlayers[0]);

    }

    // target round should be between 1 and 99
    private static int getTargetRound() {
        int targetRound;
        // {ASK MENTOR} buradaki scanner objecsini getTargetRound a parametre olarak mi vermeliyim ??
        // yoksa bu dogru kullanim mi ??
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.print("Enter the target number of rounds : ");
            targetRound = scanner.nextInt();
        }while(!isTargetRoundValid(targetRound));

        // bunu yaptigimda hata aliyorum acaba recursiondan dolayi mi hata aliyorum ?? daha sonra dene
//        while(!(isTargetRoundValid(targetRound))){
//            getTargetRound();
//        }

        return targetRound;
    }

    // check whether user enter valid inputs
    private static boolean isTargetRoundValid(int targetRound) {
        if((targetRound <= 99 && targetRound >= 1)){
            return true;
        }
        System.out.println("Your target number should be between 1 and 99 !!!");
        return  false;
    }

}