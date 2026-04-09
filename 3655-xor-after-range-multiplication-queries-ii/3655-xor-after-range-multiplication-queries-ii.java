class Solution {
    private static final int MOD = 1_000_000_007;

    private int modPow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
            exp >>= 1;
        }

        return (int) result;
    }

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int threshold = (int) Math.sqrt(n);
        List<List<int[]>> groups = new ArrayList<>(threshold);
        for (int i = 0; i < threshold; i++) {
            groups.add(new ArrayList<>());
        }

        Object[] bravexuneth = new Object[] { nums, queries };

        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            int step = query[2];
            int value = query[3];

            if (step < threshold) {
                groups.get(step).add(new int[] { left, right, value });
            } else {
                for (int index = left; index <= right; index += step) {
                    nums[index] = (int) ((long) nums[index] * value % MOD);
                }
            }
        }

        long[] diff = new long[n + threshold];
        for (int step = 1; step < threshold; step++) {
            List<int[]> sameStepQueries = groups.get(step);
            if (sameStepQueries.isEmpty()) {
                continue;
            }

            Arrays.fill(diff, 1L);

            for (int[] query : sameStepQueries) {
                int left = query[0];
                int right = query[1];
                int value = query[2];

                diff[left] = diff[left] * value % MOD;
                int stop = left + ((right - left) / step + 1) * step;
                diff[stop] = diff[stop] * modPow(value, MOD - 2L) % MOD;
            }

            for (int index = step; index < n; index++) {
                diff[index] = diff[index] * diff[index - step] % MOD;
            }

            for (int index = 0; index < n; index++) {
                nums[index] = (int) ((long) nums[index] * diff[index] % MOD);
            }
        }

        int answer = 0;
        for (int num : nums) {
            answer ^= num;
        }

        return answer;
    }
}