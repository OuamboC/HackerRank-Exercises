import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountUniquePairs {
    public static int UniquePairs(int n, List<Integer> values) {

        //Use HashMap to store the frequencies of all values
        HashMap<Integer, Integer> myMap = new HashMap<>();
        //Populate the HashMap
        for( int i : values){
            myMap.put(i, myMap.getOrDefault(i, 0)+1);
        }

        //Initialise the frequencies of any number to 0
        int maxFrequencies = 0;
        //Create a List
        List<Integer> result = new ArrayList<>();
        // Loop through myMap to form all pairs uniquely
        for(int key : myMap.keySet()){
            //Get the frequency of the number
            int count = myMap.get(key);
            if(count > maxFrequencies){
                //Update the maxFrequencies
                maxFrequencies = count;
                //Clear the result list if a new max is found
               result.clear();
                result.add(key);
            }else if (count == maxFrequencies){
                result.add(key);
            }
        }
        // Generate unique pairs from the result list
        List<String> pairs = new ArrayList<>();
        for(int i =0 ; i < result.size(); i++){
            for(int j = i+1 ; j < result.size(); j++){
                pairs.add("(" + result.get(i) + ", " + result.get(j) +")");
            }
        }
        //Return the count of unique pairs
        return pairs.size();
    }
}
