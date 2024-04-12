class Solution {
    public String removeStars(String s) {
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != '*'){
                st.push(s.charAt(i));
            continue;
            }
            else {
                st.pop();
            }
            
        }
        
        if(st.isEmpty()) return "";
        StringBuilder sb=new StringBuilder();
         while(!st.isEmpty()){
             sb.append(st.pop());
         }
           return sb.reverse().toString();
    }
}