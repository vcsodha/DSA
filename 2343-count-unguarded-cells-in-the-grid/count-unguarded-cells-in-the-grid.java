class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] mat = new int[m][n];
        for (int[] row : walls) {
            mat[row[0]][row[1]] = -1;
        }
        for (int[] row : guards) {
            mat[row[0]][row[1]] = -1;
        }
        for (int[] guard : guards) {
            int row = guard[0];
            int col = guard[1];
            for (int i = row + 1; i < m; i++) {
                if (mat[i][col] == -1) {
                    break;
                }
                mat[i][col] = 1;
            }
            for (int i = row - 1; i >= 0; i--) {
                if (mat[i][col] == -1) {
                    break;
                }
                mat[i][col] = 1;
            }
            for (int i = col + 1; i < n; i++) {
                if (mat[row][i] == -1) {
                    break;
                }
                mat[row][i] = 1;
            }
            for (int i = col - 1; i >= 0; i--) {
                if (mat[row][i] == -1) {
                    break;
                }
                mat[row][i] = 1;
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}