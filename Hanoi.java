// In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes which can slide onto any tower.
// the puzzle starts with disks sorted in ascending order of size from top to bottom.
// One disk moved at a time
// Slid off the top of one tower onto the next tower
// Disk only placed on top of a larger disk


import java.util.*;

public class Hanoi {
  public static void main(String[] args) {
    int n = 3;
    Towers t = new Towers(n);
    t.moveBuffs(n, t.source, t.buffer, t.destination);
  }

  private static class Towers {
    public Stack<Integer> source;
    public Stack<Integer> buffer;
    public Stack<Integer> destination;
    public int n;

    public Towers(int n) {
      this.n = n;
      this.source = new Stack<Integer>();
      this.buffer = new Stack<Integer>();
      this.destination = new Stack<Integer>();
      for(int i = n; i > 0; i--) {
        source.push(i);
      }
    }

    public void moveBuffs(int n, Stack<Integer> source, Stack<Integer> buffer, Stack<Integer> destination) {
      if(n <= 0) {
        // do nothing
        return;
      }else if(n == 1) {
        int val = source.pop();
        destination.push(val);
        return;
      }else if(n == 2) {
        int one = source.pop();
        buffer.push(one);
        int two = source.pop();
        destination.push(two);
        destination.push(buffer.pop());
      } else {
        moveBuffs(n - 1, source, destination, buffer);
        int top = source.pop();
        destination.push(top);
        moveBuffs(n - 1, buffer, source, destination);
        return;
      }
    }

  }
}
