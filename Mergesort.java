import java.util.*;

public class Mergesort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 6};
        System.out.println(Arrays.toString(mergesort(arr)));
    }

    public static int[] mergesort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        } else {
            // split array by half
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);

            int[] leftSort = mergesort(left);
            int[] rightSort = mergesort(right);

            int i = 0;
            int j = 0;

            int k = 0;
            while(i < leftSort.length || j < rightSort.length) {
                int left_val = Integer.MAX_VALUE;
                int right_val = Integer.MAX_VALUE;

                if (i < leftSort.length) {
                    left_val = leftSort[i];
                }

                if (j < rightSort.length) {
                    right_val = rightSort[j];
                }

                if (left_val < right_val) {
                    arr[k] = left_val;
                    i++;
                    k++;
                } else {
                    arr[k] = right_val;
                    j++;
                    k++;
                }

            }
            return arr;
        }
    }


    // the main idea for mergesort is that we split the array down into
    // pieces of size 1
    // then we work our way back up, merging the two pieces together
    // this is a recursive algorithm, we split the pieces down recursively, and then merge
    // upwards recursively
    // the merging algorithm involves using two pointers and traversing the
    // two individually sorted arrays to get one large sorted array
    // we can make a copy of the array to make this work
}