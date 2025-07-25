import java.util.Arrays;

class Solution {
    public int maxSum(int[] nums) {
        // Find the maximum value in the array
        int max = Arrays.stream(nums).max().getAsInt();
      
        // If the maximum value is less than or equal to 0, return it
        if (max <= 0) {
            return max;
        }
      
        // Boolean array to keep track of numbers that have been added to the sum
        boolean[] seen = new boolean[201]; // Assuming numbers are within the range of 0 to 200
        int result = 0; // Initialize the sum
      
        // Iterate through each number in the array
        for (int num : nums) {
          
            // If the number is negative or has already been added, skip it
            if (num < 0 || seen[num]) {
                continue;
            }
          
            // Add the number to the sum and mark it as seen
            result += num;
            seen[num] = true;
        }
      
        // Return the calculated sum
        return result;
    }
}