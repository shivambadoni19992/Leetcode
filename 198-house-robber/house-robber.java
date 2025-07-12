class Solution {

    int helper(int []nums, int ind,int []dp) {
        if(ind >= nums.length) return 0;
        if(dp[ind] != -1) return dp[ind];
        dp[ind] = Math.max(nums[ind] + helper(nums,ind+2,dp), helper(nums,ind+1,dp));
        return dp[ind];
    }
    public int rob(int[] nums) {
        int []dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,0,dp);
    }
}