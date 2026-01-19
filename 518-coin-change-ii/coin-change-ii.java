class Solution {

    int helper(int ind, int coins[], int amount, int dp[][]) {
        if(ind == coins.length && amount == 0) return 1;
        if(ind == coins.length || amount < 0) return 0;

        if(dp[ind][amount] != -1) return dp[ind][amount];
        int take = helper(ind, coins, amount - coins[ind], dp);
        int notTake = helper(ind + 1, coins, amount, dp);

        return dp[ind][amount] = take + notTake;
    }
    public int change(int amount, int[] coins) {

        int n = coins.length;
        int dp[][] = new int[n][amount + 1];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(0, coins, amount, dp);
        
    }
}