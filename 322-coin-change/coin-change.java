class Solution {

    int helper(int i, int a, int coins[], int dp[][]) {
        if(a == 0 && coins.length == i) return 0;
        if(a < 0 || coins.length == i) return Integer.MAX_VALUE - 1;

        if(dp[i][a] != -1) return dp[i][a];

        int take = 1 + helper(i, a - coins[i], coins, dp);
        int notTake = helper(i + 1, a, coins, dp);

        return dp[i][a] = Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {

        int dp[][] = new int[coins.length][amount + 1];

        for(int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int value = helper(0, amount, coins, dp);
        return value >= Integer.MAX_VALUE - 1  ? -1 : value;

        
    }
}