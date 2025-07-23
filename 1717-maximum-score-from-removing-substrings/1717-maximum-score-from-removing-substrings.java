public class Solution {

    // Method to calculate the maximum gain by removing pairs of 'ab' or 'ba'.
    public int maximumGain(String s, int x, int y) {
        // If the gain from 'ba' is higher, reverse the string and swap the gains to reuse the same logic.
        if (x < y) {
            return maximumGain(new StringBuilder(s).reverse().toString(), y, x);
        }
      
        int totalGain = 0; // Initialize total gain to 0.
        Deque<Character> stack1 = new ArrayDeque<>(); // Use a stack for checking 'ab' pairs.
        Deque<Character> stack2 = new ArrayDeque<>(); // Use a secondary stack for checking 'ba' pairs after 'ab'.
      
        // Process the string for 'ab' pairs first, which has a higher or equal gain compared to 'ba'.
        for (char charInString : s.toCharArray()) {
            // If the current character is not 'b', push onto the stack.
            if (charInString != 'b') {
                stack1.push(charInString);
            } else {
                // If the top of stack is 'a', we found an 'ab' pair; pop 'a' and add the gain of 'ab' to totalGain.
                if (!stack1.isEmpty() && stack1.peek() == 'a') {
                    stack1.pop();
                    totalGain += x;
                } else {
                    // Else, push 'b' onto the stack to check for future pairs.
                    stack1.push(charInString);
                }
            }
        }
      
        // Process the remaining characters in stack1 for 'ba' pairs.
        while (!stack1.isEmpty()) {
            char currentChar = stack1.pop();
            if (currentChar != 'b') {
                stack2.push(currentChar);
            } else {
                // If the top of stack2 is 'a', we found a 'ba' pair; pop 'a' and add the gain of 'ba' to totalGain.
                if (!stack2.isEmpty() && stack2.peek() == 'a') {
                    stack2.pop();
                    totalGain += y;
                } else {
                    // Else, push 'b' onto stack2 to continue checking.
                    stack2.push(currentChar);
                }
            }
        }
      
        return totalGain; // Return the total gain calculated.
    }
}