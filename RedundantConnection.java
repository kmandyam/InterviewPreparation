public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> tree = new HashMap<Integer, List<Integer>>();

        int[] redundant_edge = new int[2];

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            System.out.println(Arrays.toString(edge));
            if (pathFromNode(edge[0], tree, edge[1], new HashSet<Integer>())) {
                redundant_edge = edge;
            } else {
                // we add the edge into the graph and populate the pathFromRoot
                // set accordingly
                addEdge(edge[0], edge[1], tree);
                addEdge(edge[1], edge[0], tree);
            }

        }

        return redundant_edge;
    }

    public void addEdge(int u, int v, Map<Integer, List<Integer>> tree) {
        if (tree.containsKey(u)) {
            tree.get(u).add(v);
        } else {
            List<Integer> children = new ArrayList<Integer>();
            children.add(v);
            tree.put(u, children);
        }
    }

    public boolean pathFromNode(int currNode, Map<Integer, List<Integer>> tree, int target, Set<Integer> evaluated) {
        if (currNode == target) {
            return true;
        } else {
            // for all of curr node's children in the tree
            if (tree.containsKey(currNode)) {
                evaluated.add(currNode);
                List<Integer> children = tree.get(currNode);
                for (Integer child : children) {
                    if (!evaluated.contains(child)) {
                        boolean result = pathFromNode(child, tree, target, evaluated);
                        if (result) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                // no children
                return false;
            }
        }
    }

    // naive implementation
    // remove an edge, see if the resulting edges form a tree of N nodes
    // prefer removing an edge later in the array

    // a better implementation, would be to construct the tree as we go
    // but once we hit a redundant edge, we ignore it
    // keep going until we find another redundant edge or not

    // what is a redundant edge? An edge (u, v) is redundant if there
    // already exists a path from the root to u and from root to v

    // for the purposes of this, we will always take the root to be 1

    // as we keep adding edges to the tree, we will have to keep track
    // of which edges have a path from the root

    // we will also need to keep track of an adjacency list graph
    // of the current tree situation, this will allow us to handle
    // any ordering of the edges array


}