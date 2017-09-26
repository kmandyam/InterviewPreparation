import java.util.*;
public class MaxSubarray {

  public static void main(String[] args) {
    // testing code
    int[] arr = {1, -3, 2, 1, -1};
    System.out.println(maxSubarray(arr));
  }


  // private static int maxSubarray(int[] arr) {
  //   int max_subarray = arr[0];
  //   int local_max_subarray_i = arr[0];
  //
  //   for(int i = 1; i < arr.length; i++) {
  //     local_max_subarray_i = local_max(arr[i], local_max_subarray_i + arr[i]); // found the local max_subarray ending at i
  //     max_subarray = local_max(local_max_subarray_i, max_subarray);
  //   }
  //   return max_subarray;
  // }
  //
  // private static int local_max(int a, int b) {
  //   return a > b ? a : b;
  // }

  private static int maxSubarray(int[] arr) {
    int total_max = arr[0];
    int local_max = arr[0];

    for(int i = 1; i < arr.length; i++) {
      // maximum subarray ending at index i is either the local max from previous array + me or just me
      local_max = Math.max(local_max + arr[i], arr[i]);
      total_max = Math.max(total_max, local_max);
    }
    return total_max;
  }
}
