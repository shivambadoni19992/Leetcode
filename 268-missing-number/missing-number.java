class Solution {
    public int missingNumber(int[] nums) {
        int total_xor = 0;
        int array_xor = 0;
        for(int i = 1; i <= nums.length;i++){
            total_xor = total_xor ^ i;
            array_xor =  array_xor ^ nums[i-1]; 
        }
        return total_xor ^ array_xor;
    }
}