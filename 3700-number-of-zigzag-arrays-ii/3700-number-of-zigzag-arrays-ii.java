class Solution {
    private static final long MOD = 1_000_000_007L;

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;

                for (int j = 0; j < n; j++) {
                    if (B[k][j] == 0) continue;

                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }

    private long[][] power(long[][] base, long exp) {
        int n = base.length;

        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, base);
            }

            base = multiply(base, base);
            exp >>= 1;
        }

        return res;
    }

    private long[] multiply(long[][] A, long[] v) {
        int n = A.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long cur = 0;

            for (int j = 0; j < n; j++) {
                if (A[i][j] == 0) continue;

                cur = (cur + A[i][j] * v[j]) % MOD;
            }

            res[i] = cur;
        }

        return res;
    }

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        int states = 2 * m;

        long[][] T = new long[states][states];

        // First m states:
        // value x, next comparison must be DOWN
        //
        // Next m states:
        // value x, next comparison must be UP

        for (int x = 0; x < m; x++) {

            int downState = x;
            int upState = x + m;

            // from UP(x) -> DOWN(y), y > x
            for (int y = x + 1; y < m; y++) {
                T[y][upState] = 1;
            }

            // from DOWN(x) -> UP(y), y < x
            for (int y = 0; y < x; y++) {
                T[y + m][downState] = 1;
            }
        }

        long[] start = new long[states];

        for (int x = 0; x < m; x++) {
            start[x] = 1;       // start as DOWN
            start[x + m] = 1;   // start as UP
        }

        long[][] P = power(T, n - 1);

        long[] finalVec = multiply(P, start);

        long ans = 0;

        for (long val : finalVec) {
            ans = (ans + val) % MOD;
        }

        return (int) ans;
    }
}