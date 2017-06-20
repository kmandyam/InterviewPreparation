public class MaxProductSubarray {
    public static void main(String[] args) {
        int[] arr = {-1, -2, -9, -6};
        System.out.println(maxProduct(arr));
    }

    public static int maxProduct(int[] nums) {
        int global_max = nums[0];

        int curr_max = nums[0];
        int prev_local_max = nums[0];
        int prev_local_min = nums[0];

        for (int i = 1; i < nums.length; i++) {
              curr_max = max(prev_local_max * nums[i], prev_local_min * nums[i]);
              curr_max = max(curr_max, nums[i]);

              int curr_min_prod = min(prev_local_max * nums[i], prev_local_min * nums[i]);
              curr_min_prod = min(curr_min_prod, nums[i]);

              global_max = max(global_max, curr_max);
              prev_local_max = curr_max;
              prev_local_min = curr_min_prod;
        }
      return global_max;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int min(int a, int b) {
      return a < b ? a : b;
    }
}
