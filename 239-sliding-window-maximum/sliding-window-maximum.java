class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];

        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];

        for (int i = 1; i < n; ++i) {
            if (i % k == 0) left[i] = nums[i]; else left[i] = Math.max(left[i - 1], nums[i]);

            int j = n - i - 1;
            if (j % k == (k - 1)) right[j] = nums[j]; else right[j] = Math.max(right[j + 1], nums[j]);
        }

        for (int i = 0, j = i + k - 1; j < n; ++i, ++j) {
            result[i] = Math.max(right[i], left[j]);
        }

        return result;
    }
}
