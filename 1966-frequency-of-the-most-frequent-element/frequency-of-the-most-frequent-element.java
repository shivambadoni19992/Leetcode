class Solution {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0, end = 0;
        int max = 0;
        long totalSum = 0;
        while (end < nums.length) {
            totalSum += nums[end];
            while (((long) nums[end] * (end - start + 1)) > (totalSum + k)) {
                totalSum = totalSum - nums[start];
                start++;
            }
            max = Math.max(max, end - start + 1);
            end++;
        }
        return max;
    }
}
