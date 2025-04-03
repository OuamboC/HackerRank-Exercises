import java.util.List;

public class GuidedBinarySearch {
    public static int GuidedSearch(int N, List<Integer> values, int pattern, int nSearch) {
        // Step 1: Initialise the search boundaries
        int low = 0;
        int high = N;

        // Step 2: Perform the search operations nSearch times
        for (int i = 0; i < nSearch; i++) {
            /**
             * Step 3 : Get the  current decision bit ( rightmost bit)
             * If the remainder is 1 , then we must  go to upper half
             * if 0 , we must go to lower half
             */
            int currentBit = pattern % 2;
            //Step 4: Remove the bit by going to the right
            pattern = pattern / 2;

            //Step 5: Calculate the middle index
            int mid = (low + high) / 2;

            // Step 6: Update the search boundaries based on the bit
            if (currentBit == 1) {
                // If bit is 1, search in upper half
                low = mid;
            } else {
                // If bit is 0, search in lower half
                high = mid;
            }
        }
        //Step 8: Return the value at the low index
        return values.get(low);
    }
}