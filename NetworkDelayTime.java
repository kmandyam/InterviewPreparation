public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<Integer, Map<Integer, Integer>>();
        for (int i = 1; i <= N; i++) {
            Map<Integer, Integer> edges = new HashMap<Integer, Integer>();
            graph.put(i, edges);
        }

        // assuming that there are no duplicate edges to nodes here
        // assuming that there are no cycles in the graph
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            Map<Integer, Integer> edgeMap = graph.get(u);
            edgeMap.put(v, w);
        }

        Map<Integer, Integer> nodeTimeMap = new HashMap<Integer, Integer>();

        traverse(graph, K, 0, nodeTimeMap);
        if (nodeTimeMap.keySet().size() != N) {
            return -1;
        }

        int max = 0;
        for (int node : nodeTimeMap.keySet()) {
            max = Math.max(max, nodeTimeMap.get(node));
        }

        return max;
    }

    public void traverse(Map<Integer, Map<Integer, Integer>> graph, int currNode, int totalTime, Map<Integer, Integer> nodeTimeMap) {
        if (nodeTimeMap.containsKey(currNode)) {
            int currTime = nodeTimeMap.get(currNode);
            nodeTimeMap.put(currNode, Math.min(currTime, totalTime));
        } else {
            nodeTimeMap.put(currNode, totalTime);
        }

        Map<Integer, Integer> edges = graph.get(currNode);

        for (int target : edges.keySet()) {
            int weight = edges.get(target);
            if (nodeTimeMap.containsKey(target)) {
                if (nodeTimeMap.get(target) > totalTime + weight) {
                    traverse(graph, target, totalTime + weight, nodeTimeMap);
                }
            } else {
                traverse(graph, target, totalTime + weight, nodeTimeMap);
            }
        }
    }

    // construct the graph
    // a map from integer (node) to a map from edge to weight
    // add all integers 1 to N to the outer map and add in an empty inner map
    // for every edge we see in the times thing, we add in the appropriate entry to the correct inner map

    // recursive function should take a couple of arguments
    // the graph, the current node, the total time elapsed, and the node time map
    // take a look at the starting node
    // evaluate the starting node. If the node is in the node time map, then we see if the current time is shorter, replace
    // look at all the children of the node
    // recurse on the children, but add in the edge weight time to the total time elapsed in each recursive call
    // use the same hashmap that you pass in, the idea is that it gets mutated
    // the function should be a void function

    // once we're done with the calls, we evaluate the resulting node time map
    // if there are N entries in the keyset, find the largest one and return it
    // if there are less than N entries, return -1
}