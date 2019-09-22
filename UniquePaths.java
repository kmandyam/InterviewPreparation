public class UniquePaths {
    public int uniquePaths(int m, int n) {

        // TODO: swap around the m and the n

        int[][] grid = new int[m][n];

        // m refers to the height and n refers to the width
        // the last row and last column should be all 1s
        for (int i = 0; i < n; i++) {
            grid[m-1][i] = 1;
        }

        for (int i = 0; i < m; i++) {
            grid[i][n-1] = 1;
        }

        for (int j = n - 2; j >= 0; j--) {
            for (int i = m - 2; i >= 0; i--) {
                int localValue = 0;

                // look below, if (i + 1, j) is valid, grab that value and add it
                if (i + 1 < m) {
                    localValue += grid[i+1][j];
                }

                // look to the right, if (i, j + 1) is valid, grab that value and add it
                if (j + 1 < n) {
                    localValue += grid[i][j+1];
                }
                grid[i][j] = localValue;
            }
        }

        return grid[0][0];
    }


    // my initial thoughts are, take one step and see what happens
    // so count the number of paths that would work if you
    // go down one step and count the number of paths that would work if
    // you go right one step
    // once you reach the finish, we count one step
    // if you're out of bounds, it's a zero
}