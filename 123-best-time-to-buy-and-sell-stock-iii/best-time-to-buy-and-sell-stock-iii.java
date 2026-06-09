class Solution {

    int helper(int ind, int []prices, int buy, int dp[][][], int t) {
        if(ind == prices.length || t == 0) return 0;
        int take = Integer.MIN_VALUE;
        int notTake = Integer.MIN_VALUE;

        if(dp[ind][buy][t] != -1) return dp[ind][buy][t];
        if(buy == 1) {
            take = -prices[ind] + helper(ind + 1, prices, 0, dp, t);
            notTake = helper(ind + 1, prices, 1, dp, t);
        } else {
            take = prices[ind] + helper(ind + 1, prices, 1, dp, t - 1);
            notTake = helper(ind + 1, prices, 0, dp, t);
        }
        return dp[ind][buy][t] = Math.max(take, notTake);
    }
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int dp[][][] = new int[n][2][3];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i][0], -1);
            Arrays.fill(dp[i][1], -1);
        }

        return helper(0, prices, 1, dp, 2);
    }
}