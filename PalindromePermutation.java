import java.util.*;
public class PalindromePermutation {

  public static boolean isPalindromePermutation(String str) {
    // sanity checks
    if(str.length() == 0 || str.length() == 1) {
      return true;
    }
    // remove the spaces and make all letters lowercase
    String temp = str.trim();
    temp = temp.replaceAll("\\s", "");
    temp = temp.toLowerCase();

    // hash table from letters to numbers (counts)
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    for(int i = 0; i < temp.length(); i++) {
      char c = temp.charAt(i);
      if(map.containsKey(c)) {
        int oldVal = map.get(c);
        map.put(c, oldVal + 1);
      }else{
        map.put(c, 1);
      }
    }

    if(temp.length() % 2 == 0) {
      // even number of letters case

        // every letter needs to have a pair in order for the word to form a palindrome
        // check whether each mapping is a letter to an even number mapping (then we're good)

      boolean allEven = true;
      for(char c : map.keySet()) {
        int val = map.get(c);
        if(val % 2 != 0) {
          allEven = false;
        }
      }
      return allEven;
    }else {
      // odd number of letters case

        // every letter except one needs to have a pair
        // check whether each mapping is a letter to an even number mapping and there is exactly
        // one letter with an odd number mapping (then we're good)
      int oddCount = 0;
      for(char c : map.keySet()) {
        int val = map.get(c);
        if(val % 2 != 0) {
          oddCount++;
        }
      }
      return oddCount > 1 ? false : true;
    }
  }

  public static void main(String[] args) {
    String str = "Tact Coao";
    System.out.println(isPalindromePermutation(str));
  }
}
