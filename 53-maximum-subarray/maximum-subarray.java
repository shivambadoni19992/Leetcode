class Solution {
    public int maxSubArray(int[] nums) {

        int i = 0, n = nums.length;
        int sum = 0, maxSum = Integer.MIN_VALUE;
        
        while(i < n) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if(sum < 0) sum = 0;
            i++;
        }

        return maxSum;
        
    }
}