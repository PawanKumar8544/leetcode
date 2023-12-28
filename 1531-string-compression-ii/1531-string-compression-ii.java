class Solution {
     int[][] dp;
    int n;
    public int getLengthOfOptimalCompression(String s, int k) {
        this.n = s.length();
        this.dp = new int[n][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, k,s);
    }
    
    private int helper(int i, int k,String s) {
        if (k < 0) return n;
        if (n <= i + k) return 0;

        int ans = dp[i][k];
        if (ans != -1) return ans;
        ans = helper(i + 1, k - 1,s);
        int length = 0, same = 0, diff = 0;

        for (int j = i; j < n && diff <= k; j++) {
            if (s.charAt(j) == s.charAt(i)) {
                same++;
                if (same <= 2 || same == 10 || same == 100) length++;
            } else {
                diff++;
            }
            ans = Math.min(ans, length + helper(j + 1, k - diff,s));
        }
        dp[i][k] = ans;
        return ans;
    }
}