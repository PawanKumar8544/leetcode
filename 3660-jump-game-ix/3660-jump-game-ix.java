class Solution {
    record Component(int value, int left, int right) {}

    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        List<Component> stack = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Component curr = new Component(nums[i], i, i);

            while (!stack.isEmpty() && stack.get(stack.size() - 1).value() > nums[i]) {
                Component top = stack.remove(stack.size() - 1);
                curr = new Component(
                    Math.max(curr.value(), top.value()),
                    top.left(),
                    curr.right()
                );
            }

            stack.add(curr);
        }

        for (Component component : stack) {
            for (int i = component.left(); i <= component.right(); i++) {
                ans[i] = component.value();
            }
        }

        return ans;
    }
}