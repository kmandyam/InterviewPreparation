public class MaxSubarray {

  public static void main(String[] args) {
    // testing code
    int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxSubarray(arr));
  }


  private static int maxSubarray(int[] arr) {
    int max_subarray = arr[0];
    int local_max_subarray_i = arr[0];

    for(int i = 1; i < arr.length; i++) {
      local_max_subarray_i = local_max(arr[i], local_max_subarray_i + arr[i]); // found the local max_subarray ending at i
      max_subarray = local_max(local_max_subarray_i, max_subarray);
    }
    return max_subarray;
  }

  private static int local_max(int a, int b) {
    return a > b ? a : b;
  }

}
