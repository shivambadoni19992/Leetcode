class Solution {

    boolean helper(int ind, int nums[], int target, int dp[][]) {
        if(ind >= nums.length || target < 0) return false;
        if(target == 0) return true;
        if(dp[ind][target] != -1) return dp[ind][target] == 1;

        boolean take = helper(ind + 1, nums, target - nums[ind], dp);
        boolean notTake = helper(ind + 1, nums, target, dp);

        dp[ind][target] = (take || notTake) ? 1 : 0;
        return dp[ind][target] == 1;
    }
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        int dp[][] = new int[nums.length][sum];
        for(int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return sum % 2 == 1 ? false : helper(0, nums, sum / 2, dp);
        
    }
}