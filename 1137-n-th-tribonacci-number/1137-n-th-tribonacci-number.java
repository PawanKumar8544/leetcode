class Solution {
    public int tribonacci(int n) {
        if(n<2)
            return n;
        int[]ans={0,1,1};
        for(int i=3;i<=n;i++){
            int next=ans[0]+ans[1]+ans[2];
            ans[0]=ans[1];
            ans[1]=ans[2];
            ans[2]=next;
            
        }
        return ans[2];
    }
}