class Solution {
  public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, Comparator.comparingInt(interval -> interval[1]));
      
        // Initialize the counter for the minimum number of arrows.
        int arrowCount = 0;
      
        // Use a "lastArrowPosition" variable to track the position of the last arrow.
        // Initialize to a very small value to ensure it is less than the start of any interval.
        long lastArrowPosition = Long.MIN_VALUE;
      
        // Iterate through each interval in the sorted array.
        for (int[] interval : points) {
            int start = interval[0]; // Start of the current interval
            int end = interval[1];   // End of the current interval

            // If the start of the current interval is greater than the "lastArrowPosition",
            // it means a new arrow is needed for this interval.
            if (start > lastArrowPosition) {
                arrowCount++;  // Increment the number of arrows needed.
                lastArrowPosition = end;  // Update the position of the last arrow.
            }
        }

        // Return the minimum number of arrows required to burst all balloons.
        return arrowCount;

  }
}