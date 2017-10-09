/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Diameter {
    public int diameterOfBinaryTree(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();

        if(root == null) {
            return 0;
        }

        int max = 0;
        st.push(root);
        while(!st.empty()) {
            TreeNode curr = st.pop();
            int curMax = maxHeight(curr.left) + maxHeight(curr.right);
            max = Math.max(curMax, max);
            if(curr.left != null) {
                st.push(curr.left);
            }
            if(curr.right != null) {
                st.push(curr.right);
            }
        }
        return max;
    }

    public int maxHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }else{
            return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
        }
    }
}
