import java.util.*;

public class Solution {
  public static int solution(int[] A, int[] E) {
    // do a dfs from each node to the end of the graph
    // construct a graph
    Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
    for(int i = 0; i < A.length; i++) {
      List<Integer> list = new ArrayList<Integer>();
      graph.put(i + 1, list);
    }

    for(int i = 0; i < E.length; i = i + 2) {
      int first = E[i];
      int second = E[i+1];
      if(!graph.get(first).contains(second)) {
        graph.get(first).add(second);
      }

      if(!graph.get(second).contains(first)) {
        graph.get(second).add(first);
      }
    }

    // find the longest path from each node until I find something with a different label

    int max = 0;
    for(int node : graph.keySet()) {
      Set<Integer> seen = new HashSet<Integer>();
      seen.add(node);
      max = Math.max(longestPath(node, graph, 0, A[node - 1], A, seen), max);
    }
    return max;
  }

  public static int longestPath(int node, Map<Integer, List<Integer>> graph, int length, int label, int[] A, Set<Integer> seen) {
    if(A[node - 1] != label) {
      return length;
    }else{
      // for all the adjacent neighbors with the same label, try going down that path
      int maxPath = length;
      List<Integer> neighbors = graph.get(node);
      for(int i = 0; i < neighbors.size(); i++) {
        int neighbor = neighbors.get(i);
        Set<Integer> seen2 = new HashSet<Integer>();
        seen2.addAll(seen);
        if(!seen2.contains(neighbor) && A[neighbor - 1] == label) {
          // keep recursing
          seen2.add(neighbor);
          maxPath = Math.max(longestPath(neighbor, graph, length + 1, label, A, seen2), maxPath);
        }
      }
      return maxPath;
    }
  }


  public static void main(String[] args) {
    int[] A = {1, 1, 1, 2, 2, 1, 1, 1};
    int[] E = {1, 2, 1, 3, 2, 4, 2, 5, 3, 6, 3, 7, 7, 8};
    System.out.println(solution(A, E));
  }


}
