// Given a binary tree, return linked list of all the nodes at each depth
import java.util.*;
public class Route {
  // calculate the greatest depth once
  // create an array of LinkedLists to represent the D linked lists
  // recurse all the way down like in any binary tree traversal and increment the depths as I go, adding the values to each linkedlist
  public static void main(String[] args) {
    Node left = new Node(1, null, null);
    Node right = new Node(3, null, null);
    Node root = new Node(2, left, right);
    System.out.println(getDepth(root));
    int[] h = {1, 2, 3, 4};
    // System.out.println(Arrays.toString(h));
    // pass(h);
    // System.out.println(Arrays.toString(h));
    System.out.println(returnDepthList(root));
  }

  public static LinkedList[] returnDepthList(Node root) {
    // grab the total depth
    int depth = getDepth(root);
    LinkedList[] arrs = new LinkedList[depth];
    bfs(root, arrs, 0);
    return arrs;
  }


  public static void bfs(Node curr, LinkedList[] arrs, int depth) {
    if(curr == null) {
      return;
    } else {
      arrs[depth].add(curr);
      bfs(curr.left, arrs, depth + 1);
      bfs(curr.right, arrs, depth + 1);
    }
  }

  public static int getDepth(Node root) {
    if(root == null) {
      return 0;
    }else{
      return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
  }


  private static class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

}
