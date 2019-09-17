import java.util.*;

public class Quicksort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, -9};
        quicksort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quicksort(int[] arr) {
        quicksortHelper(arr, 0, arr.length - 1);
    }

    public static void quicksortHelper(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        } else {
            // choose pivot to be the median of the lo, hi and middle of array value
            int pi = returnPivotIndex(arr, lo, hi);
            swap(arr, pi, hi); // move the pivot to the end of the array so it's out of the way

            int boundary = lo - 1;
            for (int j = lo; j < hi; j++) {
                // if the current value is less than the pivot
                if (arr[j] < arr[hi]) {
                    // push up the boundary
                    boundary += 1;
                    // swap boundary with the current value
                    swap(arr, boundary, j);
                }
            }

            // swap the pivot back into the right location
            swap(arr, hi, boundary + 1);
            quicksortHelper(arr, lo, boundary);
            quicksortHelper(arr, boundary + 2, hi);
        }
    }

    public static int returnPivotIndex(int[] arr, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (arr[lo] > arr[hi]) {
            if (arr[mid] > arr[hi]) {
                if (arr[lo] > arr[mid]) {
                    return mid;
                } else {
                    return lo;
                }
            } else {
                return hi;
            }
        } else {
            if (arr[mid] > arr[lo]) {
                if (arr[mid] > arr[hi]) {
                    return hi;
                } else {
                    return mid;
                }
            } else {
                return lo;
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

// the goal of this problem is to implement a sorting algorithm called quicksort
// quicksort is a recursive algorithm which chooses a "pivot" and swaps items
// greater than the pivot to the right in the array and less than the pivot
// to the left in the array. Once the items are on the correct side of the array
// we recursively sort the left and the right side
// in the base case, we only have zero or one elements in the array, which is
// considered sorted.


// implementation: we need a lo and a high pointer, let's keep things all inclusive here
// we need to choose a pivot, take the median of the low middle and high indices
// [9, 6, 2, 11, 8, 12, 1]

// swap pivot to the end of the array
// [1, 6, 2, 11, 8, 12, 9]
// [1, 6, 2, 8, 11, 12, 9]
// [1, 6, 2, 8, 9, 12, 11]

// if i recall correctly, you start by choosing a pivot, swapping it into the center
// and then doing the lo high thing, where you swap when you encounter a mismatch
