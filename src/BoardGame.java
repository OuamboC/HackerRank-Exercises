import java.util.HashMap;

public class BoardGame {

    public static long CountWays(int m, int n) {
        // Memoization : Use HashMap to store computed results
        HashMap<Integer, Long> myMap = new HashMap<>();
        // We need to reach square n-1 from square 0, so we need to travel n-1 steps
        return helper(m, n-1, myMap);
    }

    private static long helper(int m, int n, HashMap<Integer, Long> myMap) {
        // Base cases : To reached the target and the go above the target
        if(n == 0) { // Count as 1 valid path (reached target)
            return 1;
        }
        if (n < 0) { // Count as 0
            return 0;
        }
        // check if already computed
        if(myMap.containsKey(n)) {
            return myMap.get(n);
        }
        // Initialize the total to 0
        long total = 0;
        // In here we must try all possible dice moves (1 to m times)
        for (int i = 1; i <= m; i++) {
            //Recursively calculate all possible ways for remaining squares
            total += helper(m, n - i, myMap);
        }
        // Store result in memoization map
        myMap.put(n, total);
        return total;
    }

    public static void main(String[] args) {
        System.out.println("case1: " + CountWays(4 ,10 ));
    }
}
