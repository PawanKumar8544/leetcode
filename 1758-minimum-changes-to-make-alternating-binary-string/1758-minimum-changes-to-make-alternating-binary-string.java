class Solution {
    public int minOperations(String s) {
      int c1=0,c2=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(i%2!=ch-'0'){
                c1++;
            }
            else{
                c2++;
            }
        }
        return Math.min(c1,c2);
    }
}