public class Ancestor {
  private static class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }

    public String toString() {
      return "" + data;
    }
  }



  public static void main(String[] args) {

  }

  public static Node findCommonAncestor(Node root, Node a, Node b) {
    if(root == null) {
      return null;
    }

    if(root.data == a.data || root.data == b.data) {
      return root; // we hit one of the nodes so we immediately return (this has to be the first one we hit)
    }

    boolean aIsOnRight = isInTree(root.right, a);
    boolean bIsOnRight = isInTree(root.right, b);
    // if they're different, we've found the common ancestor
    // if they're the same side, then we advance down that side and repeat the whole process again


  }

  public static boolean isInTree(Node root, Node test) {
    if(root == null) {
      return false;
    }else{
      if(root.data == test.data){
        return true;
      }else{
        return isInTree(root.left, test) || isInTree(root.right, test);
      }
    }
  }


}
