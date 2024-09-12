class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
         HashSet<Character> allowedSet = new HashSet<>();
        
        // Add all characters from the allowed string to the set
        for (char c : allowed.toCharArray()) {
            allowedSet.add(c);
        }
        
        int consistentCount = 0;
        
        // Iterate through each word in the words array
        for (String word : words) {
            boolean isConsistent = true;
            
            // Check if all characters in the word are in the allowed set
            for (char c : word.toCharArray()) {
                if (!allowedSet.contains(c)) {
                    isConsistent = false;
                    break;
                }
            }
            
            // If the word is consistent, increase the count
            if (isConsistent) {
                consistentCount++;
            }
        }
        
        return consistentCount;
    }
}