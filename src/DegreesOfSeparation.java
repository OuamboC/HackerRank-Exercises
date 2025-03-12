import java.util.*;

public class DegreesOfSeparation {
    public static int DegreeOfSeparation(int N, int M, List<Integer> connections, int A, int B) {
        // Write your code here
        //Step 1 : Build the adjacency list
        //Use HashMap to store each individual and their relationShip
        HashMap<Integer, List<Integer>> adjancencylist = new HashMap<>();
        //Looping throught the connection
        for (int i = 0; i < connections.size(); i += 2) {
            int person1 = connections.get(i);
            int person2 = connections.get(i + 1);
            //Associated person2 and person1
            adjancencylist.computeIfAbsent(person1, k -> new ArrayList<>()).add(person2);
            //Associated person1 and person2
            adjancencylist.computeIfAbsent(person2, k -> new ArrayList<>()).add(person1);
        }
        // Step 2 : Perform BFS to find the shortest path from A to B
        return breadthFirstSearch(A, B, adjancencylist, N);
    }

    //Create a function to perform breadthFirstSearch of tree representation of adjacency List representation
    private static int breadthFirstSearch(int start, int target, HashMap<Integer, List<Integer>> adjacencyList, int N) {
        if (start == target) {
            return 0; // A person is 0 steps away from themselves
        }
        //Use Queue to perform BFS on our graph
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N]; //Track visited individuals
        int[] distance = new int[N]; // Store shortest path distance

        queue.add(start); // Add the starting node
        visited[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll(); // Remove and process the front node

            //Visit all the friends  of the current individual (node)
            for (int friend : adjacencyList.getOrDefault(current, new ArrayList<>())) {
                if (!visited[friend]) {
                    visited[friend] = true; // Mark as visited
                    distance[friend] = distance[current] + 1; // Increment distance
                    queue.add(friend);

                    if (friend == target) {
                        return distance[friend]; // Found the shortest path
                    }
                }
            }
        }

        return -1; // If no path exists between A and B
    }
}
