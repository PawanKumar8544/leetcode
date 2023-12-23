class Solution {
    public int singleNumber(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            ans=nums[i]^ans;
        }
        
        
        return ans;
    }
    
}