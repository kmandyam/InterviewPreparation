// Magic index A[i] = i
// Given sorted array of distinct integers, write method to find magic index

//Strategy: go to the middle, kind of like binary search, and see if there is a magic index. If yes, return index, if no,
// if index is less than number, magic index has to be on the left, if index is greater than number, magic index has to be on the right


public class Magic {
  public static void main(String[] args) {
    int[] arr1 = {3, 4, 5 ,6, 9, 20};
    int[] arr2 = {-1, 1, 3, 6, 7};
    int[] arr3 = {-4, -3, -2, 3};
    int[] arr4 = {2, 2, 2, 2, 2, 8, 10, 23, 25};

    System.out.println(findMagic2(arr4, 0, arr4.length));

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

  // values not distinct?
  // gotta search both the left and the right sides
  // left side: search lo to whatever the number is index or the highest possible
  // right side: search the next value or the value itself to the hi

  public static int findMagic2(int[] arr, int lo, int hi) {
    if(hi < lo) {
      return -1;
    }else {
      int mid = lo + ((hi - lo)/2);
      if(arr[mid] == mid) {
        return mid;
      }else{
        int magicLeft = findMagic2(arr, lo, Math.min(mid - 1, arr[mid]));
        int magicRight = findMagic2(arr, Math.max(mid + 1, arr[mid]), hi);

        if(magicLeft != -1) {
          return magicLeft;
        }else{
          if(magicRight != -1) {
            return magicRight;
          }
          return -1;
        }

      }
    }
  }

}
