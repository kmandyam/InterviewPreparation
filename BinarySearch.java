
public class BinarySearch {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 9};
    int elt = 6;
    System.out.println(binarySearchRecursively(arr, elt));
  }

  public static int binarySearchIteratively(int[] arr, int elt) {
    int lo = 0;
    int hi = arr.length;

    while(lo <= hi) {
      int mid = lo + ((hi - lo) / 2);
      // int midVal = arr[mid];
      if(arr[mid] == elt) {
        return mid;
      }else if(elt < arr[mid]) {
        hi = mid;
      }else {
        lo = mid + 1;
      }
    }
    return -1;
  }

  public static int binarySearchRecursively(int[] arr, int elt) {
    return recHelper(arr, elt, 0, arr.length);
  }

  public static int recHelper(int[] arr, int elt, int lo, int hi) {
    if(hi - lo == 0) {
      return arr[lo] == elt ? lo : -1;
    } else {
      int mid = lo + (hi - lo)/2;
      if(arr[mid] == elt) {
        return mid;
      }else if(elt < arr[mid]) {
        return recHelper(arr, elt, lo, mid);
      } else{
        return recHelper(arr, elt, mid + 1, hi);
      }
    }
  }
}
