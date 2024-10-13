class Solution {

    public int maxProduct(int[] nums) {
        int prefix_prod = 1;
        int suffix_prod = 1;
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (prefix_prod == 0) prefix_prod = 1;
            if (suffix_prod == 0) suffix_prod = 1;
            prefix_prod = prefix_prod * nums[i];
            suffix_prod = suffix_prod * nums[n - i - 1];
            max = Math.max(max, prefix_prod);
            max = Math.max(max, suffix_prod);
        }
        return max;
    }
}
