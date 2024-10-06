class Solution {
    public int maxSubArray(int[] nums) {
        int max_sum = Integer.MIN_VALUE;
        int curr_sum = 0;
        int i=0;
        int j=0;
        while(j<nums.length){
            curr_sum+=nums[j];
            max_sum= Math.max(curr_sum,max_sum);
            if(curr_sum<0) curr_sum=0;
            j++;
        }
        return max_sum;
    }
}