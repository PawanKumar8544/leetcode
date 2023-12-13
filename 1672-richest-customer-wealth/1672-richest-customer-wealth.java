class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int m=Integer.MIN_VALUE;
        int r=accounts.length, c=accounts[0].length;
        
        for(int i=0;i<r;i++){
            int sum=0;
            for(int j=0;j<accounts[i].length;j++){
               // c2 =c2+accounts[j];
                sum +=accounts[i][j];
            }
            m=Math.max(sum, m);
        }
     return m;
    }
}