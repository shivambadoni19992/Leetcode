class Solution {

    public int maximumCount(int[] nums) {
        int n = nums.length;
        int start = 0, end = n - 1;
        int neg = n, pos = n;
        // if (nums[n - 1] < 0 || nums[0] > 0) return n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < 0) {
                start = mid + 1;
            } else if (nums[mid] >= 0) {
                end = mid - 1;
                neg = mid;
            }
        }
        start = 0;
        end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= 0) {
                start = mid + 1;
            } else if (nums[mid] > 0) {
                end = mid - 1;
                pos = mid;
            }
        }
        return Math.max(n - pos, neg);
    }
}
