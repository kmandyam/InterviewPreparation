// problem: given random doubles of raindrops (each of them are 0.1 meter in length), and they fall at completely random intervals (that's the random part)
// on a 1 meter sidewalk, tell us when the sidewalk gets wet.


// Intuitively, I would solve this problem by keeping track of all the wet and dry parts (or just keeping track of the wet parts)
// droplet drops, several things could happen
// it falls into a current range, then we do nothing
// it creates a new range (then we add it to the list of ranges we keep)
// it sits on the border of a range (then we expand the range)
// we should keep a sorted list of ranges? or we could keep a set of ranges sorted by the first thing in the range

// return the number of raindrops until wet


// list of ranges that we cycle through every single time
import java.util.*;
public class Google {

  public static void main(String[] args) {

  }

  private class Range {
    public double beg;
    public double end;

    public Range(double beg, double end) {
      this.beg = beg;
      this.end = end;
    }

    public void update(double beg, double end) {
      this.beg = beg;
      this.end = end;
    }

    public boolean inDirectRange(double start, double finish) {
      return start > beg && finish < end;
    }

    public boolean inPartial(double start, double finish) {
      return start < beg && finish < end || start > beg && finish > end || start < beg && finish > end;
    }
  }


  public static int raindrops() {
    Set<Range> rangeSet = new HashSet<Range>();
    int rain = 0;

    while(!containsFinalRange(rangeSet)) {
      // grab a new raindrop

      // categorize it appropriately
      // sort if added a new range
      // merge ranges
    }

  }

  public static boolean containsFinalRange(Set<Range> rangeSet) {
    if(rangeSet.size() == 1) {
      for(Range r : rangeSet) {
        return r.beg == 0.0 && r.end == 1.0;
      }
    }
    return false;
  }




}
