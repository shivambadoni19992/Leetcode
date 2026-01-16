class Solution {
    public int removeDuplicates(int[] nums) {
        
        
        int i = 0, j = 0, n = nums.length;
        while(j < n) {

            while(j + 1 < n && nums[j] == nums[j + 1]) {
                j++;
            }
            nums[i++] = nums[j];
            j++;

        }
        return i;
    }
}