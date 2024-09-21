class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        // Start DFS for every number from 1 to 9
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, result);
        }
        return result;
    }

    private void dfs(int current, int n, List<Integer> result) {
        if (current > n) {
            return;
        }
        // Add the current number to the result
        result.add(current);
        
        // Try to generate the next number by appending digits
        for (int i = 0; i <= 9; i++) {
            int next = current * 10 + i;
            if (next > n) {
                break;
            }
            dfs(next, n, result);
    }
    }
}