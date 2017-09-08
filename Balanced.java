import java.util.*;

public class Balanced {

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
    Node leftleftlef = new Node(-1, null, null);
    Node leftleft = new Node(0, leftleftlef, null);
    Node left = new Node(1, leftleft, null);
    Node right = new Node(3, null, null);
    Node root = new Node(2, left, right);

    System.out.println(isBalanced(root));
  }


  public static boolean isBalanced(Node root) {
    if(root == null) {
      return true;
    }else{
      int leftHeight = height(root.left);
      int rightHeight = height(root.right);

      boolean balanced;
      if(Math.abs(leftHeight - rightHeight) <= 1) {
        balanced = true;
      }else{
        balanced = false;
      }
      return balanced && isBalanced(root.right) && isBalanced(root.left);
    }
  }

  public static int height(Node root) {
    if(root == null) {
      return -1;
    }else{
      return 1 + Math.max(height(root.left), height(root.right));
    }
  }


}
