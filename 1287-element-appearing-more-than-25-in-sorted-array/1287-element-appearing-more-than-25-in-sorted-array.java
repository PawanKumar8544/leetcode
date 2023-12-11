class Solution {
    public int findSpecialInteger(int[] arr) {
        int n=arr.length/4;
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i:arr){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
         for(Map.Entry<Integer,Integer>e :hm.entrySet()){
              if(e.getValue()>n)
                   return e.getKey();
         }
         return 0;
    }
}