class Solution {

    public int atMostK(int[] nums, int k) {
        if(k < 0) return 0;
        int start = 0, end = 0;
        int subArrayCount = 0;
        int oddNumbers = 0;
        while (end < nums.length) {
            if (nums[end] % 2 != 0) {
                oddNumbers++;
            }
            while (start <= end && oddNumbers > k) {
                if (nums[start] % 2 != 0) {
                    oddNumbers--;
                }
                start++;
            }
            
            subArrayCount += (end - start) + 1;
            end++;
        }
        return subArrayCount;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
}
