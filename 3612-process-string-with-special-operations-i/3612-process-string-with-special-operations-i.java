class Solution {
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();
      
        // Iterate through each character in the input string
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                // Append letter characters directly to result
                result.append(c);
            } else if (c == '*') {
                // Remove last character (backspace operation)
                // Use Math.max to ensure length doesn't go below 0
                result.setLength(Math.max(0, result.length() - 1));
            } else if (c == '#') {
                // Duplicate the current result by appending it to itself
                result.append(result);
            } else if (c == '%') {
                // Reverse the current result string
                result.reverse();
            }
            // Other characters are ignored
        }
      
        // Convert StringBuilder to String and return
        return result.toString();
    }
}