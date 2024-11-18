class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];
        
        if (k == 0) {
            // If k == 0, return an array of zeros
            return result;
        }
        
        // If k > 0, we sum the next k elements to the right of index i (circularly)
        if (k > 0) {
            for (int i = 0; i < n; i++) {
                int sum = 0;
                // Sum the next k elements (circular)
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n];
                }
                result[i] = sum;
            }
        }
        // If k < 0, we sum the previous k elements to the left of index i (circularly)
        else {
            for (int i = 0; i < n; i++) {
                int sum = 0;
                // Sum the previous k elements (circular)
                for (int j = 1; j <= -k; j++) {
                    sum += code[(i - j + n) % n];  // (i - j + n) ensures the index is non-negative
                }
                result[i] = sum;
            }
        }
        
        return result;
    }
}
