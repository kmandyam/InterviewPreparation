public class BinarySearchRedo {
  public static void main(String[] args) {
      int[] arr = {2, 3, 17, 4345, 76754, 123456, 765432};
      System.out.println(bsearchrec(arr, 2));
      System.out.println(bsearchrec(arr, 3));
      System.out.println(bsearchrec(arr, 17));
      System.out.println(bsearchrec(arr, 4345));
      System.out.println(bsearchrec(arr, 76754));
      System.out.println(bsearchrec(arr, 123456));
      System.out.println(bsearchrec(arr, 765432));

  }

  public static int bsearchiterative(int[] arr, int elt) {
    int lo = 0;
    int hi = arr.length - 1;

    while(lo <= hi) {
      int mid = lo + (hi - lo)/2;
      if(arr[mid] == elt) {
        return mid;
      }else if(arr[mid] < elt) {
        lo = mid + 1;
      }else{
        hi = mid - 1;
      }
    }
    return -1;
  }

  public static int bsearchrec(int[] arr, int elt) {
    return rec(arr, elt, 0, arr.length - 1);
  }

  public static int rec(int[] arr, int elt, int lo, int hi) {
    if(lo == hi) {
      return elt == arr[lo] ? lo : -1;
    }else{
      int mid = lo + (hi - lo) /2;
      if(arr[mid] == elt) {
        return mid;
      }else if(arr[mid] < elt) {
        return rec(arr, elt, mid + 1, hi);
      }else{
        return rec(arr, elt, lo, mid - 1);
      }
    }
  }


}
