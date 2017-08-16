// Problem: given an arithmetic equation consisting of positive integers, +, -, *, and / (no parentheses, compute the result)

import java.util.*;
public class Arithmetic {

  public static int compute(String input) {
      Queue<Character> operations = new Queue<Character>();
      Queue<String> quantities = new Queue<String>();

      int ans = 0;
      if(input.length() == 0) {
        return ans;
      }


      String partial = "";
      for(int i = 0; i < input.length; i++) {
        char curr = input.charAt(i);
        if(curr == '+' || curr == '-') {
          operations.add(curr);
          quantities.add(partial);
          partial = "";
          continue;
        }else {
          partial += curr;
        }
      }

      while(operations.peek() != null) {
      }


  }









}
