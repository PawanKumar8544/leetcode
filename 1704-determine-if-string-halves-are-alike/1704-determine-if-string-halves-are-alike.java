class Solution {
    public boolean halvesAreAlike(String s) {
        int n=s.length();
        int c1=0,c2=0;
        int j=n/2;
        String v="aeiouAEIOU";
        for(int i=0;i<n/2;i++){
           char ch1=s.charAt(i);
            char ch2=s.charAt(j+i);
            
            if(v.indexOf(ch1)!=-1)
                c1++;
             if(v.indexOf(ch2)!=-1)
                c2++;
        }
         return c1==c2;
    }
    
}