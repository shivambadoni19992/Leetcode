class Solution {
    public long maximumTripletValue(int[] nums) {
        long res = 0;
        long diffMax = 0;
        long integerMax = 0;
        for(int i = 0;i<nums.length;i++){
            res = Math.max(res,diffMax * (nums[i]));
            diffMax = Math.max(diffMax,integerMax - nums[i]);
            integerMax = Math.max(integerMax,nums[i]);
        }
        return res;
    }
}