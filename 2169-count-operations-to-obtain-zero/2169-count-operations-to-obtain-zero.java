class Solution {
    public int countOperations(int num1, int num2) {
        int ans=0;
         while (num1 >0 && num2 >0){
                 if (num1 < num2){
                    int tem=num1 ;
                     num1=num2 ;
                     num2=tem;

                 }
                 ans +=num1/num2;
                 num1 %=num2;
         }
          return ans;
    }
}