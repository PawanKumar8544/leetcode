class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int idx=0;
        int sum=0;
        for(int i:nums){
            int bit=countSetBit(idx++);
            if(bit==k){
                sum +=i;
            }
        }
             return sum;
        }
        
        
         public int countSetBit(int n){
             
             int count=0;
             while(n>0){
                 if(n%2 !=0){
                     count++;
                 }
               n=n/2;
             }
              return count;
         }
        
    
}