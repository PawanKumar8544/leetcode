class Solution {
    static final long MOD = 1_000_000_007;

    public int countTrapezoids(int[][] points) {
        // Count points per Y-level
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        for (int[] p : points) {
            map.merge(p[1], 1, Integer::sum);
        }

        long sumEdges = 0;       // sum(ei)
        long sumSquares = 0;     // sum(ei^2)

        for (int cnt : map.values()) {
            if (cnt >= 2) {
                long e = (long)cnt * (cnt - 1) / 2;  // number of horizontal edges
                e %= MOD;

                sumEdges = (sumEdges + e) % MOD;
                sumSquares = (sumSquares + (e * e) % MOD) % MOD;
            }
        }

        // Formula: (S^2 - SQ) / 2
        long S = sumEdges;
        long SQ = sumSquares;

        long ans = (S * S % MOD - SQ + MOD) % MOD;
        ans = ans * ((MOD + 1) / 2) % MOD; // divide by 2 with modular inverse

        return (int) ans;
    }
}
