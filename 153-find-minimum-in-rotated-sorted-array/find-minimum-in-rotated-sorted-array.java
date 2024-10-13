class Solution {

    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        int left = 0, right = n-1;
        int mid = left + (right - left) / 2;
        while (left <= right) {
            if (nums[left] <= nums[mid]) {
                min = Math.min(min, nums[left]);
                left = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                right = mid-1;
            }
            mid = left + (right - left) / 2;
        }
        return min;
    }
}
