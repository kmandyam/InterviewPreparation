// Given the root of a binary tree, each node in the tree has a distinct value.
// After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
// Return the roots of the trees in the remaining forest.  You may return the result in any order.
public class DelNodesForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ret = delNodeHelper(root, to_delete);
        delConnections(root, to_delete);
        return ret;
    }

    // implement a two pass algorithm to solve this
    // first pass returns pointers to nodes
    // second pass ensures that all nodes are deleted in the tree

    public List<TreeNode> delNodeHelper(TreeNode root, int[] to_delete) {
        if (root == null) {
            return new ArrayList<TreeNode>();
        } else {
            List<TreeNode> leftResults = delNodeHelper(root.left, to_delete);
            List<TreeNode> rightResults = delNodeHelper(root.right, to_delete);

            if (toDelete(root.val, to_delete)) {
                List<TreeNode> ret = new ArrayList<TreeNode>();
                ret.addAll(leftResults);
                ret.addAll(rightResults);
                return ret;
            } else {
                if (root.left != null) {
                    if (leftResults.contains(root.left)) {
                        leftResults.remove(root.left);
                    }
                }

                if (root.right != null) {
                    if (rightResults.contains(root.right)) {
                        rightResults.remove(root.right);
                    }
                }

                List<TreeNode> ret = new ArrayList<TreeNode>();
                ret.add(root);
                ret.addAll(leftResults);
                ret.addAll(rightResults);
                return ret;
            }
        }
    }

    public void delConnections(TreeNode root, int[] to_delete) {
        if (root == null) {
            return;
        } else {
            delConnections(root.left, to_delete);
            delConnections(root.right, to_delete);

            if (root.right != null) {
                if (toDelete(root.right.val, to_delete)) {
                    root.right = null;
                }
            }

            if (root.left != null) {
                if (toDelete(root.left.val, to_delete)) {
                    root.left = null;
                }
            }
        }
    }

    public boolean toDelete(int value, int[] to_delete) {
        for (int i = 0; i < to_delete.length; i++) {
            if (to_delete[i] == value) {
                return true;
            }
        }
        return false;
    }
}