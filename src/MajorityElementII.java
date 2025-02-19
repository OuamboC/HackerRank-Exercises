import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        //Store the result
        List<Integer> answer = new ArrayList<>();
        //Use HashMap to store the occurrence of a number in nums array
        HashMap<Integer, Integer> myMap = new HashMap<>();
        //Count occurrence in the HashMap
        for ( int i : nums ){
           // if(!myMap.containsKey(i))
                myMap.put(i,myMap.getOrDefault(i,0) + 1);
        }
        //Check for the majority element
        for( int key : myMap.keySet()) {
            if(myMap.get(key) > nums.length / 3) {
                answer.add(key);
            }
        }
        return answer;
    }

}
