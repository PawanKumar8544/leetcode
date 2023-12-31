class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int r=-1;
        int n=s.length();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    r=Math.max(r,j-i-1);
                }
            }
        }
         return r;
    }
}