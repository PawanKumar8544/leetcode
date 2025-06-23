public class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int length = 1;

        while (count < n) {
            for (long num : generatePalindromes(length)) {
                if (isKPalindrome(num, k)) {
                    sum += num;
                    count++;
                    if (count == n) return sum;
                }
            }
            length++;
        }

        return sum;
    }

    // Generate palindromes of a given length
    private List<Long> generatePalindromes(int length) {
        List<Long> result = new ArrayList<>();

        int half = (length + 1) / 2;
        long start = (long)Math.pow(10, half - 1);
        long end = (long)Math.pow(10, half);

        for (long i = start; i < end; i++) {
            String firstHalf = Long.toString(i);
            StringBuilder sb = new StringBuilder(firstHalf);
            if (length % 2 == 1) {
                sb.setLength(sb.length() - 1);
            }
            String secondHalf = sb.reverse().toString();
            String palindrome = firstHalf + secondHalf;
            result.add(Long.parseLong(palindrome));
        }

        return result;
    }

    // Check if a number is a palindrome in base-k
    private boolean isKPalindrome(long num, int base) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % base);
            num /= base;
        }
        String baseK = sb.toString();
        return baseK.equals(sb.reverse().toString());
    }
}
