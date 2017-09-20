public class TreeTraversal {

  public static void main(String[] args) {
    Node left = new Node(1, null, null);
    Node right = new Node(3, null, null);
    Node root = new Node(2, left, right);

    postorder(root);
  }

  private static class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val, Node left, Node right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public static void inorder(Node root) {
    if(root == null) {
      return;
    }else{
      inorder(root.left);
      System.out.println(root.val);
      inorder(root.right);
    }
  }

  public static void preorder(Node root) {
    if(root == null) {
      return;
    }else{
      System.out.println(root.val);
      preorder(root.left);
      preorder(root.right);
    }
  }

  public static void postorder(Node root) {
    if(root == null) {
      return;
    }else{
      postorder(root.left);
      postorder(root.right);
      System.out.println(root.val);
    }
  }



}
