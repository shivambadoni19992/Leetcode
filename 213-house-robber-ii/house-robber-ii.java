class Solution {

    int helper(int start, int end, int[] nums, int ind, int[] dp) {
        if (ind > end) return 0;
        if (dp[ind] != -1) return dp[ind];
        dp[ind] = Math.max(nums[ind] + helper(start, end, nums, ind + 2, dp), helper(start, end, nums, ind + 1, dp));
        return dp[ind];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0]; 

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int rob1 = helper(0, n - 2, nums, 0, dp1);
        int rob2 = helper(1, n - 1, nums, 1, dp2);

        return Math.max(rob1, rob2);
    }
}
