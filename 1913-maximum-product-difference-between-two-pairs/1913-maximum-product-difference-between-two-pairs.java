class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        //get maximum two
        int a=nums[n-1];
        int b=nums[n-2];
        //get minimum value
        int c=nums[0];
        int d=nums[1];
        return Math.abs((a*b)-(c*d));
        
        
        
    }
}