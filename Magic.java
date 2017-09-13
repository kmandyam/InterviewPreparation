// Magic index A[i] = i
// Given sorted array of distinct integers, write method to find magic index

//Strategy: go to the middle, kind of like binary search, and see if there is a magic index. If yes, return index, if no,
// if index is less than number, magic index has to be on the left, if index is greater than number, magic index has to be on the right


public class Magic {
  public static void main(String[] args) {
    int[] arr1 = {3, 4, 5 ,6, 9, 20};
    int[] arr2 = {-1, 1, 3, 6, 7};
    int[] arr3 = {-4, -3, -2, 3};

    System.out.println(findMagic(arr3));
  }


  public static int findMagic(int[] arr) {
    int lo = 0;
    int hi = arr.length;

    while(lo < hi) {
      int mid = lo + ((hi - lo)/2);
      if (arr[mid] == mid) {
        return mid;
      } else if (mid < arr[mid]) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }

    return -1;
  }

}
