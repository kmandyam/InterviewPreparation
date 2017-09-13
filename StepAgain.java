public class StepAgain {
  public static void main(String[] args) {
    System.out.println(steps(5));
  }


  public static int steps(int n) {
    return stepsHelper(n, new int[n+1]);
  }

  public static int stepsHelper(int n, int[] memo) {
    if(n == 1) {
      return 1;
    }else if(n == 2) {
      return 2;
    }else if(n == 3) {
      return 4;
    }else{
      if(memo[n] == 0) {
        memo[n] = stepsHelper(n - 1, memo) + stepsHelper(n - 2, memo) + stepsHelper(n - 3, memo);
      }
      return memo[n];
    }
  }



}
