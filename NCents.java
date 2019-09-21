public class NCents {
    public static void main(String[] args) {

    }

    public static int ncents(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return ncents(n - 25) + ncents(n - 10) + ncents(n - 5) + ncents(n - 1);
        }
    }


    // Given an infinite number of quarters, dimes, nickels, pennies, write code to calculate
    // the number of ways to represent n cents

    // this can be phrased like DP problem. At any given number of cents, we ask ourselves,
    // what happens when we take out a quarter, dime, nickel, or penny
}