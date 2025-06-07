class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;
        //Xor of the array with xor of range 1 to nums

        for(int i = 1;i <= nums.length; i++) {
            ans = ans ^ i ^ nums[i-1];
        }

        return ans;

    }
}

// arr = 3 0 1
// i = 1 to n (4)

// xor = 3 ^ 0 ^ 1 
// xor = 1 ^ 2 ^ 3 ^ 4 ^1 ^0 ^ 3
// xor = (1 ^1) ^ (3^3) ^(0 ^ 0) ^ 2= 0 ^ 0 ^ 0 ^ 2 => 2;