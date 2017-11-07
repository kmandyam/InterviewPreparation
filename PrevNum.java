public class PrevNum {

  public static void main(String[] args) {
    permutations("cat", "");
  }


  public static void permutations(String s, String acc) {
    if(s.length() == 0) {
      System.out.println(acc);
    }else{
      for(int i = 0; i < s.length(); i++) {
        acc += s.charAt(i);
        permutations(s.substring(0, i) + s.substring(i+1, s.length()), acc);
        acc = acc.substring(0, acc.length() - 1);
      }
    }
  }


}
