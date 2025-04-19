class NumArray {
    int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        int i = 1;
        for (int num : nums) {
            sum[i] = sum[i - 1] + num;
            i++;
        }
    }

    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
