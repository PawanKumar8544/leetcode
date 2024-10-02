class Solution {
    public int[] arrayRankTransform(int[] arr) {
         if(arr.length==0 ||arr==null){
             return new int[0];
         }
        
        //copy array
        int[]sortarr=arr.clone();
        Arrays.sort(sortarr);
        
        //create hasmap to store hashmap
        HashMap<Integer,Integer>map=new HashMap<>();
        int rank=1;
        //Assing rank
        for(int num:sortarr){
            if(!map.containsKey(num)){
                map.put(num,rank);
                rank++;
            }
        }
        
        
        //replace element with rank
        
        int[]ans=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            ans[i]=map.get(arr[i]);
        }
        
        return ans;
    }
}