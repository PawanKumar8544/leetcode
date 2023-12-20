class Solution {
    public int buyChoco(int[] prices, int money) {
        int ans=0;
        Arrays.sort(prices);
        int min=prices[0];
        int secMin=prices[1];
        
           if(min+secMin > money){
               return money;
           }
           else{
               ans=Math.abs(min+secMin-money);
           }
        return ans;
    }
}