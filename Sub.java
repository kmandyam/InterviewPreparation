public class Sub {

  public static void main(String[] args) {

  }

  public static Set<Set<Integer>> subsets(Set<Integer> set) {
    // {} = {}
    // {1} = {1}, {}
    // {1, 2} = {} {1} {2} {1, 2}
    // {1, 2, 3} = {} {1} {2} {3} {1, 2} {2, 3} {1, 3} {1, 2, 3}

    if(set.size() == 0) {
      Set<Set<Integer>> output = new HashSet<Set<Integer>>();
      Set<Integer> empty = new HashSet<Integer>();
      output.add(empty);
      System.out.println(empty);
      return output;
    }else{
      
    }
  }

}
