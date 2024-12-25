class Solution {

    public void swap(int[] nums, int ind1, int ind2) {
        int temp = nums[ind1];
        nums[ind1] = nums[ind2];
        nums[ind2] = temp;
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void nextPermutation(int[] nums) {
        int ind1 = -1;
        int ind2 = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind1 = i;
                break;
            }
        }
        if (ind1 == -1) {
            reverse(nums, 0, nums.length - 1);
        } else {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[ind1]) {
                    ind2 = i;
                    break;
                }
            }
            swap(nums, ind1, ind2);
            reverse(nums, ind1 + 1, nums.length - 1);
        }
    }
}
