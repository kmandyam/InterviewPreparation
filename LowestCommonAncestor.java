public class LowestCommonAncestor {

  public static void main(String[] args) {

  }

  private class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val, Node left, Node right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public Node lca(Node root, Node p, Node q) {
    if(root == null) {
      return null;
    }else if(root.val == p.val) {
      return p;
    }else if(root.val == q.val) {
      return q;
    }else{
      boolean pOnLeft = inSubtree(root.left, p);
      boolean qOnLeft = inSubtree(root.left, q);

      // if they're different values, then we have our answer, otherwise, traverse down the right path
      boolean xor = pOnLeft ^ qOnLeft;
      if(xor) {
        return root;
      }else{
        if(pOnLeft && qOnLeft) {
          return lca(root.left, p, q);
        }else{
          return lca(root.right, p, q);
        }
      }
    }
  }

  public boolean inSubtree(Node tree, Node test) {
    if(tree == null) {
      return false;
    }else{
      if(tree.val == test.val) {
        return true;
      }else{
        return inSubtree(tree.left, test) || inSubtree(tree.right, test);
      }
    }
  }



}
