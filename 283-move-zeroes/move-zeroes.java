class Solution {

    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                j++;
            } else if (j > 0) {
                nums[i - j] = nums[i];
                nums[i] = 0;
            }
            i++;
        }
    }
}
