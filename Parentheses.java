import java.util.*;

public class Parentheses {
    public static List<String> generateParenthesis(int n) {
        // let's try a recursive backtracking solution, only have to verify partial solutions so we can catch the problem earlier

    }

    private static void generateHelper(int n, List<String> results, String acc, int num_options) {
      if(n == 0) {
        // we have a complete string, verify that it works
        if(verifyParentheses(acc)) {
          results.add(acc);
        }
      }else{
        //



      }
    }

    private static String[] generateOptions(int n) {
      String[] arr = new String[2*n];
      for(int i = 0; i < n; i++) {
        arr[i] = "(";
      }
      for(int i = n; i < 2*n; i++) {
        arr[i] = ")";
      }

      return 
    }


    private static boolean verifyParentheses(String input) {
      Stack<Character> st = new Stack<Character>();
      for(int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        if(c == '(') {
          st.push('(');
        }else {
          if(st.empty()) {
            return false;
          }
          st.pop();
        }
      }
      if(st.empty()) {
        return true;
      }else {
        return false;
      }
    }

    public static void main (String[] args) {
      System.out.println(verifyParentheses("())"));
    }
}
