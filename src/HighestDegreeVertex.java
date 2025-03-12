import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HighestDegreeVertex {
    public static int MaxDegreeVertex(int N, int M, List<Integer> connections) {

        // Write your code here
        // Step 1: Use HashMap to store the key(node) and edge ( by counting it )

        HashMap<Integer, Integer> myMap = new HashMap<>();
        //Step 2 : Loop through the connections list in steps
        // of 2 as each edge is represented by 2 consecutive integers
        for(int i = 0 ; i < connections.size() ; i+=2){
           int u  = connections.get(i);
           int v = connections.get(i+1);

           //Step 3: Populate Mymap with u , and counting its number of edges
            myMap.put(u, myMap.getOrDefault(u,0) +1);
            //Step 4: Populate Mymap with v , and counting its number of edges
            myMap.put(v, myMap.getOrDefault(v, 0)+1);

        }
        // Step 5 : Find the vertex which has the highest degree
        int maxDegree = -1;
        int maxVertex = -1;

        // Step 6 : Loop through all vertices ( 0 to N-1)
        for( int vertex = 0 ; vertex < N ;  vertex++){
            //A vertex with no edges has a degree of 0
            int degree = myMap.getOrDefault(vertex,0);

            if(degree > maxDegree){
                maxDegree = degree;
                maxVertex = vertex;
            }
        }
        //Return the vertex with the highest degree
        return maxVertex;
    }

    public static void main(String[] args) {
        // Test case 1
        List<Integer> connections1 = Arrays.asList(4, 3, 2, 4, 1, 4);
        System.out.println("Test Case 1: " + MaxDegreeVertex(5, 3, connections1)); // Expected output: 4

        // Test case 2: Single vertex, no edges
        List<Integer> connections2 = Arrays.asList();
        System.out.println("Test Case 2: " + MaxDegreeVertex(1, 0, connections2)); // Expected output: 0

        // Test case 3
        List<Integer> connections3 = Arrays.asList(4, 0, 0 ,9 ,8 ,7 ,0 ,2 ,2 ,7 ,
                0 ,6, 5, 9 ,2 ,6 ,5 ,1 ,5 ,2 ,1 ,7 ,1, 4 ,0 ,7 ,0 ,1 ,4 ,3 ,1 ,6);
        System.out.println("Test Case 3: " + MaxDegreeVertex(10, 16, connections3)); // Expected output: 0

        // Test case 4: Multiple vertices with same degree
        List<Integer> connections4 = Arrays.asList(13 ,18 ,7 ,17 ,12 ,9 ,14, 3 ,14,
                9 ,12 ,1 ,12, 14 ,14 ,15 ,18 ,15 ,3 ,15 ,6 ,18, 7 ,10, 0 ,17 ,18 ,0 ,13, 1);
        System.out.println("Test Case 4: " + MaxDegreeVertex(20, 15, connections4)); // Expected output: 14

        // Test case 5: Large graph
        List<Integer> connections5 = Arrays.asList(16, 0 ,4 ,17 ,11 ,5, 14, 7 ,12 ,
                15 ,3, 8 ,0 ,18, 9 ,4 ,17 ,7 ,11 ,12,
                8 ,10, 0 ,11 ,10 ,12, 7 ,2, 6 ,1 ,4 ,0,
                14, 9 ,18 ,3 ,10 ,3 ,13 ,14 ,14 ,16 ,0 ,
                14 ,1 ,10 ,18 ,11 ,12 ,1 ,1 ,19 ,12 ,19);
        System.out.println("Test Case 5: " + MaxDegreeVertex(20, 27, connections5)); // Expected output: 0

    }
}
