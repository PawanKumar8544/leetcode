class Solution {

    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();

        int[] count = new int[26];

        // Count characters in s
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // Match target from left to right
        int matched = 0;

        while (matched < n) {

            int c = target.charAt(matched) - 'a';

            if (count[c] == 0) {
                break;
            }

            count[c]--;
            matched++;
        }

        // Backtrack from the rightmost possible position
        for (int pos = Math.min(matched, n - 1); pos >= 0; pos--) {

            // Restore the character at this position
            if (pos < matched) {
                count[target.charAt(pos) - 'a']++;
            }

            int targetChar = target.charAt(pos) - 'a';

            // Find the smallest character greater than target[pos]
            for (int c = targetChar + 1; c < 26; c++) {

                if (count[c] > 0) {

                    count[c]--;

                    StringBuilder result = new StringBuilder();

                    // Keep the prefix equal to target
                    result.append(target, 0, pos);

                    // Make the current position greater
                    result.append((char) ('a' + c));

                    // Add remaining characters in sorted order
                    for (int x = 0; x < 26; x++) {
                        while (count[x] > 0) {
                            result.append((char) ('a' + x));
                            count[x]--;
                        }
                    }

                    return result.toString();
                }
            }
        }

        return "";
    }
}
