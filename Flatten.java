public class Flatten {
  private class Node {
    public int value;
    public Node next;
    public Node child;

    public Node(int value, next, child) {
      this.value = value;
      this.next = next;
      this.child = child;
    }

  }

  public Node flatten(Node head) {
    if(head == null) {
        return null;
    }

    Node curr = head;

    Node tail = head;
    while(tail != null) {
      tail = tail.next;
    }

    while(curr != tail) {
      if(curr.child != null) {
        tail.next = curr.child;

        Node temp = curr.child;
        while(temp != null) {
          temp = temp.next;
        }
        tail = temp;
      }
      curr = curr.next;
    }

    return head;
  }



}
