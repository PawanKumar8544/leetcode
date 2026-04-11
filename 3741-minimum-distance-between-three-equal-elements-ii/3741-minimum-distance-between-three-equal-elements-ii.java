class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];
        int[] last = new int[n + 1];

        for (int i = 0; i < n; i++) {
            next[i] = -1;
        }
        for (int value = 0; value <= n; value++) {
            last[value] = -1;
        }

        for (int i = n - 1; i >= 0; i--) {
            int value = nums[i];
            next[i] = last[value];
            last[value] = i;
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int second = next[i];
            if (second == -1) {
                continue;
            }

            int third = next[second];
            if (third == -1) {
                continue;
            }

            answer = Math.min(answer, (third - i) * 2);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}