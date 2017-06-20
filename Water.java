public class Water {

    public static void main(String[] args) {
      int[] arr = {15, 1, 3, 17, 4};
      System.out.println(maxArea(arr));
    }


    public static int maxArea(int[] height) {
        int totalWater = 0;
        int width = 0;
        int currMax = height[0];
        int currNextMax = -1; //the tallest sequential thing I can find that is less than currMax

        for (int i = 1; i < height.length; i++) {
          if((height[i] <= currMax) && (height[i] > currNextMax)) {
               currNextMax = height[i];
               width += 1;
              //  System.out.println("I made it hereee");
              //  return 308;
           }else if(height[i] > currMax) {
               // we've reached a stopping point
               width++;
               if (currNextMax == -1) {
                   // we never set currNextMax, so the area is as follows
                   totalWater += (currMax);
               }else {
                   // we set currNextMax so the area is as follows
                   totalWater += (currMax * width);
               }
               width = 0;
               currMax = height[i];
               currNextMax = -1;
              //  return 342;
           }
          //  return 484;
        }
        if (width != 0) {
            totalWater += (currNextMax * width);
            // return 42;
        }

        return totalWater;
    }
}
