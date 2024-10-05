class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int lenS1 = s1.length(), lenS2 = s2.length();
        
        // If s1 is longer than s2, s2 cannot contain a permutation of s1
        if (lenS1 > lenS2) {
            return false;
        }
        
        // Create frequency counts for s1 and for the first window of s2
        int[] s1Count = new int[26];
        int[] windowCount = new int[26];
        
        for (int i = 0; i < lenS1; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }
        
        // Compare the counts for the first window
        if (matches(s1Count, windowCount)) {
            return true;
        }
        
        // Slide the window across s2
        for (int i = lenS1; i < lenS2; i++) {
            // Update the window: remove the count of the character left behind
            windowCount[s2.charAt(i - lenS1) - 'a']--;
            // Add the count of the new character
            windowCount[s2.charAt(i) - 'a']++;
            
            // Check if the updated window matches the s1 frequency
            if (matches(s1Count, windowCount)) {
                return true;
            }
        }
        
        return false;
        }
    
    // Helper method to check if two frequency arrays match
    private static boolean matches(int[] s1Count, int[] windowCount) {
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] != windowCount[i]) {
                return false;
            }
        }
        return true;
    }
}