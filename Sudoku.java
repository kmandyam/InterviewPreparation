import java.util.*;

public class Sudoku {
  public static void main(String[] args) {
    // enter a valid board (note that squares not filled in have the number -1 in them)
    // int[] arr1 = {-1, 1, 3, 9, 6, 7, -1, -1, -1};
    int[][] arr = {{5, 3, -1, -1, 7, -1, -1, -1, -1},
                   {6, -1, -1, 1, 9, 5, -1, -1, -1},
                   {-1, 9, 8, -1, -1, -1, -1, 6, -1},
                   {8, -1, -1, -1, 6, -1, -1, -1, 3},
                   {4, -1, -1, 8, -1, 3, -1, -1, 1},
                   {7, -1, -1, -1, 2, -1, -1, -1, 6},
                   {-1, 6, -1, -1, -1, -1, 2, 8, -1},
                   {-1, -1, -1, 4, 1, 9, -1, -1, 5},
                   {-1, -1, -1, -1, 8, -1, -1, 7, 9}};
    System.out.println(verify(arr));

  }


  public static boolean verify(int[][] board) {

    //
    return validateRows(board) && validateColumns(board) && validateSquares(board);
  }

  public static boolean validateRows(int[][] board) {
    for(int i = 0; i < 9; i ++) {
      int[] row = board[i];

      Set<Integer> set = new HashSet<Integer>();
      for(int j = 1; j <= 9; j++) {
        set.add(j);
      }

      for(int j = 0; j < row.length; j++) {
        if(row[j] == -1) {
          //ignore
        }else{
          if(set.contains(row[j])) {
            set.remove(row[j]);
          }else{
            return false;
          }
        }
      }


    }
    return true;
  }

  public static boolean validateColumns(int[][] board) {
    for(int i = 0; i < 9; i++) {
      // the i'th thing in every row
      Set<Integer> set = new HashSet<Integer>();
      for(int j = 1; j <= 9; j++) {
        set.add(j);
      }

      for(int j = 0; j < 9; j++) {
        int[] row = board[j];

        int num = row[i];
        if(num == -1) {
          //ignore
        }else{
          if(set.contains(num)) {
            set.remove(num);
          }else{
            return false;
          }
        }


      }
    }
    return true;
  }

  public static boolean validateSquares(int[][] board) {
    // top left square


    return validateSquare(board, 0, 0) &&
    validateSquare(board, 0, 3) &&
    validateSquare(board, 0, 6) &&
    validateSquare(board, 3, 0) &&
    validateSquare(board, 3, 3) &&
    validateSquare(board, 3, 6) &&
    validateSquare(board, 6, 0) &&
    validateSquare(board, 6, 3) &&
    validateSquare(board, 6, 6);
  }


  public static boolean validateSquare(int[][] board, int i, int j) {

    Set<Integer> set = new HashSet<Integer>();
    for(int z = 1; z <= 9; z++) {
      set.add(z);
    }

    for(int k = i; k < i+3; k++) {
      for(int x = j; x < j+3; x++) {

        int num = board[k][x];
        // System.out.println(num + " NUM");
        if(num == -1) {
          //ignore
        }else{
          if(set.contains(num)) {
            set.remove(num);
          }else{
            // System.out.println(num);
            return false;
          }
        }
      }
    }
    return true;
  }

}
