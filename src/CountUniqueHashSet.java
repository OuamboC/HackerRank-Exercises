import java.util.HashSet;
import java.util.List;

public class CountUniqueHashSet {
    public static int UniquePairs(int n, List<Integer> values) {
        HashSet<Integer> myMap = new HashSet<>();
        for( int value : values){
            myMap.add(value);
        }
        int answer = myMap.size() * (myMap.size() - 1)/2;
        return answer;

    }
}




//public static int UniquePairs(int n, List<Integer> values) {
//    if (values == null || values.size() < 2) {
//        return 0;
//    }
//
//    // Step 1: Count occurrences of each number using a HashMap
//    HashMap<Integer, Integer> frequencyMap = new HashMap<>();
//    for (int value : values) {
//        frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
//    }
//
//    // Step 2: Calculate unique pairs based on frequencies of different numbers
//    int uniquePairs = 0;
//    List<Integer> uniqueNumbers = new ArrayList<>(frequencyMap.keySet());
//
//    for (int i = 0; i < uniqueNumbers.size(); i++) {
//        for (int j = i + 1; j < uniqueNumbers.size(); j++) {
//            // Count how many pairs can be formed between uniqueNumbers[i] and uniqueNumbers[j]
//            uniquePairs++;
//        }
//    }
//
//    return uniquePairs;
//}