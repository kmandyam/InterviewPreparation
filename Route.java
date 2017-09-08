// Given a binary tree, return linked list of all the nodes at each depth
import java.util.*;
public class Route {
  // calculate the greatest depth once
  // create an array of LinkedLists to represent the D linked lists
  // recurse all the way down like in any binary tree traversal and increment the depths as I go, adding the values to each linkedlist
  public static void main(String[] args) {
    Node hey = new Node(0, null, null);
    Node left = new Node(1, hey, null);
    Node right = new Node(3, null, null);
    Node root = new Node(2, left, right);
    LinkedList[] arrs = returnDepthList(root);
    for(int i = 0; i < arrs.length; i++) {
      System.out.println(Arrays.toString(arrs[i].toArray()));
    }
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
      if(arrs[depth] == null) {
        arrs[depth] = new LinkedList();
      }
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

    public String toString() {
      return "" + data;
    }
  }

}
