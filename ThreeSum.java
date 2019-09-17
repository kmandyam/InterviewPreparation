class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort the array for some pre-processing
        Arrays.sort(nums);

        Set<List<Integer>> triplets = new HashSet<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            // we choose the number at index i to pinpoint
            int a = nums[i];
            int deficit = 0 - a;

            // initialize our two pointers such that they're at either end of the
            // array and that they're not i
            int b = i == 0 ? 1 : 0;
            int c = i == nums.length - 1 ? nums.length - 2 : nums.length - 1;

            while (b < c) {
                // check if b and c add up to the deficit
                if (nums[b] + nums[c] == deficit) {
                    // add it to the list
                    List<Integer> triplet = new ArrayList<Integer>();

                    triplet.add(a);
                    triplet.add(nums[b]);
                    triplet.add(nums[c]);

                    Collections.sort(triplet);
                    if (!triplets.contains(triplet)) {
                        triplets.add(triplet);
                    }


                    // move pointer up and down
                    c -= 1;
                    if (c == i) {
                        c -= 1;
                    }

                    b += 1;
                    if (b == i) {
                        b += 1;
                    }
                } else if (nums[b] + nums[c] > deficit) {
                    // if it's too large, bring top pointer down
                    c -= 1;
                    if (c == i) {
                        c -= 1;
                    }
                } else {
                    // if it's too small, bring bottom pointer up
                    b += 1;
                    if (b == i) {
                        b += 1;
                    }
                }
            }
        }

        List<List<Integer>> last = new ArrayList<List<Integer>>(triplets);
        return last;
    }
}

// initial thoughts

// we're looking for three distinct elements which sum up to 0
// why don't we fix one element and look for two others which sum up to the deficit?
// most naively, we fix one element, for loop twice through the other elements
// and look for ones which have a certain sum


// this is not as efficient, because this would be an O(n3) runtime.

// sorting this array would allow us to take advantage of binary search, though
// we start out by sorting this array
// then we can pinpoint one element like before, pinpoint another element and
// search for the last one. This solution would run in O(n2logn + nlogn) time.

// I think we can still do better
// We can start by pinpointing the first value like before. We can also sort the
// array to start out with
// Now, we can keep two pointers at either end of the array.
// We need these two pointers to sum up to the deficit caused by pinpointing
// the first number.
// If the number needs to be smaller, we bring the right pointer down
// If the number needs to be bigger, we bring the left pointer up
// We either will find a combination, or the two pointers will meet
// in the middle, at which point we stop
// This still doesn't handle duplicates, so what we should do is,
// every time before we put something into nums, we should double check
// that it's not already in there.