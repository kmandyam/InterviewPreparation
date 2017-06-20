import java.util.*;

public class ProductOfArrayECSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        // forwards
        int product_at_i = 1;
        output[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            output[i] = product_at_i;
            product_at_i = product_at_i * nums[i];
        }

        // backwards
        product_at_i = nums[nums.length - 1];
        // output[nums.length-1] = output[nums.length - 1] * product_at_i;
        // product_at_i =
        for(int i = nums.length - 2; i >= 0; i--) {
          output[i] = output[i] * product_at_i;
          product_at_i *= nums[i];
        }


        return output;
    }

    public static void main(String[] args) {
      int[] arr = {1, 2, 3, 4};
      System.out.println(Arrays.toString(productExceptSelf(arr)));
    }
}
