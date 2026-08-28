class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];

        // Count characters
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        // Check if palindrome is possible
        int odd = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            if ((cnt[i] & 1) == 1) {
                odd++;
                mid = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        // Remove the middle character
        if (n % 2 == 1) {
            cnt[mid - 'a']--;
        }

        /*
         * cnt now contains pairs.
         * We will construct only the left half.
         */
        int[] left = new int[26];

        for (int i = 0; i < 26; i++) {
            left[i] = cnt[i] / 2;
        }

        int half = n / 2;

        /*
         * First try to make the left half equal to
         * target's left half.
         */
        int[] remain = left.clone();
        boolean possible = true;

        for (int i = 0; i < half; i++) {
            int x = target.charAt(i) - 'a';

            if (remain[x] == 0) {
                possible = false;
                break;
            }

            remain[x]--;
        }

        /*
         * If the left half can equal target's left half,
         * check whether the resulting palindrome itself
         * is already greater than target.
         */
        if (possible) {
            String leftPart = target.substring(0, half);

            StringBuilder rightPart = new StringBuilder(leftPart)
                    .reverse();

            String candidate;

            if (n % 2 == 1) {
                candidate = leftPart + mid + rightPart;
            } else {
                candidate = leftPart + rightPart;
            }

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        /*
         * We need to make the palindrome greater.
         *
         * Find the rightmost position where we can
         * increase target's left-half character.
         */
        for (int i = half - 1; i >= 0; i--) {

            // Rebuild remaining counts for positions after i
            int[] available = left.clone();

            boolean validPrefix = true;

            // Match target[0 ... i-1]
            for (int j = 0; j < i; j++) {
                int x = target.charAt(j) - 'a';

                if (available[x] == 0) {
                    validPrefix = false;
                    break;
                }

                available[x]--;
            }

            if (!validPrefix) {
                continue;
            }

            int current = target.charAt(i) - 'a';

            /*
             * Try the smallest character greater than
             * target[i].
             */
            for (int c = current + 1; c < 26; c++) {

                if (available[c] == 0) {
                    continue;
                }

                available[c]--;

                StringBuilder ans = new StringBuilder();

                // Prefix equal to target
                for (int j = 0; j < i; j++) {
                    ans.append(target.charAt(j));
                }

                // First greater character
                ans.append((char) ('a' + c));

                /*
                 * Fill remaining left half with the
                 * smallest possible characters.
                 */
                for (int ch = 0; ch < 26; ch++) {
                    for (int k = 0; k < available[ch]; k++) {
                        ans.append((char) ('a' + ch));
                    }
                }

                String leftPart = ans.toString();

                // Build palindrome
                StringBuilder result = new StringBuilder(leftPart);

                if (n % 2 == 1) {
                    result.append(mid);
                }

                result.append(new StringBuilder(leftPart).reverse());

                return result.toString();
            }
        }

        return "";
    }
}