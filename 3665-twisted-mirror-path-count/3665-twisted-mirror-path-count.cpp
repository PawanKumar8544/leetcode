class Solution {
public:
    int uniquePaths(const vector<vector<int>> &grid) {
        const int m = grid.size(), n = grid.front().size();
        const int mod = 1e9 + 7;

        vector<pair<int, int>> ways(n, {0, 0}); // left, up
        ways.front() = {0, 1};
        for (int i = 1; i < n && grid[0][i - 1] == 0; ++i) {
            ways[i] = {1, 0};
        }

        for (int i = 1; i < m; ++i) {
            ways.front() = grid[i - 1][0] == 0 && ways.front() == pair<int, int>{0, 1}
                ? pair<int, int>{0, 1}
                : pair<int, int>{0, 0};

            for (int j = 1; j < n; ++j) {
                int backup = ways[j].first;

                ways[j].first =
                    ((grid[i][j - 1] == 1 ? 0 : ways[j - 1].first) + ways[j - 1].second) % mod;
                ways[j].second = ((grid[i - 1][j] == 1 ? 0 : ways[j].second) + backup) % mod;
            }
        }

        return (ways.back().first + ways.back().second) % mod;
    }
};
