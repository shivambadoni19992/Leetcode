class Solution {

    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                min = Math.min(min, nums[low]);
                low++;
                high--;
                continue;
            }
            
            if (nums[mid] >= nums[low]) {
                min = Math.min(nums[low], min);
                low = mid + 1;
            } else {
                min = Math.min(nums[mid], min);
                high = mid - 1;
            }
        }
        return min;
    }
}
