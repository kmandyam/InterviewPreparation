// write a method to return all subsets of a set (power set)

//Strategy: what if we started with the smallest form of subsets.
// subset of one thing is just the empty set and itself
// subset of two things is just subset of each of its one things and itself
// subset of three things is just the subset of each of its one things, and what?
import java.util.*;
public class Subsets {
  //{1} = {} {1}
  //{1, 2} = {} {1} {2} {1, 2}
  //{1, 2, 3} = {} {1} {2} {3} {1, 2} {2, 3} {1, 3} {1, 2, 3}
  //{1, 2, 3, 4} = {} {1} {2} {3} {4} {1, 2} {1, 3} {1, 4} {2, 3} {2, 4} {3, 4} {1, 2, 3} {1, 2, 4} {1, 3, 4} {2, 3, 4} {1, 2, 3, 4}

  // {} {1} {2} {1,2}
  // {3}, {1, 3} {2, 3} {1, 2, 3}

  // {4} {1, 4} {2, 4} {3, 4} {1, 2, 4} {1, 3, 4} {2, 3, 4} {1, 2, 3, 4}
  public static void main(String[] args) {
    int[] arr = {1, 2};
    System.out.println(powerSets(arr));
  }

  public static List<Set<Integer>> powerSets(int[] set) {
    if(set.length == 0) {
      List<Set<Integer>> powerset = new ArrayList<Set<Integer>>();
      Set<Integer> empty = new HashSet<Integer>();
      powerset.add(empty);
      return powerset;
    }else {
      List<Set<Integer>> powerset = new ArrayList<Set<Integer>>();
      int[] splice = new int[set.length - 1];
      for(int i = 1; i < set.length; i++) {
        splice[i-1] = set[i];
      }
      List<Set<Integer>> oldSets = powerSets(splice);
      powerset.addAll(oldSets);
      for(int i = 0; i < oldSets.size(); i++) {
        Set<Integer> newset = new HashSet<Integer>(oldSets.get(i));
        newset.add(set[0]);
        powerset.add(newset);
      }
      return powerset;
    }



  }

}
