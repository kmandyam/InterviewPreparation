import java.util.*;
public class GraphSearchSort {
  public static void main(String[] args) {
    // construct a graph and see if it passes through with topologicalsort
    HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

    List<Integer> in1 = new ArrayList<Integer>();
    graph.put(1, in1);

    List<Integer> in2 = new ArrayList<Integer>();
    in2.add(1);
    graph.put(2, in2);

    List<Integer> in3 = new ArrayList<Integer>();
    in3.add(2);
    in3.add(4);
    graph.put(3, in3);

    List<Integer> in4 = new ArrayList<Integer>();
    in4.add(1);
    in4.add(5);
    graph.put(4, in4);

    List<Integer> in5 = new ArrayList<Integer>();
    in5.add(6);
    graph.put(5, in5);

    List<Integer> in6 = new ArrayList<Integer>();
    in6.add(4);
    graph.put(6, in6);

    List<Integer> in8 = new ArrayList<Integer>();
    in8.add(5);
    in8.add(6);
    in8.add(9);
    graph.put(8, in8);

    List<Integer> in7 = new ArrayList<Integer>();
    graph.put(7, in7);

    List<Integer> in9 = new ArrayList<Integer>();
    graph.put(9, in9);


    System.out.println(topo(graph));
  }

  // topologicalsort
  public static List<Integer> topo(HashMap<Integer, List<Integer>> graph) {
    Queue<Integer> q = new LinkedList<Integer>();
    Set<Integer> seen = new HashSet<Integer>();

    // add in-degree zeroes to q
    for(int node : graph.keySet()) {
      if(graph.get(node).size() == 0) {
        // I have no indegrees
        q.add(node);
        seen.add(node);
      }
    }

    List<Integer> output = new ArrayList<Integer>();

    while(q.peek() != null) {
      int curr = q.remove();
      // seen.add(curr);
      output.add(curr);

      for(int node : graph.keySet()) {
        List<Integer> list = graph.get(node);
        list.remove((Integer) curr);
      }

      for(int node : graph.keySet()) {
        if(graph.get(node).size() == 0 && !seen.contains(node)) {
          q.add(node);
          seen.add(node);
        }
      }

    }

    if(output.size() == graph.keySet().size()) {
      return output;
    }else {
      return null;
    }

  }


  // bfs

  // dfs
}
