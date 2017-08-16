public class Step {
  public static void main(String[] args) {
    System.out.println(steps(200));
  }

  private static long countSteps(int n, long[] memo) {
    if(n <= 0) {
      return 0;
    } else if(n == 1) {
      return 1;
    } else if(n == 2) {
      return 2;
    } else if (n == 3) {
      return 4;
    } else {
      if(memo[n] == 0) {
        memo[n] = countSteps(n-1, memo) + countSteps(n-2, memo) + countSteps(n-3, memo);
      }
      return memo[n];
    }
  }

  public static long steps(int n) {
    long[] memo = new long[n+1];
    return countSteps(n, memo);
  }
}
