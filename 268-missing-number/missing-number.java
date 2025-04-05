class Solution {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int pos = nums[i] == Integer.MIN_VALUE ? 0 : Math.abs(nums[i]);
            if (pos == n) continue;
            nums[pos] = nums[pos] == 0 ? Integer.MIN_VALUE : nums[pos] * -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) return i;
        }
        return n;
    }
}
