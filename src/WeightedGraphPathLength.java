import java.util.*;

public class WeightedGraphPathLength {
    public static int PathLength(int numVert, int numEdge, int v0, int v1, List<Integer> edges) {
        //Step 1 : Build the adjacency List with weight
        HashMap<Integer, List<int[]>> adjacencyList = new HashMap<>();
        //Step 2 : Loop through edges list
        for(int i = 0 ; i < edges.size(); i+=3){
            int u = edges.get(i);
            int v = edges.get(i+1);
            int weight = edges.get(i+2);
            adjacencyList.computeIfAbsent(u,k-> new ArrayList<>()).add(new int[]{v, weight});
            adjacencyList.computeIfAbsent(v,k-> new ArrayList<>()).add(new int[]{u, weight});
        }
        //Step 3: Perform BFS to find the path
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> myMap = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();

        queue.add(v0);
        visited.add(v0);
        myMap.put(v0, -1);
        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == v1){
                break;  // Found the target
            }

            for (int[] edge : adjacencyList.getOrDefault(current, new ArrayList<>())) {
                int neighbour = edge[0];
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    myMap.put(neighbour, current);
                    queue.add(neighbour);
                }
            }
        }

        //Step 4 : Reconstruct the path and summing weigths
        int sum = 0;
        int node = v1; // start from the target node

        while( node != v0){
            int precedentNode = myMap.get(node);
            //Find the edge weight between precedentNode and node
            for (int[] edge : adjacencyList.get(precedentNode)){
                if(edge[0] == node){
                    sum +=edge[1];
                    break;
                }
            }
            node = precedentNode; // Move top the parent
        }
        return sum;

    }
}
