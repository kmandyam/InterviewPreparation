// Returns the successor node to the current one

import java.util.*;

public class NextNode {
  private static class Node {
    public int data;
    public Node left;
    public Node right;
    public Node parent;

    public Node(int data, Node left, Node right, Node parent) {
      this.data = data;
      this.left = left;
      this.right = right;
      this.parent = parent;
    }

    public String toString() {
      return "" + this.data;
    }

  }

  public Node successor(Node curr) {
    // case 1: left child and null right child (have to go to the parent)
    // case 2: left child and not null right child (go right once and go left all the way down)
    // case 3: right child and not null right child (go right once and go left all the way down)
    // case 4: right child and null right child (go up until I reach right child that is no longer the same as previous and then find the left most child of that)

    if(curr == null) {
      return null;
    }

    if(curr.parent == null) {
      // I'm at the root of the tree, go right once and then go all the way down left
      if(curr.right == null) {
        return curr;
      }else{
        return leftAllTheWay(curr.right);
      }
    }

    // case 1 and 2: left child with a null or not null right child
    if(curr.parent.left == curr) {
      if(curr.right == null) {
        return curr.parent;
      }else {
        return leftAllTheWay(curr.right);
      }
    }else {
      // we are the right child
      if(curr.right != null) {
        return leftAllTheWay(curr.right);
      }else{
        // go up until I reach a right child that is no longer the same as previous and take that root node
        Node temp = curr;
        curr = curr.parent;

        while(curr.right != temp) {
          temp = curr;
          curr = curr.parent;
        }
        return curr;
      }
    }


  }

  public Node leftAllTheWay(Node curr) {
    while(curr != null) {
      curr = curr.left;
    }
    return curr;
  }




}
