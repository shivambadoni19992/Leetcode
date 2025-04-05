class Solution {

    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int pos = nums[i] == Integer.MIN_VALUE ? 0 : Math.abs(nums[i]);
            if (pos == nums.length) continue;
            nums[pos] = nums[pos] == 0 ? Integer.MIN_VALUE : nums[pos] * -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) return i;
        }
        return nums.length;
    }
}
