class NumArray {
    Map<Integer, Integer> prefixSum = new HashMap<>();

    public NumArray(int[] nums) {
        prefixSum.put(-1, 0);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum.put(i, sum);
        }
    }
    
    public int sumRange(int left, int right) {
        int start = left - 1;
        int end = right;
        return prefixSum.get(end) - prefixSum.get(start);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */