class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> previous = new HashMap<>();
        int answer = nums.length + 1;

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];

            if (previous.containsKey(value)) {
                answer = Math.min(answer, i - previous.get(value));
            }

            previous.put(reverse(value), i);
        }

        return answer == nums.length + 1 ? -1 : answer;
    }

    private int reverse(int value) {
        int reversed = 0;

        while (value > 0) {
            reversed = reversed * 10 + value % 10;
            value /= 10;
        }

        return reversed;
    }
}
