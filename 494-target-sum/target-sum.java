class Solution {

    int helper(int ind, int []nums, int target, int sum, Map<String, Integer> dp) {
        if(nums.length == ind && sum == target) return 1;
        if(nums.length == ind) return 0;

        if(dp.containsKey(ind + " " + sum)) return dp.get(ind + " " + sum);

        int minus = helper(ind + 1, nums, target , sum - nums[ind], dp);
        int plus = helper(ind + 1, nums, target , sum + nums[ind], dp);
        int total = minus + plus;
        dp.put(ind + " " + sum, total);
        return total;
    }
    public int findTargetSumWays(int[] nums, int target) {

        Map<String, Integer> dp = new HashMap<>();

        return helper(0, nums, target, 0, dp);


        
    }
}