class Solution {
    int m;
    int n;
    int[][] memo;
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        memo = new int[m][n];
        return dp(0,0);
    }
    public int dp(int r,int c){
        if(r==m-1 && c==n-1) return 1;
        if(memo[r][c]!=0) return memo[r][c];

        int count = 0;

        int[] dr = {1,0};
        int[] dc = {0,1};

        for(int i=0;i<2;i++){
            int nr = r+dr[i], nc = c+dc[i];
            if(nr>=0 && nc>=0 && nr<m && nc<n)
            count+=dp(nr,nc);
        }

        return memo[r][c] = count;
    }
}