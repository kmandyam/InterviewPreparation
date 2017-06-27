import java.util.*;
public class LoopDetection {
  // define our node class
  private static class Node {
    public int data;
    public Node next;

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  // implementing Floyd's Tortoise and Hare method
  private static Node hasLoop(Node head) {
    Node slow;
    Node fast;
    slow = head;
    fast = head;

    // some sort of loop, a forever loop!
    while (true) {
      if(slow == null) {
        // no loop, we've reached the end of the list
        return null;
      }
      slow = slow.next; // move the slower node by 1
      if(fast.next != null) {
        fast = fast.next.next; // move the faster node by 2
      }else{
        // fast.next will be null so we will have reached the end of the loop
        return null;
      }
      if(slow == null || fast == null) {
        // there was no loop and someone has reached the end
        return null;
      }
      if(slow == fast) {
        return slow; // they have somehow met in the middle
      }
    }
  }

  public static Node returnLoopStart(Node head) {
    Node loop = hasLoop(head);
    if(loop == null) {
      // there was no loop
      return null;
    }else{
      // there is a loop and now we have the collision point
      Node temp = head;
      while(temp != loop) {
        temp = temp.next;
        loop = loop.next;
      }
      return temp;
    }
  }

  // TESTING CODE
  public static void main(String[] args) {
    // create a sample linked list
    Node head = new Node(1, null);
    head.next = new Node(2, null);
    head.next.next = new Node(3, null);
    head.next.next.next = new Node(4, null);
    head.next.next.next.next = head.next;

    // 1 -> 2 -> 3 -> 4 -> 2
    System.out.println(returnLoopStart(head).data);
  }
}
