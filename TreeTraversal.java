import java.util.*;
public class TreeTraversal {

  public static void main(String[] args) {
    Node l = new Node(3, null, null);
    Node r = new Node(6, null, null);
    Node left = new Node(1, l, r);
    Node asd = new Node(12, null, null);
    Node right = new Node(3, asd, null);
    Node root = new Node(2, left, right);

    iterativeTreeTraversal(root);
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

  public static void iterativeTreeTraversal(Node root) {
    Stack<Node> st = new Stack<Node>();
    st.push(root);

    while(!st.empty()) {
      Node curr = st.pop();
      System.out.println(curr.val);
      if(curr.left != null) {
        st.push(curr.left);
      }
      if(curr.right != null) {
        st.push(curr.right);
      }
    }
  }



}
