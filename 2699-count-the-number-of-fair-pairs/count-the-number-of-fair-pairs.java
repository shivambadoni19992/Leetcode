class Solution {

    public int calculateLower(int nums[], int start, int end, int target) {
        int left = start, right = end, ans = end + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public int calculateUpper(int nums[], int start, int end, int target) {
        int left = start, right = end, ans = start - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        long count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int l = calculateLower(nums, i + 1, nums.length - 1, lower - nums[i]);
            int u = calculateUpper(nums, i + 1, nums.length - 1, upper - nums[i]);
            if (l <= u) {
                count += (u - l + 1);
            }
        }
        return count;
    }
}
