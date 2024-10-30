class Solution {

    public void swap(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        int rem = k % (nums.length);
        System.out.println(rem);
        swap(nums, 0, nums.length - 1);
        swap(nums, 0, rem - 1);
        swap(nums, rem, nums.length - 1);
    }
}
