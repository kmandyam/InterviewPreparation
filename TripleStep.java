import java.util.*;

public class TripleStep {
    public static void main(String[] args) {
        System.out.println(tripleStep(4));
    }

    public static int tripleStep(int n) {
        return tripleStepHelper(n, new int[n + 1]);
    }

    public static int tripleStepHelper(int n, int[] memo) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        } else {
            int total = 0;

            if (n - 1 >= 0) {
                int tsone = memo[n-1] != 0 ? memo[n-1] : tripleStepHelper(n-1, memo);
                memo[n-1] = tsone;
                total += tsone;
            }

            if (n - 2 >= 0) {
                int tstwo = memo[n-2] != 0 ? memo[n-2] : tripleStepHelper(n-2, memo);
                memo[n-2] = tstwo;
                total += tstwo;
            }

            if (n - 3 >= 0) {
                int tsthree = memo[n-3] != 0 ? memo[n-3] : tripleStepHelper(n-3, memo);
                memo[n-3] = tsthree;
                total += tsthree;
            }


            return total;
        }
    }
}

// answering the question Triple Step from CTCI Ch8, Question 1