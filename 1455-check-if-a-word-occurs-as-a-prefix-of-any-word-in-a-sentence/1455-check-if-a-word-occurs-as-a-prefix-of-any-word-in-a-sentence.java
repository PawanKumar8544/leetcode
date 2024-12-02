class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
      
        // Iterate through each word in the array.
        for (int i = 0; i < words.length; i++) {
            // Check if the current word starts with the searchWord.
            if (words[i].startsWith(searchWord)) {
                // If it does, return the position of the word in the sentence, noting that index is 1-based.
                return i + 1;
            }
        }
        // If no word in the sentence is prefixed by searchWord, return -1.
        return -1;  
    }
}