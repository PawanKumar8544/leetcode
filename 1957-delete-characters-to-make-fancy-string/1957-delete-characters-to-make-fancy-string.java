class Solution {
    // Method to transform the input string into a fancy string
    // A fancy string is a string where no three consecutive characters are equal
    public String makeFancyString(String s) {
        // StringBuilder is initialized to build the fancy string efficiently
        StringBuilder fancyString = new StringBuilder();
      
        // Iterate over each character in the input string
        for (char currentChar : s.toCharArray()) {
            // Calculate the length of the current fancyString
            int currentLength = fancyString.length();
          
            // Check if the last two characters in fancyString are the same as the current character
            if (currentLength > 1 && 
                fancyString.charAt(currentLength - 1) == currentChar && 
                fancyString.charAt(currentLength - 2) == currentChar) {
                // If true, continue to the next iteration to avoid adding a third consecutive character
                continue;
            }
          
            // Append the current character to fancyString
            fancyString.append(currentChar);
        }
      
        // Convert the StringBuilder to a String and return it
        return fancyString.toString();
    }
}