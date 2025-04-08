class Solution {

    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int front = -1, back = -1;
        if(nums.length == 0) return new int[] { -1, -1 };
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if(nums[mid] == target) front = mid;
        }
        if (front == -1) return new int[] { -1, -1 };
        start = 0;
        end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if(nums[mid] == target) back = mid;
        }

        return new int[] { front, back };
    }
}
