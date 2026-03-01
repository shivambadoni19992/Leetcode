class Solution {

    int helper(int ind, int [][]pairs, int b, int [][]dp) {
        if(ind == pairs.length) return 0;
        
        if(dp[ind][b + 1] != -1) return dp[ind][b + 1];
        int take = Integer.MIN_VALUE;

        if(b == -1 || pairs[ind][0] > pairs[b][1]) {
            take = 1 + helper(ind + 1, pairs, ind, dp);
        }
        int notTake = helper(ind + 1, pairs, b, dp);
        return dp[ind][b + 1] = Math.max(take, notTake);
        
    }
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        int n = pairs.length;
        int dp[][] = new int[n][n + 1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        } 
        return helper(0, pairs, -1, dp);
    }
}