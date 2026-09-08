class Solution {
    public int countCommas(int n) {
         int total = 0;
        int threshold = 1000;

        while (n >= threshold) {
            total += n - threshold + 1;
            threshold *= 1000;
        }

        return total;
    }
}