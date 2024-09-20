class Solution {
    public String addBinary(String a, String b) {
           int n1=a.length()-1;
           int n2=b.length()-1;
        StringBuilder ans=new StringBuilder();
        int carry=0;
    while(n1>=0 || n2>=0 || carry==1){
        int sum=carry;
        if(n1>=0){
            sum +=a.charAt(n1--)-'0';
        }
        if(n2>=0){
            sum +=b.charAt(n2--)-'0';
        }
        
        ans.append(sum%2);
        carry=sum/2;
        
    }
         return ans.reverse().toString();
    }
}