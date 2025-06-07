class Solution {
    public int findDuplicate(int[] nums) {
        // iterate and change the sign of nums[nums[i] -1];

        // if already negative return the number

        for(int i = 0; i  < nums.length; i++){
            int curr = Math.abs(nums[i]);
            if(nums[curr] < 0) {
                return curr;
            }
            nums[curr] = -nums[curr];
        }
        return -1;
    }
}




// arr = [-1 -3 -4 -2 2]  ans = 2