import java.util.*;

public class DFSGraph {
    public static void dfs(int node, Set<Integer> visited, List<List<Integer>> graph) {
        if (!visited.contains(node)) {
            System.out.print(node + " ");
            visited.add(node);
            for (int neighbor : graph.get(node)) {
                dfs(neighbor, visited, graph);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>());               
        graph.add(Arrays.asList(2, 3, 4));          
        graph.add(Arrays.asList(1, 5));              
        graph.add(Arrays.asList(1, 5));              
        graph.add(Arrays.asList(1));                 
        graph.add(Arrays.asList(2, 3));              

        Set<Integer> visited = new HashSet<>();
        dfs(2, visited, graph);                      
        System.out.println();
    }
}
