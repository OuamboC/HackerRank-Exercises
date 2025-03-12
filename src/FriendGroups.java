import java.util.*;

public class FriendGroups {
    public static int LargestFriendGroup(int N, int M, List<Integer> connections) {
        // Step 1 : Build the adjacency List
        //Use the Hashmap to store each  individual and their list of friends
        HashMap<Integer, List<Integer>> groups = new HashMap<>();
        //Looping through connections
        for( int i = 0; i < connections.size(); i +=2){
            int friend1 = connections.get(i);
            int friend2 = connections.get(i+1);
            //Add friend2 to friend1's adjacency list
            groups.computeIfAbsent(friend1 ,k -> new ArrayList<>()).add(friend2);
            //Add friend 1 to friend2's adjacency list
            groups.computeIfAbsent(friend2 ,k -> new ArrayList<>()).add(friend1);
        }
        // Step 2 : Track visited individuals
        boolean [] visited = new boolean[N];
        int maxGroupSize = 0;

        //Step 3 : Traverse  the graph to find the largest friend group
        // so let's loop through each node to find if the node got a parent or sibling or children
        // n: single individuals
        for(int n = 0 ; n < N; n++){
            // If the individual ( node ) is not visited, perform BFS
            if(!visited[n]) {
                int groupSize = breathFirstSearch(n, groups, visited); // Find group size using BFS
                maxGroupSize = Math.max(maxGroupSize, groupSize); // update the largest group size
            }
        }
        return maxGroupSize;
    }
    // Step 4 : Create a function to perform BFS and the size of the friend group
    private static int breathFirstSearch(int start , HashMap<Integer, List<Integer>> groups, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start); // Add the starting node
        visited[start] = true;
        int groupSize = 0 ;

        while(!queue.isEmpty()) {
            int current = queue.poll(); // Remove and process the front node
            groupSize++;

            //Visit all the friends  of the current individual (node)
            for( int friend : groups.getOrDefault(current, new ArrayList<>())) {
                if(!visited[friend]){
                    visited[friend] = true ; // Mark as visited
                    queue.add(friend); // Add to the queue for further traversal
                }
            }
        }
        return  groupSize;
    }

}
