class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length;
        int m = mat[0].length;
        long[][] px = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                px[i][j] = mat[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                px[i][j] = mat[i][j];
                if (i > 0) px[i][j] += px[i-1][j];
                if (j > 0) px[i][j] += px[i][j-1];
                if (i > 0 && j > 0) px[i][j] -= px[i-1][j-1];
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = i + max;
                int y = j + max; 
                while (x < n && y < m) {
                    long sum = px[x][y];
                    if (i-1 >= 0) sum -= px[i-1][y];
                    if (j-1 >= 0) sum -= px[x][j-1];
                    if (i-1 >= 0 && j-1 >= 0) sum += px[i-1][j-1];
                    if (sum <= threshold) {
                        max = x - i + 1;
                    }
                    x++;
                    y++;
                }
            }
        }

        return max;
    }
}