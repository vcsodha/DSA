class Solution {
    static final int INF = 1_000_000_000;
    public int minCost(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int value = 0;
        for (int[] row : grid) {
            for (int x : row) value = Math.max(value, x);
        }

        int[][][] dp = new int[k + 1][n][m];
        for (int p = 0; p <= k; p++) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[p][i], INF);
            }
        }

        int[] preset = new int[value + 1];
        Arrays.fill(preset, INF);

        for (int p = 0; p <= k; p++) {
            int[] current = new int[value + 1];
            Arrays.fill(current, INF);

            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {

                    if (i == n - 1 && j == m - 1) {
                        dp[p][i][j] = 0;
                    } else {
                        int ans = INF;

                        if (i + 1 < n) {
                            ans = Math.min(ans, grid[i + 1][j] + dp[p][i + 1][j]);
                        }
                        if (j + 1 < m) {
                            ans = Math.min(ans, grid[i][j + 1] + dp[p][i][j + 1]);
                        }
                        if (p > 0) {
                            int v = grid[i][j];
                            if (v <= value) ans = Math.min(ans, preset[v]);
                        }

                        dp[p][i][j] = ans;
                    }
                    int v = grid[i][j];
                    current[v] = Math.min(current[v], dp[p][i][j]);
                }
            }
            Arrays.fill(preset, INF);
            preset[0] = current[0];
            for (int r = 1; r <= value; r++) {
                preset[r] = Math.min(preset[r - 1], current[r]);
            }
        }
        return dp[k][0][0];
    }
}
