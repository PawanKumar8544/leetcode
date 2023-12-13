class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n=nums.length;
        int[]ans=new int[n];
         for(int i=0;i<n;i++){
           int  k=0;
             for(int j=0 ;j<n;j++){
                 if(nums[i]>nums[j]){
                     k++;
                 }
                  ans[i]=k;
             }
         }
        return ans;
    }
}