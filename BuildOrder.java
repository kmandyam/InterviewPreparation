import java.util.*;

public class BuildOrder {

  public static void main(String[] args) {
    List<String> projects = new ArrayList<String>();
    projects.add("a");
    projects.add("b");
    projects.add("c");
    projects.add("d");
    projects.add("e");
    projects.add("f");
    String[][] dependencies = {{"d", "a"}, {"b", "f"}, {"d", "b"}, {"a", "f"}, {"c", "d"}};
    System.out.println(buildOrdering(projects, dependencies));
  }



  public static List<String> buildOrdering(List<String> projects, String[][] dependencies) {
    HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
    for(int i = 0; i < projects.size(); i++) {
      String project = projects.get(i);
      graph.put(project, new ArrayList<String>());
    }

    for(int i = 0; i < dependencies.length; i++) {
      String[] pair = dependencies[i];
      graph.get(pair[0]).add(pair[1]);
    }

    return topologicalSort(graph);
  }

  public static List<String> topologicalSort(HashMap<String, List<String>> graph) {
    List<String> order = new ArrayList<String>();
    Queue<String> queue = new LinkedList<String>();
    HashSet<String> seen = new HashSet<String>();
    for(String p : graph.keySet()) {
      if(graph.get(p).size() == 0) {
        queue.add(p);
        seen.add(p);
      }
    }

    while(queue.peek() != null) {
      // System.out.println(queue);
      String project = queue.remove();
      order.add(project);
      for(String p : graph.keySet()) {
        graph.get(p).remove(project);
      }


      for(String p : graph.keySet()) {
        if(graph.get(p).size() == 0 && !seen.contains(p)) {
          queue.add(p);
          seen.add(p);
        }
      }

    }

    if(order.size() != graph.keySet().size()) {
      return null;
    }
    return order;
  }



}
