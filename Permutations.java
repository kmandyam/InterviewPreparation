// Task: write a method to compute all permutations of a string of unique characters
import java.util.*;
public class Permutations {
  public static void main(String[] args) {
    System.out.println(permutations("kayrish"));
  }


  public static List<String> permutations(String word) {
    Set<Character> chars = new HashSet<Character>();
    for(int i = 0; i < word.length(); i++) {
      chars.add(word.charAt(i));
    }

    List<String> answers = new ArrayList<String>();
    perms(chars, "", answers);
    return answers;
  }

  public static void perms(Set<Character> chars, String acc, List<String> ans) {
    if(chars.size() == 0) {
      ans.add(acc);
      return;
    }else{
      for(char c : chars) {
        acc += c;
        Set<Character> newChars = new HashSet<Character>(chars);
        newChars.remove(c);
        perms(newChars, acc, ans);
        acc = acc.substring(0, acc.length() - 1);
      }
    }
  }





}
