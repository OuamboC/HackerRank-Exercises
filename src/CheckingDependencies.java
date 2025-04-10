import java.util.*;

public class CheckingDependencies {
    public static String CheckDependency(int numObjects, int numDependencies, int A, int B, List<Integer> dependencies) {
        // Graphic representation :  3 -> 10 ->2
        // sTEP 1 : Create  a HashMap to store  the node and their dependencies
        HashMap<Integer, List<Integer>> adjencyList= new HashMap<>();
        // Step 2 :  Loop through  teh list of dependencies to store all objects and count increment their dependencies
        for(int i = 0 ; i < dependencies.size(); i+=2){
            int from  = dependencies.get(i);
            int to = dependencies.get(i+1);
            // By Building the adjencyList , create the dependencies relationships ( from -> to)
            adjencyList.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
        }

        //Step 3: Perform BFS bo check igf B depends on A ( transitively)
        // Create a queue to explore level by level
        Queue<Integer> myQueue = new LinkedList<>();
        // Create a HashSet to unique visit a node
        HashSet<Integer> vistedNode = new HashSet<>();
        myQueue.add(B);
        vistedNode.add(B);

        while(!myQueue.isEmpty()) {
            int current = myQueue.poll();
            if(current == A){
                return "TRUE"; // B depends on A
            }
            // Add all the current dependencies to the queue
            if(adjencyList.containsKey(current)) {
                for( int dependency : adjencyList.get(current)) {
                    if(!vistedNode.contains(dependency)){
                        vistedNode.add(dependency);
                        myQueue.add(dependency);
                    }
                }
            }
        }

        return "FALSE";
    }

    public static void main(String[] args) {
        List<Integer> dependency = new ArrayList<>(List.of(6, 7, 6, 2, 1, 3, 1,
                0, 1, 4, 1, 6, 5, 9, 9, 8, 8, 1));
        System.out.println(CheckingDependencies.CheckDependency(10,9,8,6,dependency));

    }
}
