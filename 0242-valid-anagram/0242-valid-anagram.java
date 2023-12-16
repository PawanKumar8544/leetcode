class Solution {
    public boolean isAnagram(String s, String t) {
     int s1=s.length(), t1=t.length();
        if(s1 !=t1) return false;
         Map<Character, Integer> map=new HashMap<>();
        for(int i=0;i<s1;i++){
            char ch=s.charAt(i);
            char dh=t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
             map.put(dh,map.getOrDefault(dh,0)-1);  

        }
          for(int i:map.values()){
              if(i !=0){
                  return false;
              }
          }
   return true;
            
        
    }
}