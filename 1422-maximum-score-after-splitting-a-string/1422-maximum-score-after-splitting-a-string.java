class Solution {
    public int maxScore(String s) {
        int ans=0;
        for(int i=0;i<s.length()-1;i++){
            int c=0;
            for(int j=0;j<=i;j++){
                if(s.charAt(j)=='0'){
                    c++;
                }
            }
             for(int j=i+1;j<s.length();j++){
                 if(s.charAt(j)=='1'){
                     c++;
                 }
             }
            ans=Math.max(ans,c);
     
        }
        return ans;
    }
}