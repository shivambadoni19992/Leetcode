class Solution {

    int helper(int ind, int coins[], int amount, int dp[][]) {

        if(amount == 0 && ind == coins.length) return 0;
        if(amount < 0 || ind == coins.length) return Integer.MAX_VALUE - 1;

        if(dp[ind][amount] != -1) return dp[ind][amount];
        int take = 1 + helper(ind, coins, amount - coins[ind], dp);
        int notTake =  helper(ind + 1, coins, amount, dp);
        return dp[ind][amount] = Math.min(take, notTake); 

    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int totalCoins =  helper(0, coins, amount, dp);
        return totalCoins == Integer.MAX_VALUE - 1 ? -1 : totalCoins;
        
    }
}