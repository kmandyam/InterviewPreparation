// implement an algorithm to print all valid (properly opened and closed) combinations of n pairs of parentheses

// Strategy:
// 1: ()
// 2: ()() (())
// 3: ()()() ((())) (()()) (())() ()(())
import java.util.*;
public class Parens {
  public static void main(String[] args) {
    Set<String> results = collectParens(4);
    for(String s : results) {
      System.out.println(s);
    }
  }

  public static Set<String> collectParens(int n) {
    if(n == 1) {
      Set<String> parens = new HashSet<String>();
      parens.add("()");
      return parens;
    }else {
      Set<String> prev_parens = collectParens(n - 1);
      Set<String> new_parens = new HashSet<String>();
      // new_parens.addAll(prev_parens);

      for(String old : prev_parens) {
        // insert a pair of parentheses everywhere possible
        // insert at the beginning
        String beginning = "()" + old;
        new_parens.add(beginning);
        for(int i = 0; i < old.length(); i++) {
          // insert pair of parentheses after the ith Character
          String left = old.substring(0, i+1);
          String middle = "()";
          String right = old.substring(i+1, old.length());
          new_parens.add(left + middle + right);
        }
      }
      return new_parens;
    }
  }


}
