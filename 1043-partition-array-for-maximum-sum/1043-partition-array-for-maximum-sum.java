class Solution {
  public int maxSumAfterPartitioning(int[] arr, int k) {
     int n = arr.length;
    
        int[] dp = new int[n + 1];
      

        for (int i = 1; i <= n; ++i) {
            
            int maxInPartition = 0;
            
            for (int j = i; j > Math.max(0, i - k); --j) {
               
                maxInPartition = Math.max(maxInPartition, arr[j - 1]);
              
                dp[i] = Math.max(dp[i], dp[j - 1] + maxInPartition * (i - j + 1));
            }
        }
        
        return dp[n];
  }
}