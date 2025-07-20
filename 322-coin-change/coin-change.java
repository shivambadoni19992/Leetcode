class Solution {
    public int helper(int ind, int[] coins, int amount, int[][] memo) {
        if (amount == 0) return 0;
        if (ind == coins.length || amount < 0) return Integer.MAX_VALUE - 1;

        if (memo[ind][amount] != -1) return memo[ind][amount];

        int take = Integer.MAX_VALUE - 1;
        if (coins[ind] <= amount) {
            take = 1 + helper(ind, coins, amount - coins[ind], memo);
        }
        int notTake = helper(ind + 1, coins, amount, memo);

        return memo[ind][amount] = Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {
        int[][] memo = new int[coins.length][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int result = helper(0, coins, amount, memo);
        return result == Integer.MAX_VALUE - 1 ? -1 : result;
    }
}
