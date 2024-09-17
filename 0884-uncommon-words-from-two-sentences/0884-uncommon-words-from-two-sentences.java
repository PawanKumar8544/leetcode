class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
          String[]words=(s1+" "+s2).split(" ");
        //create hashMap to store frequnce of each word
         HashMap<String,Integer>wordCount=new HashMap<>();
        
        //count occurance
        for(String word:words){
            wordCount.put(word,wordCount.getOrDefault(word,0)+1);
        }
        
        //check once occrance in map
        ArrayList<String>uncommnWord=new ArrayList<>();
        for(Map.Entry<String,Integer>entry:wordCount.entrySet()){
              if(entry.getValue()==1){
                  uncommnWord.add(entry.getKey());
              }
             
        }
         return uncommnWord.toArray(new String[0]);
        
    }
}