import java.util.*;

public class LeaderboardPositions {
    public static int  LeaderboardPosition(int nLines, List<String> scoreData, String name) {
        // Step 1: Create a HashMap  to store names and scores
        HashMap <String, Integer> myMap = new HashMap<>();
        //Step 2 : Populate myMap with name and scoreData  for each player
        for(int i = 0 ; i < nLines; i++){
            // Get the score of each player
            String score = scoreData.get(i);
            // Split the score to the name
            String[] divideNameToScore = score.trim().split("\\s+");
            //Get then the playerName
            String playerName = divideNameToScore[0];
            //Get the score of the player
            int PlayerScore = Integer.parseInt(divideNameToScore[1]);
            //Therefore populate the myMap with name and score
            myMap.put(playerName ,PlayerScore);
        }
        System.out.println(myMap);
        // Step 3 : Create HashSet to store unique scores
        HashSet<Integer> mySet = new HashSet<>();
        //Step 4 : Populate  mySet with unique scores from myMap
        for(Integer PlayerScore : myMap.values()){
            mySet.add(PlayerScore);
        }
        System.out.println(mySet);
        //Step 5 : Sort the score using TreeSet
        TreeSet<Integer> mySetSorting = new TreeSet<>(mySet);
        System.out.println(mySetSorting);
        //Step 6 : Create a HashMap to store the rank and the score of the players
        HashMap<Integer, Integer> myRankings = new HashMap<>();
        //Set the base case to ( currentRank  is 1st, obviously)
        int currentRanking = 1;
        for(int score : mySetSorting){
            myRankings.put(score, currentRanking);
            //Count how many players have the same score
            int count = 0;
            for(int playerScore: myMap.values()){
                if(playerScore == score){
                    count++;
                }
            }
            // If the next player has a different score , the rank should skip the tied positions
            currentRanking += count;
        }
        //Step 7 : Get the score of the target player
        int targetScore = myMap.get(name);
        return myRankings.get(targetScore);

    }

    public static void main(String[] args) {
        List<String> playersAndScore = Arrays.asList(
                "Ardath 1",
                "Kerstin 1",
                "Tomasine 4",
                "Cordula 4",
                "Valene 1"

        );
        int rank = LeaderboardPosition(5, playersAndScore,"Cordula");
        System.out.println(rank);

    }


}
