import java.util.*;

class Solution {

    private String num;
    private long[][][][] memoCnt;
    private long[][][][] memoSum;
    private boolean[][][][] seen;

    public long totalWaviness(long num1, long num2) {
        return calc(num2) - calc(num1 - 1);
    }

    private long calc(long x) {
        if (x <= 0) return 0;

        num = String.valueOf(x);
        int n = num.length();

        memoCnt = new long[n + 1][11][11][2];
        memoSum = new long[n + 1][11][11][2];
        seen = new boolean[n + 1][11][11][2];

        return dfs(0, 10, 10, 0, true)[1];
    }

    // returns {countNumbers, totalWaviness}
    private long[] dfs(int pos, int prev2, int prev1, int started, boolean tight) {
        if (pos == num.length()) {
            return new long[]{1, 0};
        }

        if (!tight && seen[pos][prev2][prev1][started]) {
            return new long[]{
                memoCnt[pos][prev2][prev1][started],
                memoSum[pos][prev2][prev1][started]
            };
        }

        long count = 0;
        long sum = 0;

        int limit = tight ? num.charAt(pos) - '0' : 9;

        for (int d = 0; d <= limit; d++) {
            boolean nextTight = tight && d == limit;

            int nPrev2 = prev2;
            int nPrev1 = prev1;
            int nStarted = started;

            int addWave = 0;

            if (started == 0 && d == 0) {
                long[] child = dfs(pos + 1, 10, 10, 0, nextTight);
                count += child[0];
                sum += child[1];
                continue;
            }

            if (started == 0) {
                nStarted = 1;
                nPrev1 = d;
                nPrev2 = 10;
            } else {
                if (prev2 != 10) {
                    if ((prev1 > prev2 && prev1 > d) ||
                        (prev1 < prev2 && prev1 < d)) {
                        addWave = 1;
                    }
                }

                nPrev2 = prev1;
                nPrev1 = d;
            }

            long[] child = dfs(pos + 1, nPrev2, nPrev1, nStarted, nextTight);

            count += child[0];
            sum += child[1] + child[0] * addWave;
        }

        if (!tight) {
            seen[pos][prev2][prev1][started] = true;
            memoCnt[pos][prev2][prev1][started] = count;
            memoSum[pos][prev2][prev1][started] = sum;
        }

        return new long[]{count, sum};
    }
}