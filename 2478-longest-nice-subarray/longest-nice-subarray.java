class Solution {
    public int longestNiceSubarray(int[] nums) {
        int maxSize = 0;
        int used = 0;
        int i = 0 , j = 0;
        while(j<nums.length){
            while((used & nums[j]) != 0){
                used ^=nums[i];
                i++;
            }
            used |= nums[j];
            maxSize = Math.max(maxSize,j-i+1);
            j++;
        }
        return maxSize;
    }
}