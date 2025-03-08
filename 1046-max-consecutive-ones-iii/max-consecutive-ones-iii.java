class Solution {

    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, count = 0, maxC = 0, len = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                count++;
            }
            while (count > k) {
                if (nums[left] == 0) count--;
                left++;
            }

            right++;
            maxC = Math.max(maxC, right - left);
        }

        return maxC;
    }
}
