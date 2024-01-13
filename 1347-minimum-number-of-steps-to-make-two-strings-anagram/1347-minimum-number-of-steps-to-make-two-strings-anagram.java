class Solution {
    public int minSteps(String s, String t) {
        int []ans= new int[26];
        int count=0;
        for(int i=0;i<s.length();i++){
            ans[s.charAt(i)-'a']++;
            ans[t.charAt(i)-'a']--;
            
        }
         for(int i=0;i<26;i++){
             if(ans[i]>0)
                 count+=ans[i];
         }
         return count;
    }
}