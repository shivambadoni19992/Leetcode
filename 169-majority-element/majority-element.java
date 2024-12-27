class Solution {

    public int majorityElement(int[] nums) {
        int count = 0, candidate = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate) count++; else {
                count--;
                if (count == 0) {
                    count = 1;
                    candidate = nums[i];
                }
            }
        }
        return candidate;
    }
}
