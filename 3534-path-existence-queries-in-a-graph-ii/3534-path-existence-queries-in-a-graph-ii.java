class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        final int LOG = 18;

        // Pair each value with its original index, then sort by value.
        int[][] sorted = new int[n][2];
        for (int i = 0; i < n; i++) sorted[i] = new int[]{nums[i], i};
        Arrays.sort(sorted, (a, b) -> a[0] - b[0]);

        // pos[original index] = where that node sits in sorted order.
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) pos[sorted[i][1]] = i;

        // st[i][0] = farthest sorted index directly reachable to the right of i.
        int[][] st = new int[n][LOG];
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (r < i) r = i;
            while (r + 1 < n && sorted[r + 1][0] - sorted[i][0] <= maxDiff) r++;
            st[i][0] = r;
        }

        // Binary lifting: st[i][j] = farthest index reachable from i in 2^j jumps.
        for (int j = 1; j < LOG; j++)
            for (int i = 0; i < n; i++)
                st[i][j] = st[st[i][j - 1]][j - 1];

        int[] ans = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int a = pos[queries[q][0]];
            int b = pos[queries[q][1]];
            if (a > b) { int t = a; a = b; b = t; }
            if (a == b) { ans[q] = 0; continue; }

            int curr = a, steps = 0;
            for (int j = LOG - 1; j >= 0; j--) {
                if (st[curr][j] < b) {
                    curr = st[curr][j];
                    steps += (1 << j);
                }
            }
            ans[q] = (st[curr][0] >= b) ? steps + 1 : -1;
        }
        return ans;
    }
}