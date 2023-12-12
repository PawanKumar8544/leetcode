class Solution {
    public int maxProduct(int[] nums) {
       Arrays.sort(nums);
        int i=nums[nums.length-1]-1;
        int j=nums[nums.length-2]-1;
         return i*j;
    }
}