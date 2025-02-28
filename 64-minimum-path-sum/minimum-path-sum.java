class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        int sum = 0;
        for(int i = 0;i<n;i++){
            sum += grid[i][0];
            dp[i][0] = sum;
        }
        sum = 0;
        for(int i = 0;i<m;i++){
            sum += grid[0][i];
            dp[0][i] = sum;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                int min = Math.min(dp[i-1][j]+ grid[i][j],dp[i][j-1]+grid[i][j]);
                dp[i][j] = min;
            }
        }
        return dp[n-1][m-1];
    }
}