class Solution {
    public int minRemoval(int[] nums, int k) {
        // Sort the array to enable binary search and range finding
        Arrays.sort(nums);
      
        // Track the maximum size of valid subarray where max/min <= k
        int maxValidSubarraySize = 0;
        int arrayLength = nums.length;
      
        // For each element as potential minimum value in the subarray
        for (int i = 0; i < arrayLength; ++i) {
            int rightBoundaryIndex = arrayLength;
          
            // Check if current element * k can reach the maximum element
            // This prevents overflow by using long multiplication
            if (1L * nums[i] * k <= nums[arrayLength - 1]) {
                // Find the first element greater than nums[i] * k using binary search
                int targetValue = nums[i] * k + 1;
                rightBoundaryIndex = Arrays.binarySearch(nums, targetValue);
              
                // If target not found, binarySearch returns -(insertion point) - 1
                // Convert to actual insertion point (first element > nums[i] * k)
                rightBoundaryIndex = rightBoundaryIndex < 0 ? -rightBoundaryIndex - 1 : rightBoundaryIndex;
            }
          
            // Update maximum valid subarray size
            // rightBoundaryIndex - i gives the count of elements in range [nums[i], nums[i] * k]
            maxValidSubarraySize = Math.max(maxValidSubarraySize, rightBoundaryIndex - i);
        }
      
        // Return minimum removals needed (total elements - maximum valid subarray)
        return arrayLength - maxValidSubarraySize;
    }
}