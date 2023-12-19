class Solution {
    private static final int[][] directions = {
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1}, {0, 0}, {0, 1},
        {1, -1}, {1, 0}, {1, 1}
    };
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;

        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;

                // Iterate over all plausible nine indices.
                for (int[] direction : directions) {
                    // If the indices form a valid neighbor
                    int i_ = i + direction[0];
                    int j_ = j + direction[1];

                    if (0 <= i_ && i_ < m && 0 <= j_ && j_ < n) {
                        sum += img[i_][j_];
                        count += 1;
                    }
                }

                result[i][j] = sum / count;
            }
        }

        return result;
    }
}