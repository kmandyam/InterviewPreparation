public class Palindrome {
  public static boolean isPalindrome(Node head) {
      // handling some edge/base cases
      if(head == null) {
        return true;
      }else if(head.next == null) {
        return true;
      }

      // Iterate through the whole linked list and grab the middle point
      int length = 0;
      Node temp = head;
      while(temp != null) {
        length++;
        temp = temp.next;
      }

      int mid = length / 2; // java integer division rounds down!!
      boolean skipMiddle = length % 2 == 0 ? false : true; // fancy ternary

      // Reverse the first half of the linked list
      Node first_half = head;
      Node second_half = head;
      for(int i = 0; i < mid - 1; i++) {
        second_half = second_half.next;
      }

      // Splice the lists (second_half has the extra node if needed)
      temp = second_half.next;
      second_half.next = null;
      second_half = temp;

      // Second_half now points to the middle of the list (including the middle element if its there)
      Node first_reverse = reverse(first_half);

      // Iterate over the two linked lists until to figure out if we have a Palindrome
      Node first_iterator = first_reverse;
      Node second_iterator = second_half;

      if(skipMiddle) {
        second_iterator = second_iterator.next;
      }

      boolean isPalindrome = true;
      for(int i = 0; i < mid; i++) {
        if(first_iterator.data != second_iterator.data) {
          isPalindrome = false;
          break;
        }
        first_iterator = first_iterator.next;
        second_iterator = second_iterator.next;
      }

      // Restore the linked list to its original state
      Node og_first = reverse(first_reverse);
      Node splice = og_first;
      while(splice.next != null) {
        splice = splice.next;
      }
      splice.next = second_half;
      head = og_first;

      return isPalindrome;
  }

  private static Node reverse(Node head) {
    Node reversed = null;
    if(head == null) {
      return null;
    }else if(head.next == null) {
      return head;
    }

    // the list is longer than one node
    Node temp = head;
    while(temp != null) {
      Node next = temp.next;
      temp.next = reversed;
      reversed = temp;
      temp = next;
    }
    return reversed;
  }

  private static class Node {
    public int data;
    public Node next;
    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  public static void main(String[] args) {
    Node head = new Node(1, null);
    head.next = new Node(2, null);
    head.next.next = new Node(5, null);
    head.next.next.next = new Node(2, null);
    head.next.next.next.next = new Node(1, null);

    System.out.println(isPalindrome(head));

    // sanity check to make sure linked list is preserved
    Node temp = head;
    while(temp != null) {
      System.out.println(temp.data);
      temp = temp.next;
    }
  }

}
