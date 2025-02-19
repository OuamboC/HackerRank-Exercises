import java.util.HashMap;
import java.util.List;

public class FindMode {
    public static int Mode(int n, List<Integer> values) {
        // Write your code here
        /**
         * Unimodal Distribution : While the mode appears more time in the distribution than any other value.
         * if Unimodal Distribution  - Return the mode
         * Multimodal Distribution: While distribution has more than one mode
         * if Multimodal Distribution - Return -1.
         */
        //Use HashMap to store the occurrences of number in a distribution
        HashMap<Integer,Integer> myMap = new HashMap<>();
        //Loop through the values to populate myMap
        for(int i : values){
            myMap.put(i, myMap.getOrDefault(i,0)+1);
        }
        /**
         * Loop through the HashMap to
         * Condition1: Return the mode if a number appears more than other values
         * Condition2: Return -1  if we have many count than is equal
         */
        // Initialise the  occurrence to 0
        int maxOccurrences = 0;
        //Initialise the mode to -1
        int modeElement = -1;
        //Assume that the Multimodal is false
        boolean IsMultimodal = false;

        //Condition1: Return the mode if a number appears more than other values
        for(int key : myMap.keySet()){
            //Get the occurrence of a number
            int count = myMap.get(key);
            //Find the most occurrences
            if(count > maxOccurrences){
                // Update the maxOccurrences
                maxOccurrences = count;
                modeElement = key;
                IsMultimodal = false;
            }else if(count == maxOccurrences){
                IsMultimodal = true;
            }
        }
        //Condition2: Return -1  if we have many count than is equal
            if(IsMultimodal){
                return -1;
            }else{
                return modeElement;
            }


    }
}
