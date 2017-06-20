public class Median {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return findMedianOfSingleArray(nums2, 0, nums2.length - 1);
        }else if (nums2.length == 0) {
            return findMedianOfSingleArray(nums1, 0, nums1.length - 1);
        }
        return findMedianOfArrayRanges(0, nums1.length - 1, 0, nums2.length - 1, nums1, nums2);  
    }
    
    private double findMedianOfSingleArray(int[] arr, int lo, int hi) {
        int median_elt = (hi - lo + 1) / 2; // returns the java division which is rounded down
        if(((hi - lo + 1) % 2) == 0){
	    // we have an even number of elements, average median_elt with the higher one
	    double num = arr[median_elt] + arr[median_elt - 1];
	    num = num / 2;
	    return num;
        }else{
            return arr[median_elt];
        }
    }
    
    
    private double findMedianOfArrayRanges(int nums1_lo, int nums1_hi, int nums2_lo, int nums2_hi, int[] nums1, int[] nums2) {
        double m1 = findMedianOfSingleArray(nums1, nums1_lo, nums1_hi);
        double m2 = findMedianOfSingleArray(nums2, nums2_lo, nums2_hi);
        
        int mp_1 = (nums1_hi - nums1_lo) / 2;
        int mp_2 = (nums2_hi - nums2_lo) / 2;
        
        if (m1 == m2) {
            return m1;
        }else if((nums1_hi - nums1_lo) <= 1 && (nums2_hi - nums2_lo) <= 1) {
            // calculate the median of the two to four numbers
            int median = max(nums1[nums1_lo], nums2[nums2_lo]) + min(nums1[nums1_hi], nums2[nums2_hi]);
            return ((double)median) / 2;
        }else if (m1 > m2) {
            return findMedianOfArrayRanges(nums1_lo, mp_1, mp_2, nums2_hi, nums1, nums2);
        }else if (m2 > m1){
            return findMedianOfArrayRanges(mp_1, nums1_hi, nums2_lo, mp_2, nums1, nums2);
        }else {
            return 0.0;
        }
    }
    
    private int max(int a, int b) {
        return a > b ? a : b;
    }
    
    private int min(int a, int b) {
        return a < b ? a : b;
    }
}