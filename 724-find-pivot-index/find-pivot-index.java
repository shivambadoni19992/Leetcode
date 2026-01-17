class Solution {
    public int pivotIndex(int[] nums) {
        int suffixSum[] = new int[nums.length];

        int sum = 0;
        for(int i = nums.length - 2; i >= 0; i--) {
            sum += nums[i + 1];
            suffixSum[i] = sum;
        }

        if(suffixSum[0] == 0) return 0;

        sum = 0;
        for(int i = 0; i < nums.length; i++) {
            
            if(suffixSum[i] == sum) return i;
            sum += nums[i];
        }
        return sum - nums[nums.length - 1] == 0 ? nums.length - 1 : -1;
        
    }
}