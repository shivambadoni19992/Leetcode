class Solution {

    public int removeDuplicates(int[] nums) {
        int i = 1, j = 1;
        while (i < nums.length) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        return j;
    }
}
