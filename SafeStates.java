public class SafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        Set<Integer> safeNodes = new HashSet<Integer>();
        Set<Integer> unsafeNodes = new HashSet<Integer>();

        for (int i = 0; i < graph.length; i++) {
            Set<Integer> visitedNodes = new HashSet<Integer>();
            boolean result = isEventuallySafe(graph, safeNodes, unsafeNodes, visitedNodes, i);
            if (result) {
                safeNodes.add(i);
            } else {
                unsafeNodes.add(i);
            }
        }

        List<Integer> eventualSafeNodes = new ArrayList<Integer>(safeNodes);
        Collections.sort(eventualSafeNodes);
        return eventualSafeNodes;
    }

    public boolean isEventuallySafe(int[][] graph, Set<Integer> safeNodes, Set<Integer> unsafeNodes, Set<Integer> visitedNodes, int currNode) {
        if (graph[currNode].length == 0) {
            visitedNodes.add(currNode);
            return true;
        } else if (visitedNodes.contains(currNode)) {
            visitedNodes.add(currNode);
            return false;
        } else if (safeNodes.contains(currNode)) {
            visitedNodes.add(currNode);
            return true;
        } else if (unsafeNodes.contains(currNode)) {
            visitedNodes.add(currNode);
            return false;
        } else {
            visitedNodes.add(currNode);
            int[] children = graph[currNode];
            for (int i = 0; i < children.length; i++) {
                Set<Integer> visitDuplicate = new HashSet<Integer>(visitedNodes);
                boolean result = isEventuallySafe(graph, safeNodes, unsafeNodes, visitDuplicate, children[i]);
                if (!result) {
                    unsafeNodes.add(currNode);
                    return false;
                }
            }
            safeNodes.add(currNode);
            return true;
        }
    }




    // overall, keep track of the safe and unsafe nodes (two sets is fine)
    // for each node in the graph we need to do a graph traversal
    // for each traversal, we keep track of a fresh set of visited nodes
    // if the node has no children, return true
    // if the node is already visited, return false
    // if the node is marked as a eventual safe node return true
    // if the node is marked as an eventual unsafe node return false
    // otherwise, add the node as visited and recursively go
    // through the children of the node. If all those nodes are safe (and results)
    // then that node is safe

}