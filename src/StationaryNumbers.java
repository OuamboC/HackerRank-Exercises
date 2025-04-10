import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StationaryNumbers {
    public static int StationaryCount(int numValues, List<Integer> values) {
        // Step 1: Create a copy of the original list to sort
        List<Integer> sortedValues = new ArrayList<>(values);
        // Step 2 : Sort the copied list
        Collections.sort(sortedValues);
        // Step 3 : Initialise length to get to the length of values list
        int length = values.size();
        //Step 4: Initialise counter to track numbers which remain in the same place after sorting
        int count = 0 ;
        // Loop through each element of  values to compare the value of i with the sorted list
        for(int i = 0 ; i < length ; i++){

            // Check if [i] is still on the same position , if it's increment counter
            if(values.get(i).equals(sortedValues.get(i))){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>(List.of(5,2,4,2,5));
        int result = StationaryNumbers.StationaryCount(5,values);
        System.out.println("The count is " + result);
    }
}
