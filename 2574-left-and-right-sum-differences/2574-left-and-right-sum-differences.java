class Solution {
    public int[] leftRightDifference(int[] nums) {
        //if(nums.length==1)
         //  return nums[0];
        int n=nums.length;
        int[]leftsum=new int[nums.length];
        int[]rightsum=new int[nums.length];
        int[]ans= new int[nums.length];
        
        for(int i=1;i<nums.length;i++){
            leftsum[i]=leftsum[i-1]+nums[i-1];
        }
        for(int i=n-2;i>=0;i--){
            rightsum[i]=rightsum[i+1]+nums[i+1];
        }
         for(int i=0;i<nums.length;i++){
             ans[i]=Math.abs(leftsum[i]-rightsum[i]);
         }
        
        return ans;

    }
}